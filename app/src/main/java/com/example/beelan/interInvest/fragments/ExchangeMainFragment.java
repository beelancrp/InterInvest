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

/**
 * Created by beeLAN on 26.10.2015.
 */
public class ExchangeMainFragment extends Fragment {
    public static final String TAG = "ExchangeMainFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exchange_main, null);

        String[] ITEMS = {"Dollar", "Гривна", "Рубли"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.drop_down_list, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MaterialSpinner spinner1 = (MaterialSpinner) view.findViewById(R.id.exchange_spinner_1);
        MaterialSpinner spinner2 = (MaterialSpinner) view.findViewById(R.id.exchange_spinner_2);
        spinner2.setAdapter(adapter);
        spinner1.setAdapter(adapter);


        return view;
    }

    public static String getName() {
        return TAG;
    }
}
