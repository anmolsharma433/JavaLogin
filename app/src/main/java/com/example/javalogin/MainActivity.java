package com.example.javalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button login, signup;
    EditText Email;
    EditText Pass;
    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.btnLogin);
        signup = findViewById(R.id.btnSignup);
        Email = findViewById(R.id.etEmail);
        Pass = findViewById(R.id.etPassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (databaseHelper.userMatched(Email.getText().toString(), Pass.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Successfully Logged In.",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(MainActivity.this, "User Not Found.",Toast.LENGTH_SHORT).show();
                }


            }

        });

        //btn signUp
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });


    }
}
