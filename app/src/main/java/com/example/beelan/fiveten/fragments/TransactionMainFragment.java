package com.example.beelan.fiveten.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.beelan.fiveten.R;

import fr.ganfra.materialspinner.MaterialSpinner;


public class TransactionMainFragment extends Fragment {

    private MaterialSpinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trasaction_main, null);

        String[] ITEMS = {"Dollar", "Гривна", "Рубли"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.drop_down_list, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MaterialSpinner spinner = (MaterialSpinner) v.findViewById(R.id.transaction_spinner);
        spinner.setAdapter(adapter);

        return v;
    }
}
