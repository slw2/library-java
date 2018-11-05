package com.example.sophie.library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Loans extends Database {

    private Books books;
    private Users users;

    public Loans(Context context) {
        super(context);
        this.books = new Books(context);
        this.users = new Users(context);
    }

    private static final String TABLE_LOANS = "loans";
    private static final String TABLE_BOOKS = "books";

    private static final String KEY_BOOK_ID = "book_id";
    private static final String KEY_USER_ID = "user_id";

    private static final String[] COLUMNS = {KEY_BOOK_ID,KEY_USER_ID};

    public void borrow(Book book, User user) {

        Cursor cursor = db().query(TABLE_LOANS, COLUMNS, "book_id = ?", new String[]{String.valueOf(book.getId())},
                null, null, null, null);

        if (cursor.getCount() == 0) {
            ContentValues values = new ContentValues();
            values.put(KEY_BOOK_ID, book.getId());
            values.put(KEY_USER_ID, user.getId());

            db().insert(TABLE_LOANS, null, values);
        }
    }

    public void return_book(Book book) {
        db().delete(TABLE_LOANS,"book_id = ?",
                new String[] { String.valueOf(book.getId()) });
    }

    public List<Book> loans(User user) {
        List<Book> on_loan = new LinkedList<>();

        Cursor cursor = db().query(TABLE_LOANS, COLUMNS, "user_id = ?", new String[]{String.valueOf(user.getId())},
                null, null, null, null);

        Book book;
        if (cursor.moveToFirst()) {
            do {
                book = books.booksearch_by_id(Integer.parseInt(cursor.getString(0)));
                on_loan.add(book);
            } while (cursor.moveToNext());
        }
        return on_loan;
    }

    public List<Book> books_loaned(){
        List<Book> books_on_loan = new LinkedList<>();

        String query = "SELECT  * FROM " + TABLE_LOANS;

        Cursor cursor = db().rawQuery(query, null);

        Book book;
        if (cursor.moveToFirst()) {
            do {
                book = books.booksearch_by_id(Integer.parseInt(cursor.getString(0)));
                books_on_loan.add(book);
            } while (cursor.moveToNext());
        }
        return books_on_loan;
    }

    public List<Book> books_not_loaned() {
        List<Book> books_in_lib = new LinkedList<>();

        String query = "SELECT  * FROM " + TABLE_BOOKS + " WHERE " + Books.KEY_ID + " NOT IN (SELECT book_id FROM " + TABLE_LOANS + ")";

        Cursor cursor = db().rawQuery(query, null);

        Book book;
        if (cursor.moveToFirst()) {
            do {
                book = books.booksearch_by_id(Integer.parseInt(cursor.getString(0)));
                books_in_lib.add(book);
            } while (cursor.moveToNext());
        }
        return books_in_lib;
    }

    public List<User> users_with_loans() {
        List<User> loaners = new LinkedList<>();

        String query = "SELECT  * FROM " + TABLE_LOANS;

        Cursor cursor = db().rawQuery(query, null);

        User user;
        if (cursor.moveToFirst()) {
            do {
                user = users.usersearch_by_id(Integer.parseInt(cursor.getString(1)));
                loaners.add(user);
            } while (cursor.moveToNext());
        }
        return loaners;
    }

    public Boolean is_book_on_loan(Integer book_id){

        Cursor cursor = db().query(TABLE_LOANS, COLUMNS, "book_id = ?", new String[]{String.valueOf(book_id)},
                null, null, null, null);

        if (cursor.getCount()==0){
            return false;
        }else return true;
    }
}
