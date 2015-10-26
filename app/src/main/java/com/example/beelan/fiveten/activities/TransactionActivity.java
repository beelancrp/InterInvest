package com.example.beelan.fiveten.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.beelan.fiveten.R;
import com.example.beelan.fiveten.fragments.TransactionConfirmFragment;
import com.example.beelan.fiveten.fragments.TransactionMainFragment;


public class TransactionActivity extends AppCompatActivity {
    public static final int ACTIVITY_TRANSACTION           = R.layout.activity_transaction;
    public static final int TRANSACTION_TOOLBAR            = R.id.transaction_toolbar;
    public static final int IC_KEYBOARD_BACKSPACE          = R.drawable.ic_arrow_left;
    public static final int TRANSACTION_FRAGMENT_CONTAINER = R.id.transaction_fragment_container;

    private Toolbar toolBar;
    private TransactionConfirmFragment confirmFragment = new TransactionConfirmFragment();
    private FragmentManager mFragmentManager;
    private TransactionMainFragment mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_TRANSACTION);

        initToolBar();
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }

        });

        mFragmentManager = getSupportFragmentManager();
        mFragment = new TransactionMainFragment();
        mFragmentManager.beginTransaction().addToBackStack(null).replace(TRANSACTION_FRAGMENT_CONTAINER, mFragment)
                .commit();

    }


    public void onSubmit(View view) {
        switch (view.getId()) {
            case R.id.btnTransaction:
                mFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.transaction_fragment_container, confirmFragment, confirmFragment.TAG)
                        .commit();
        }

    }

    private void initToolBar() {
        toolBar = (Toolbar) findViewById(TRANSACTION_TOOLBAR);
        toolBar.setNavigationIcon(IC_KEYBOARD_BACKSPACE);
        toolBar.setTitle(R.string.transaction);
        setSupportActionBar(toolBar);
    }

    @Override
    public void onBackPressed() {
        int getCountFragm = mFragmentManager.getBackStackEntryCount();
        if (getCountFragm > 1) {
            mFragmentManager.popBackStack();
        } else {
            finish();
        }
    }
}
