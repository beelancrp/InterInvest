package com.example.beelan.interInvest.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.beelan.interInvest.R;
import com.example.beelan.interInvest.fragments.VuvodConfirmFragment;
import com.example.beelan.interInvest.fragments.VuvodMainFragment;


public class VuvodActivity extends AppCompatActivity {

    public static final int ACTIVITY_VUVOD           = R.layout.activity_vuvod;
    public static final int VUVOD_TOOLBAR            = R.id.vuvod_toolbar;
    public static final int IC_KEYBOARD_BACKSPACE    = R.drawable.ic_arrow_left;
    public static final int BTN_VUVOD_SUBMIT         = R.id.btn_vuvod;
    public static final int VUVOD                    = R.string.vuvod;
    public static final int VUVOD_FRAGMENT_CONTAINER = R.id.vuvod_fragment_container;

    private Toolbar toolBar;
    private VuvodConfirmFragment confirmFragment = new VuvodConfirmFragment();
    private FragmentManager mFragmentManager;
    private VuvodMainFragment mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_VUVOD);

        initToolBar();
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }

        });

        mFragmentManager = getSupportFragmentManager();
        mFragment = new VuvodMainFragment();
        mFragmentManager.beginTransaction().addToBackStack(null).replace(VUVOD_FRAGMENT_CONTAINER, mFragment)
                .commit();

    }


    public void onSubmit(View view) {
        switch (view.getId()){
            case BTN_VUVOD_SUBMIT:
                mFragmentManager.beginTransaction()
                        .addToBackStack(null)
                        .replace(VUVOD_FRAGMENT_CONTAINER, confirmFragment, confirmFragment.getName())
                        .commit();
        }

    }

    private void initToolBar() {
        toolBar = (Toolbar) findViewById(VUVOD_TOOLBAR);
        toolBar.setNavigationIcon(IC_KEYBOARD_BACKSPACE);
        toolBar.setTitle(VUVOD);
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
