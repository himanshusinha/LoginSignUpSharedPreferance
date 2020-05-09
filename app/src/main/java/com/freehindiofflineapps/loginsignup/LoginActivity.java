package com.freehindiofflineapps.loginsignup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {


    private static final String PREFER_NAME = "Reg";

    Button buttonLogin ;
    TextView registernow;
    EditText inputUsername, inputPassword;
    private ArrayList<String> itemsList;
    // User Session Manager Class
    UserSession session;

    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        // User Session Manager
        session = new UserSession(getApplicationContext());

        // get Email, Password input text
        inputUsername = (EditText) findViewById(R.id.txtUsername);
        inputPassword = (EditText) findViewById(R.id.txtPassword);

        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();


        // User Login button
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        registernow=(TextView) findViewById(R.id.RegisterNow);
        registernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,Register.class);
                startActivity(i);
            }
        });
        sharedPreferences = getSharedPreferences(PREFER_NAME, Context.MODE_PRIVATE);


        // Login button click event
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Get username, password from EditText
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();

                // Validate if username, password is filled
                if (username.trim().length() > 0 && password.trim().length() > 0) {
                    String uName = null;
                    String uPassword = null;

                    if (sharedPreferences.contains("Name")) {
                        uName = sharedPreferences.getString("Name", "");

                    }

                    if (sharedPreferences.contains("txtPassword")) {
                        uPassword = sharedPreferences.getString("txtPassword", "");

                    }

                    // Object uName = null;
                    // Object uEmail = null;
                    if (username.equals(uName) && password.equals(uPassword)) {

                        session.createUserLoginSession(uName,
                                uPassword);

                        // Starting MainActivity
                        Intent intent = new Intent(getApplicationContext(), Welcome.class);
                       intent.putExtra("NAME",uName);
                        intent.putExtra("EMAIL",uPassword);

                        startActivity(intent);


                    } else {

                        // username / password doesn't match&
                        Toast.makeText(getApplicationContext(),
                                "Username/Password is incorrect",
                                Toast.LENGTH_LONG).show();

                    }
                } else {

                    // user didn't entered username or password
                    if (TextUtils.isEmpty(username)) {
                        inputUsername.setError("Please enter username");
                        inputUsername.requestFocus();
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        inputPassword.setError("Please enter password");
                        inputPassword.requestFocus();
                        return;
                    }

                }

            }
        });
    }
}
