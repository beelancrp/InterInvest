package com.example.beelan.fiveten.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.beelan.fiveten.R;
import com.example.beelan.fiveten.fragments.PayConfirmFragment;
import com.example.beelan.fiveten.fragments.PayMainFragment;

public class PayActivity extends AppCompatActivity {

    public static final int ACTIVITY_PAY                  = R.layout.activity_pay;
    public static final int PAY_TOOLBAR                   = R.id.pay_toolbar;
    public static final int IC_KEYBOARD_BACKSPACE         = R.drawable.ic_arrow_left;
    public static final int BTN_POPOLNENIE_SUBMIT         = R.id.btn_popolnit;
    public static final int POPOLNENIE                    = R.string.popolnenie;
    public static final int PAY_SYSTEM_FRAGMENT_CONTAINER = R.id.pay_system_fragment_container;

    private Toolbar toolBar;
    private PayConfirmFragment confirmFragment = new PayConfirmFragment();
    private FragmentManager mFragmentManager;
    private PayMainFragment mFragment;


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

        mFragmentManager = getSupportFragmentManager();
        mFragment = new PayMainFragment();
        mFragmentManager.beginTransaction().addToBackStack(null).replace(PAY_SYSTEM_FRAGMENT_CONTAINER, mFragment)
                .commit();

    }


    public void onSubmit(View view) {
        switch (view.getId()){
            case BTN_POPOLNENIE_SUBMIT:
                mFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.pay_system_fragment_container, confirmFragment, confirmFragment.getName())
                        .commit();
        }

    }

    private void initToolBar() {
        toolBar = (Toolbar) findViewById(PAY_TOOLBAR);
        toolBar.setNavigationIcon(IC_KEYBOARD_BACKSPACE);
        toolBar.setTitle(POPOLNENIE);
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



















//    private AppCompatSpinner paySystem;
//    private static final String[] COUNTRIES = new String[] {
//            "Belgium", "France", "Italy", "Germany", "Spain"};
//        initSpinner();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
//        paySystem = (AppCompatSpinner)findViewById(R.id.spinner);
//        paySystem.setHint(R.string.pay_system);
//        paySystem.setUnderlineColor(getResources().getColor(R.color.colorPrimaryDark));
//
//        paySystem.setAdapter(adapter);
