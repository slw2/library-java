package com.example.sophie.library;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "DB2";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteDatabase db(){
        return this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE users ( " +
                "id INTEGER PRIMARY KEY, " +
                "first_name TEXT, " +
                "last_name TEXT )";

        // create user table
        db.execSQL(CREATE_USER_TABLE);

        String CREATE_BOOK_TABLE = "CREATE TABLE books ( " +
                "id INTEGER PRIMARY KEY, " +
                "title TEXT, " +
                "author TEXT )";

        // create book table
        db.execSQL(CREATE_BOOK_TABLE);

        String CREATE_LOAN_TABLE = "CREATE TABLE loans ( " +
                "book_id INTEGER, " +
                "user_id INTEGER )";

        // create loan table
        db.execSQL(CREATE_LOAN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS books");
        db.execSQL("DROP TABLE IF EXISTS loans");
        this.onCreate(db);
    }
}
