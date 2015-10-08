package com.example.beelan.fiveten;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.beelan.fiveten.activities.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private Intent loginScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginScreen = new Intent(this, LoginActivity.class);
        startActivity(loginScreen);

    }
}
