package com.example.beelan.fiveten.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beelan.fiveten.R;


public class PayConfirmFragment extends Fragment {


    public static final String TAG = "SubmitPayFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pay_submit, null);
    }

    public static String getName() {
        return TAG;
    }
}
