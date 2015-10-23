package com.example.beelan.fiveten;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.beelan.fiveten.activities.LoginActivity;
import com.example.beelan.fiveten.activities.PayActivity;
import com.example.beelan.fiveten.supports.RequestCodes;
import com.example.beelan.fiveten.supports.UserLocalStore;

public class MainActivity extends AppCompatActivity {

    public static final int ACTIVITY_MAIN = R.layout.activity_main;
    public static final int CABINET = R.string.cabinet;
    public static final boolean SHOW_TITLE = false;
    public static final int MENU_LOGOUT = R.id.menu_item_logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_MAIN);
        initToolBar();


        if(!UserLocalStore.isUserLoggedIn()){
            initLogin();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_LOGOUT:
                doLogOut();
        }
        return true;
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(CABINET);
        setSupportActionBar(toolbar);
    }

    private void initLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, RequestCodes.REQUEST_CODE_LOGIN);
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

    public void doLogOut (){
        if(UserLocalStore.isUserLoggedIn()){
            UserLocalStore.cleanUserData();
            initLogin();
        }
    }


    public void someClick (View view){
        Intent intent;
        switch (view.getId()){
            case R.id.cabinetBtnPopolnit:
                intent = new Intent(this, PayActivity.class);
                startActivity(intent);
                Log.d("On-press:", "ActivityStarted");
//            case R.id.cabinetBtnTransaction:
//                intent = new Intent(this, TransactionActivity.class);
//                startActivity(intent);
//                Log.d("On-press:", "ActivityStarted");
        }
    }
}
