package com.example.beelan.interInvest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.beelan.interInvest.R;

import fr.ganfra.materialspinner.MaterialSpinner;


public class PayMainFragment extends Fragment {


    public static final String TAG = "PayMainFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay_main, null);

        String[] ITEMS = {"Dollar", "Гривна", "Рубли"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.drop_down_list, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MaterialSpinner spinner = (MaterialSpinner) view.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);


        return view;
    }

    public static String getName() {
        return TAG;
    }
}
