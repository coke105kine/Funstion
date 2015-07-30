package com.example.user.funstion;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by User on 7/29/2015.
 */
public class UserDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_QUERY =
    "CREATE TABLE " + UserInfo.NewUserInfo.TABLE_NAME + "("
            + UserInfo.NewUserInfo.FIRST_NAME + " TEXT,"
            + UserInfo.NewUserInfo.LAST_NAME + " TEXT,"
            + UserInfo.NewUserInfo.EMAIL + " TEXT,"
            + UserInfo.NewUserInfo.USERNAME + " TEXT,"
            + UserInfo.NewUserInfo.PASSWORD + " TEXT,"
            + UserInfo.NewUserInfo.PASSWORD_CONFIRM + "TEXT);";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
            Log.e("DATABASE OPERATIONS", "Database created / opened...");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "Table created...");
    }

    public void addInformation(String firstName, String lastName, String email, String username, String password, String passwordConfirm, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserInfo.NewUserInfo.FIRST_NAME, firstName);
        contentValues.put(UserInfo.NewUserInfo.LAST_NAME, lastName);
        contentValues.put(UserInfo.NewUserInfo.EMAIL, email);
        contentValues.put(UserInfo.NewUserInfo.USERNAME, username);
        contentValues.put(UserInfo.NewUserInfo.PASSWORD, password);
        contentValues.put(UserInfo.NewUserInfo.PASSWORD_CONFIRM, passwordConfirm);
        db.insert(UserInfo.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "One row inserted...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
