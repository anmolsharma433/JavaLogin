package com.example.javalogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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




public Cursor c;



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
    public Boolean userMatched(String email,String pass)
    {    SQLiteDatabase db = this.getReadableDatabase();

        //String selectQuery = "SELECT  * FROM " + UserData + "where" +login_email.equals(email) +"and"+ login_pass.equals(pass));

        //String email1 = "select" +login_email + "from" + UserData + "where" + login_email.equals(email);
        //String pass1 = "select" +login_pass + "from" + UserData + "where" + login_pass.equals(email);
        //Cursor c = db.rawQuery("select * from "+UserData+ "where " +login_email.equals(email)+ "and" +login_pass.equals(pass));

       // if (email1.equals(null) || pass1.equals(null))
       // {
       //     return false;
       // }else return true;

        //String q = "select * from UserData where login_email = '" + email + "' and login_pass = '" + pass + '\'';


        c = db.rawQuery("Select * from " + UserData + " Where " +login_email+ " =? and " + login_pass +  " =? ",new String[]{email,pass});
        if(c.getCount() > 0){
            return true;
        }
            return false;

    }


    }

