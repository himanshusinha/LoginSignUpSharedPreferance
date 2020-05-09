package com.freehindiofflineapps.loginsignup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button buttonReg2;
    EditText txtUsername, txtPassword, txtEmail;
    UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);

        editor = sharedPreferences.edit();

        txtUsername = (EditText) findViewById(R.id.txtName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        buttonReg2 = (Button) findViewById(R.id.buttonReg2);


        buttonReg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtUsername.getText().toString();
                String email = txtEmail.getText().toString();
                String pass = txtPassword.getText().toString();
                if (txtUsername.getText().length() <= 0) {
                    Toast.makeText(Register.this, "Enter name", Toast.LENGTH_SHORT).show();
                } else if (txtEmail.getText().length() <= 0) {
                    Toast.makeText(Register.this, "Enter email", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.getText().length() <= 0) {
                    Toast.makeText(Register.this, "Enter password", Toast.LENGTH_SHORT).show();
                } else {

                    // as now we have information in string. Lets stored them with the help of editor
                    editor.putString("Name", name);
                    editor.putString("Email", email);
                    editor.putString("txtPassword", pass);
                    editor.commit();
                    Intent ob = new Intent(Register.this, LoginActivity.class);
                    startActivity(ob);

                }   // commit the values



            }

        });

    }
}
