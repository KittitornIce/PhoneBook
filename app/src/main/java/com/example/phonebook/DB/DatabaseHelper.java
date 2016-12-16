package com.example.phonebook.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Kittitorn on 23-Oct-16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "phonebook.db"; //ชื่อDB
    private static final int DATABASE_VERSION = 4;

    public static final String TABLE_NAME = "phonebook";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_PHONE = "phone";
    public static final String COL_IMAGE = "image";


    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_PHONE + " TEXT, "
                    + COL_IMAGE + " TEXT "
                    + ")"; // insert ข้อมูลลงDB

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE);
        insertIntitial(db);

    }

    private void insertIntitial(SQLiteDatabase db) {

        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "andriod");
        cv.put(COL_PHONE, "111-111");
        cv.put(COL_IMAGE, "ic_android.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ios");
        cv.put(COL_PHONE, "222-222");
        cv.put(COL_IMAGE, "ic_ios.jpg");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "windows");
        cv.put(COL_PHONE, "333-333");
        cv.put(COL_IMAGE, "ic_windows.png");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "linux");
        cv.put(COL_PHONE, "444-444");
        cv.put(COL_IMAGE, "ic_linux.png");
        db.insert(TABLE_NAME, null, cv);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade(): oldVersion = " + oldVersion +", newVersion =" + newVersion);

        db.execSQL("DROP TABLE " + TABLE_NAME);
        db.execSQL(SQL_CREATE_TABLE);
        insertIntitial(db);

    }
}
