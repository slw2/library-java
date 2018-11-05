package com.example.sophie.library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class Users extends Database {

    public Users(Context context) {
        super(context);
    }

    private static final String TABLE_USERS = "users";

    private static final String KEY_ID = "id";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";

    private static final String[] COLUMNS = {KEY_ID,KEY_FIRST_NAME,KEY_LAST_NAME};


    public List<User> users() {
        List<User> users = new LinkedList<User>();

        String query = "SELECT  * FROM " + TABLE_USERS;

        Cursor cursor = db().rawQuery(query, null);

        // go over each row, build user and add it to list
        User user = null;
        if (cursor.moveToFirst()) {
            do {
                user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setFirst_name(cursor.getString(1));
                user.setLast_name(cursor.getString(2));

                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }

    public List<User> usersearch_by_firstname(String first_name) {
        List<User> users = new LinkedList<User>();

        Cursor cursor = db().query(TABLE_USERS, COLUMNS," first_name = ?", new String[] { first_name },
                        null,null,null,null);

        User user = null;
        if (cursor.moveToFirst()) {
            do {
                user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setFirst_name(cursor.getString(1));
                user.setLast_name(cursor.getString(2));

                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }

    public List<User> usersearch_by_lastname(String last_name) {
        List<User> users = new LinkedList<User>();

        Cursor cursor = db().query(TABLE_USERS, COLUMNS,"last_name = ?", new String[] { last_name },
                null,null,null,null);

        User user = null;
        if (cursor.moveToFirst()) {
            do {
                user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setFirst_name(cursor.getString(1));
                user.setLast_name(cursor.getString(2));

                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }

    public User usersearch_by_id(int id) {

        Cursor cursor = db().query(TABLE_USERS, COLUMNS, "id = ?", new String[]{String.valueOf(id)},
                null, null, null, null);

        User user = new User();
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            user.setId(Integer.parseInt(cursor.getString(0)));
            user.setFirst_name(cursor.getString(1));
            user.setLast_name(cursor.getString(2));
        } else {
            user.setId(0);
            user.setFirst_name("");
            user.setLast_name("");
        }

        return user;
    }

    public void add_user(String first_name, String last_name) {

        ContentValues values = new ContentValues();
        values.put(KEY_FIRST_NAME, first_name);
        values.put(KEY_LAST_NAME, last_name);

        db().insert(TABLE_USERS, null, values);
    }

    public void remove_user(User user){
        db().delete(TABLE_USERS,"id = ?",
                  new String[] { String.valueOf(user.getId()) });
    }

    public void update_user(User user){

        ContentValues values = new ContentValues();
        values.put("first_name", user.getFirst_name());
        values.put("last_name", user.getLast_name());

        db().update(TABLE_USERS, values,"id = ?",
                          new String[] { String.valueOf(user.getId()) });
    }
}