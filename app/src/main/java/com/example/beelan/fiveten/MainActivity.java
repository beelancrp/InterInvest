package com.example.beelan.fiveten;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.beelan.fiveten.activities.LoginActivity;
import com.example.beelan.fiveten.supports.RequestCodes;
import com.example.beelan.fiveten.supports.UserLocalStore;

public class MainActivity extends AppCompatActivity {

    public static final int ACTIVITY_MAIN = R.layout.activity_main;
    public static final int CABINET = R.string.cabinet;
    public static final int COLOR_PRIMARY_DARK = R.color.colorPrimaryDark;

    private Intent  intent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_MAIN);
        if(!UserLocalStore.isUserLoggedIn()){
            initLogin();
        }
        initToolBar();
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UserLocalStore.cleanUserData();
//                initLogin();
//            }
//        });
    }

    private void initLogin() {
        intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, RequestCodes.REQUEST_CODE_LOGIN);
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(CABINET);
//        toolbar.setNavigationIcon(R.drawable.ic_logout);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case RequestCodes.REQUEST_CODE_LOGIN:

            }
        }else {
            switch (resultCode){
                case RequestCodes.REQUEST_CODE_LOGIN:
                    initLogin();
            }
        }
    }

    @Override
    public void onBackPressed() {

    }
}
