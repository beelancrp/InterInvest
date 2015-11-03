package com.example.beelan.interInvest.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.beelan.interInvest.R;


public class MoreActivity extends AppCompatActivity {

    public static final int ACTIVITY_MORE = R.layout.activity_more;
    public static final int IC_KEYBOARD_BACKSPACE = R.drawable.ic_arrow_left;


    private Toolbar toolbar;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_MORE);

        initToolBar();
        mFragmentManager = getSupportFragmentManager();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.more_toolbar);
        toolbar.setTitle(R.string.more);
        toolbar.setNavigationIcon(IC_KEYBOARD_BACKSPACE);
        setSupportActionBar(toolbar);
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
