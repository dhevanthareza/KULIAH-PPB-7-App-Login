package com.kuliahdhevan.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private String sharedPrefFile =
            "com.kuliahdhevan.applogin";
    TextView tvContent;

    private SharedPreferences mPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        String fullname = mPreferences.getString("FULLNAME", "belum login");
        tvContent =findViewById(R.id.tvContent);
        tvContent.setText("Hallo " + fullname);
    }
}