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

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button signIn;
    DBHelper dbHelper;
    UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.editEmailAddressLoginActivity);
        password = (EditText) findViewById(R.id.editPasswordLoginActivity);

        signIn = (Button) findViewById(R.id.btnSignInLoginActivity);

        dbHelper = new DBHelper(this);

        session = new UserSession(this);
    }

    public void onBtnSignInClick(View view) {
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        if (userPassword.isEmpty() || (userEmail.isEmpty())) {
            Toast.makeText(LoginActivity.this, "Complete all fields", Toast.LENGTH_SHORT).show();
        } else {
            boolean checkUserEmailAndPassword = dbHelper.checkUsernameAndPassword(userEmail, userPassword);
            if (checkUserEmailAndPassword) {
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                session.setUsername(userEmail);
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void onBtnRegisterClick(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}