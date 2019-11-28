package com.example.javalogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_name = "Customers_info";
    public static final String UserData ="login_info";
    public static final String login_email = "email";
    public static final String login_pass = "password";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + UserData + "("
                    + login_email + " INTEGER PRIMARY KEY ,"
                    + login_pass + " TEXT)";







    public DatabaseHelper(Context context) {
        super(context, Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UserData);
        onCreate(db);
    }
    public void insertData(String email,String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(login_email,email);
        cv.put(login_pass,pass);
        db.insert(UserData,null,cv);
        db.close();


    }

}
