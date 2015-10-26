package com.example.beelan.fiveten.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.beelan.fiveten.R;
import com.example.beelan.fiveten.fragments.ExchangeConfirmFragment;
import com.example.beelan.fiveten.fragments.ExchangeMainFragment;

public class ExchangeActivity extends AppCompatActivity{
    public static final int ACTIVITY_EXCHANGE             = R.layout.activity_exchange;
    public static final int EXCHANGE_TOOLBAR              = R.id.exchange_toolbar;
    public static final int IC_KEYBOARD_BACKSPACE         = R.drawable.ic_arrow_left;
    public static final int BTN_EXCHANGE_SUBMIT           = R.id.btn_exchange;
    public static final int EXCHANGE                      = R.string.exchange;
    public static final int EXCHANGE_FRAGMENT_CONTAINER = R.id.exchange_fragment_container;

    private Toolbar toolBar;
    private ExchangeConfirmFragment confirmFragment = new ExchangeConfirmFragment();
    private FragmentManager mFragmentManager;
    private ExchangeMainFragment mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_EXCHANGE);

        initToolBar();
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }

        });

        mFragmentManager = getSupportFragmentManager();
        mFragment = new ExchangeMainFragment();
        mFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(EXCHANGE_FRAGMENT_CONTAINER, mFragment)
                .commit();

    }


    public void onSubmit(View view) {
        switch (view.getId()){
            case BTN_EXCHANGE_SUBMIT:
                mFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(EXCHANGE_FRAGMENT_CONTAINER, confirmFragment, confirmFragment.TAG)
                        .commit();
        }

    }

    private void initToolBar() {
        toolBar = (Toolbar) findViewById(EXCHANGE_TOOLBAR);
        toolBar.setNavigationIcon(IC_KEYBOARD_BACKSPACE);
        toolBar.setTitle(EXCHANGE);
        setSupportActionBar(toolBar);
    }

    @Override
    public void onBackPressed() {
        int getCountFragm = mFragmentManager.getBackStackEntryCount();
        if (getCountFragm > 1) {
            if(getCountFragm == 2) {
                finish();
            }else {
                mFragmentManager.popBackStack();
            }
        } else{
            finish();
        }
    }

}
