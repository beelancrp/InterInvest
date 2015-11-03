package com.example.beelan.interInvest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.beelan.interInvest.activities.DepositActivity;
import com.example.beelan.interInvest.activities.ExchangeActivity;
import com.example.beelan.interInvest.activities.LoginActivity;
import com.example.beelan.interInvest.activities.MoreActivity;
import com.example.beelan.interInvest.activities.PayActivity;
import com.example.beelan.interInvest.activities.TransactionActivity;
import com.example.beelan.interInvest.activities.VuvodActivity;
import com.example.beelan.interInvest.supports.RequestCodes;
import com.example.beelan.interInvest.supports.UserLocalStore;

public class MainActivity extends AppCompatActivity {

    public static final int ACTIVITY_MAIN = R.layout.activity_main;
    public static final int CABINET = R.string.cabinet;
    public static final boolean SHOW_TITLE = false;
    public static final int MENU_LOGOUT = R.id.menu_item_logout;
    public static final int IC_KEYBOARD_BACKSPACE  = R.drawable.ic_arrow_left;
    public static final int CABINET_USD_TAB = R.id.cabinet_USD_tab;
    public static final int CABINET_UAH_TAB = R.id.cabinet_UAH_tab;
    public static final int CABINET_RUB_TAB = R.id.cabinet_RUB_tab;
    public static final int CABINET_EUR_TAB = R.id.cabinet_EUR_tab;
    public static final int CABINET_PLN_TAB = R.id.cabinet_PLN_tab;


    //    private FragmentManager mFragmentManager;
    private Toolbar toolbar;
    private TextView mUSDTab;
    private TextView mUAHTab;
    private TextView mRUBTab;
    private TextView mEURTab;
    private TextView mPLNTab;
    private TextView mBalance;
    private TextView mBalanceIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_MAIN);
        if(!UserLocalStore.isUserLoggedIn()){
            initLogin();
        }
        //---Init block
        initToolBar();
        initTabs();

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

    private void initTabs (){
        mUSDTab = (TextView) findViewById(CABINET_USD_TAB);
        mUAHTab = (TextView) findViewById(CABINET_UAH_TAB);
        mRUBTab = (TextView) findViewById(CABINET_RUB_TAB);
        mEURTab = (TextView) findViewById(CABINET_EUR_TAB);
        mPLNTab = (TextView) findViewById(CABINET_PLN_TAB);
        mBalance = (TextView) findViewById(R.id.cabinet_your_balance);
        mBalanceIn = (TextView) findViewById(R.id.cabinet_balance_in);
        onTabClick(mUAHTab);
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
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

    public void onCabinetButtonClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.cabinetBtnPopolnit:
                intent = new Intent(this, PayActivity.class);
                startActivity(intent);
                Log.d("On-press:", "ActivityStarted");
                break;
            case R.id.cabinetBtnExchange:
                intent = new Intent(this, ExchangeActivity.class);
                startActivity(intent);
                Log.d("On-press:", "ActivityStarted");
                break;
            case R.id.cabinetBtnTransaction:
                intent = new Intent(this, TransactionActivity.class);
                startActivity(intent);
                Log.d("On-press:", "ActivityStarted");
                break;
            case R.id.cabinetBtnDeposit:
                intent = new Intent(this, DepositActivity.class);
                startActivity(intent);
                Log.d("On-press:", "ActivityStarted");
                break;
            case R.id.cabinetBtnVuvod:
                intent = new Intent(this, VuvodActivity.class);
                startActivity(intent);
                Log.d("On-press:", "ActivityStarted");
                break;
            case R.id.cabinetBtnMore:
                intent = new Intent(this, MoreActivity.class);
                startActivity(intent);
                Log.d("On-press:", "ActivityStarted");
                break;
        }
    }

    public void onTabClick(View view){
        switch (view.getId()){
            case CABINET_USD_TAB:
                mUSDTab.setTextColor(getResources().getColor(R.color.colorAccent));
                mUAHTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mRUBTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mEURTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mPLNTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mBalanceIn.setText("Баланс в долларах");
                mBalance.setText("100 000 usd");
                break;
            case CABINET_UAH_TAB:
                mUSDTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mUAHTab.setTextColor(getResources().getColor(R.color.colorAccent));
                mRUBTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mEURTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mPLNTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mBalanceIn.setText("Баланс в гривнах");
                mBalance.setText("59 999 uah");
                break;
            case CABINET_RUB_TAB:
                mUSDTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mUAHTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mRUBTab.setTextColor(getResources().getColor(R.color.colorAccent));
                mEURTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mPLNTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mBalanceIn.setText("Баланс в рублях");
                mBalance.setText("25 565 rub");
                break;
            case CABINET_EUR_TAB:
                mUSDTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mUAHTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mRUBTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mEURTab.setTextColor(getResources().getColor(R.color.colorAccent));
                mPLNTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mBalanceIn.setText("Баланс в евро");
                mBalance.setText("125 678 eur");
                break;
            case CABINET_PLN_TAB:
                mUSDTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mUAHTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mRUBTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mEURTab.setTextColor(getResources().getColor(R.color.cabinetTabTextColor));
                mPLNTab.setTextColor(getResources().getColor(R.color.colorAccent));
                mBalanceIn.setText("Баланс в злотых");
                mBalance.setText("89 977 pln");
                break;
        }
    }

}
