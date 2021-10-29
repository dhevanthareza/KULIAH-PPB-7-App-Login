package com.kuliahdhevan.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtPassword, edtUsername;
    Button btnLogin, btnRegister;
    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.kuliahdhevan.applogin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
    }

    public void handleLoginButtonClick(View view) {
        String storedUsername = mPreferences.getString("USERNAME", "secret");
        String storedPassword = mPreferences.getString("PASSWORD", "secret");
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        if(username.equals(storedUsername) && password.equals(storedPassword)) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Username atau Password salah", Toast.LENGTH_SHORT).show();
        }
    }

    public void handleRegisterButtonClick(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}