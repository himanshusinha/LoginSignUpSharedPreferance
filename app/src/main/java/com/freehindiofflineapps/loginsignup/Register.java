package com.freehindiofflineapps.loginsignup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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
    EditText inputUsername, inputPassword, inputEmail;
    UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);

        editor = sharedPreferences.edit();

        inputUsername = (EditText) findViewById(R.id.txtName);
        inputPassword = (EditText) findViewById(R.id.txtPassword);
        inputEmail = (EditText) findViewById(R.id.txtEmail);
        buttonReg2 = (Button) findViewById(R.id.buttonReg2);


        buttonReg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputUsername.getText().toString();
                String email = inputEmail.getText().toString();
                String pass = inputPassword.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    inputUsername.setError("Please enter username");
                    inputUsername.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    inputPassword.setError("Please enter password");
                    inputPassword.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    inputEmail.setError("Please enter email");
                    inputEmail.requestFocus();
                    return;
                }
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    inputEmail.setError("Enter valid email");
                    inputEmail.requestFocus();
                    return;
                }
                else {

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
