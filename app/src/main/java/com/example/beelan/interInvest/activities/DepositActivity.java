package com.example.beelan.interInvest.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.beelan.interInvest.R;
import com.example.beelan.interInvest.fragments.ExchangeConfirmFragment;
import com.example.beelan.interInvest.fragments.DepositMainFragment;


public class DepositActivity extends AppCompatActivity {

    public static final int ACTIVITY_DEPOSIT             = R.layout.activity_deposit;
    public static final int DEPOSIT_TOOLBAR              = R.id.deposit_toolbar;
    public static final int IC_KEYBOARD_BACKSPACE         = R.drawable.ic_arrow_left;
    public static final int BTN_DEPOSIT_SUBMIT           = R.id.btn_deposit;
    public static final int DEPOSIT                      = R.string.invest;
    public static final int DEPOSIT_FRAGMENT_CONTAINER  = R.id.deposit_fragment_container;

    private Toolbar toolBar;
    private ExchangeConfirmFragment confirmFragment = new ExchangeConfirmFragment();
    private FragmentManager mFragmentManager;
    private DepositMainFragment mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_DEPOSIT);

        initToolBar();
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }

        });

        mFragmentManager = getSupportFragmentManager();
        mFragment = new DepositMainFragment();
        mFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(DEPOSIT_FRAGMENT_CONTAINER, mFragment)
                .commit();

    }


    public void onSubmit(View view) {
        switch (view.getId()){
            case BTN_DEPOSIT_SUBMIT:
                mFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(DEPOSIT_FRAGMENT_CONTAINER, confirmFragment, confirmFragment.TAG)
                        .commit();
        }

    }

    private void initToolBar() {
        toolBar = (Toolbar) findViewById(DEPOSIT_TOOLBAR);
        toolBar.setNavigationIcon(IC_KEYBOARD_BACKSPACE);
        toolBar.setTitle(DEPOSIT);
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
