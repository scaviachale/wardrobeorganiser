package com.scaa.wardrobe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "WardrobeOrganiser.db";

    public DBHelper(@Nullable Context context) {
        super(context, "WardrobeOrganiser.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table user (name TEXT, email TEXT primary key, password TEXT)");
        MyDB.execSQL("create table cloth (name TEXT, uuid TEXT primary key, type TEXT, size TEXT, colour TEXT, season TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop table if exists user");
        MyDB.execSQL("drop table if exists cloth");

    }

    public boolean save(String name, String email, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("password", password);

        long result = myDB.insert("user", null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean saveClothing(String name, String uuid, String type, String size, String colour, String season) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("uuid", uuid);
        values.put("type", type);
        values.put("size", size);
        values.put("colour", colour);
        values.put("season", season);

        long result = myDB.insert("cloth", null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean checkUserExists(String email) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from user where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkUsernameAndPassword(String email, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from user where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }
}
