package com.example.sophie.library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class Books extends Database {

    public Books(Context context) {
        super(context);
    }

    private static final String TABLE_BOOKS = "books";

    public static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";

    private static final String[] COLUMNS = {KEY_ID,KEY_TITLE,KEY_AUTHOR};


    public List<Book> books() {
        List<Book> books = new LinkedList<Book>();

        String query = "SELECT  * FROM " + TABLE_BOOKS;

        Cursor cursor = db().rawQuery(query, null);

        // go over each row, build book and add it to list
        Book book = null;
        if (cursor.moveToFirst()) {
            do {
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));

                books.add(book);
            } while (cursor.moveToNext());
        }
        return books;
    }

    public List<Book> booksearch_by_title(String title) {
        List<Book> books = new LinkedList<Book>();

        Cursor cursor = db().query(TABLE_BOOKS, COLUMNS," title = ?", new String[] { title },
                null,null,null,null);

        Book book = null;
        if (cursor.moveToFirst()) {
            do {
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));

                books.add(book);
            } while (cursor.moveToNext());
        }
        return books;
    }

    public List<Book> booksearch_by_author(String author) {
        List<Book> books = new LinkedList<Book>();

        Cursor cursor = db().query(TABLE_BOOKS, COLUMNS,"author = ?", new String[] { author },
                null,null,null,null);

        Book book = null;
        if (cursor.moveToFirst()) {
            do {
                book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));

                books.add(book);
            } while (cursor.moveToNext());
        }
        return books;
    }

    public Book booksearch_by_id(int id) {

        Cursor cursor = db().query(TABLE_BOOKS, COLUMNS, "id = ?", new String[]{String.valueOf(id)},
                null, null, null, null);

        Book book = new Book();
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            book.setId(Integer.parseInt(cursor.getString(0)));
            book.setTitle(cursor.getString(1));
            book.setAuthor(cursor.getString(2));
        } else {
            book.setId(0);
            book.setTitle("");
            book.setAuthor("");
        }

        return book;
    }

    public void add_book(String title, String author) {

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, title);
        values.put(KEY_AUTHOR, author);

        db().insert(TABLE_BOOKS, null, values);
    }

    public void remove_book(Book book){

        db().delete(TABLE_BOOKS,"id = ?",
                new String[] { String.valueOf(book.getId()) });
    }

    public void update_book(Book book){

        ContentValues values = new ContentValues();
        values.put("title", book.getTitle());
        values.put("author", book.getAuthor());

        db().update(TABLE_BOOKS, values,"id = ?",
                new String[] { String.valueOf(book.getId()) });
    }

}
