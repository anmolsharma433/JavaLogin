package com.example.javalogin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
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

                if (rpwd.getText().length() != 0 && rcpwd.getText().length() != 0) {         //It will check whether the password fields are empty or not.

                    if (rpwd.getText().toString().equals(rcpwd.getText().toString())) {      //if above condition is true then it will match the passwords.
                        databaseHelper.insertData(remail.getText().toString(), rpwd.getText().toString());
                        Toast.makeText(SignUp.this, "You are Signned Up.", Toast.LENGTH_SHORT).show();
                    }
                    else
                        {
                          alertDialogMismatch();
                    }
                }
                else
                {
                    alertDialogEmpty();
                }
            }
        });
    }
    private void alertDialogEmpty()
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("SIGNUP ERROR");
        dialog.setMessage("Please Enter the required Fields");
        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    private void alertDialogMismatch()
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("SIGNUP ERROR");
        dialog.setMessage("Password Fields Doesn't Match.");
        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }


}
