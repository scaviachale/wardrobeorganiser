package com.scaa.wardrobe;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.scaa.wardrobe.repositories.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText name, email, password;
    Button register;
    DBHelper dbHelper;
    UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editName);
        email = (EditText) findViewById(R.id.editEmailAddress);
        password = (EditText) findViewById(R.id.editPassword);

        register = (Button) findViewById(R.id.btnRegister);

        dbHelper = new DBHelper(this);
        session = new UserSession(this);
    }

    public void onBtnRegisterClick(View view) {
        String username = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if (username.equals("") || userEmail.equals("") || userPassword.isEmpty() || !isValidEmail(userEmail)) {
            Toast.makeText(MainActivity.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
        } else {
            Boolean checkUserExistence = dbHelper.checkUserExists(userEmail);
            if (checkUserExistence == false) {
                Boolean saveUser = dbHelper.save(username, userEmail, userPassword);
                if (saveUser == true) {
                    Toast.makeText(MainActivity.this, "User created", Toast.LENGTH_SHORT).show();
                    session.setUsername(userEmail);
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "User registration failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
            }
        }

    }


    public static boolean isValidEmail(CharSequence userEmail) {
        return (!TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches());
    }

    public void onBtnSignInClick(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();

    }
}