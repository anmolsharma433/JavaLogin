package com.example.javalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    private Button signup;
    private EditText remail,rpwd,rcpwd;
    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        remail = findViewById(R.id.etruname);
        rpwd = findViewById(R.id.etrpwd);
        rcpwd =findViewById(R.id.etrcpwd);
        signup = findViewById(R.id.btnSignUppage);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (rpwd.getText().toString().equals(rcpwd.getText().toString()))
               {
                  databaseHelper.insertData(remail.getText().toString(),rpwd.getText().toString());
                   Toast.makeText(SignUp.this,"You are Signned Up.",Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}
