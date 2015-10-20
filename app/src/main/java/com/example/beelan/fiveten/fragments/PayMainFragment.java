package com.example.beelan.fiveten.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beelan.fiveten.R;


public class PayMainFragment extends Fragment {


    public static final String TAG = "MainPayFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay_main, null);
        return view;
    }

    public static String getName() {
        return TAG;
    }
}
