package com.kuliahdhevan.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText edtPassword, edtUsername, edtFullname;
    Button btnLogin, btnRegister;
    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.kuliahdhevan.applogin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtPassword = findViewById(R.id.edtPasswordRegister);
        edtUsername = findViewById(R.id.edtUsernameRegister);
        edtFullname = findViewById(R.id.edtFullname);
        btnLogin = findViewById(R.id.btnBackLogin);
        btnRegister = findViewById(R.id.btnSubmitRegister);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
    }

    public void back(View view) {
        finish();
    }

    public void submitRegister(View view) {
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString("FULLNAME", edtFullname.getText().toString());
        preferencesEditor.putString("USERNAME", edtUsername.getText().toString());
        preferencesEditor.putString("PASSWORD", edtPassword.getText().toString());
        preferencesEditor.apply();
        finish();
    }
}