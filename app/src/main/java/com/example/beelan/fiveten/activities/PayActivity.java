package com.example.beelan.fiveten.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.beelan.fiveten.R;
import android.support.v7.widget.AppCompatSpinner;

public class PayActivity extends AppCompatActivity {

    public static final int ACTIVITY_PAY = R.layout.activity_pay;
    public static final int PAY_TOOLBAR = R.id.pay_toolbar;
    public static final int IC_KEYBOARD_BACKSPACE = R.drawable.ic_arrow_left;
    public static final boolean SHOW_TITLE = false;
    private static final String[] COUNTRIES = new String[] {
            "Belgium", "France", "Italy", "Germany", "Spain"};

    private Toolbar toolBar;
    private AppCompatSpinner paySystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_PAY);

        initToolBar();
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        initSpinner();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
//        paySystem = (AppCompatSpinner)findViewById(R.id.spinner);
////        paySystem.setHint(R.string.pay_system);
////        paySystem.setUnderlineColor(getResources().getColor(R.color.colorPrimaryDark));
//
//        paySystem.setAdapter(adapter);
    }


    private void initSpinner() {

    }

    private void initToolBar() {
        toolBar = (Toolbar) findViewById(PAY_TOOLBAR);
        toolBar.setNavigationIcon(IC_KEYBOARD_BACKSPACE);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(SHOW_TITLE);
    }
}
