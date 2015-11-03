package com.example.beelan.interInvest.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.beelan.interInvest.R;
import com.example.beelan.interInvest.adapters.DepositAdapter;
import com.example.beelan.interInvest.supports.DepositComponentsList;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;


public class DepositMainFragment extends Fragment {

    public static final String TAG = "DepositMainFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deposit_main, null);

        String[] ITEMS = {"Dollar", "Гривна", "Рубли"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.drop_down_list, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MaterialSpinner spinner = (MaterialSpinner) view.findViewById(R.id.deposit_spinner);
        spinner.setAdapter(adapter);

        List<DepositComponentsList> itemList = initItimes();
        ListView listView = (ListView) view.findViewById(R.id.deposit_confirm_list);
        DepositAdapter adapter1 = new DepositAdapter(itemList, getContext(), R.layout.deposit_list_items);
        listView.setAdapter(adapter1);


        return view;
    }

    private List<DepositComponentsList> initItimes() {
        List<DepositComponentsList> list = new ArrayList<DepositComponentsList>();
        list.add(new DepositComponentsList(1, "Dollar(USD)", "1.00", "1.00","1.00"));
        list.add(new DepositComponentsList(1, "Гривны(UAH)", "1.00", "1.00","1.00"));
        list.add(new DepositComponentsList(1, "Рубли(RUB)", "1.00", "1.00","1.00"));
        list.add(new DepositComponentsList(1, "Злотых(PLN)", "1.00", "1.00","1.00"));
        list.add(new DepositComponentsList(1, "EURO(EUR)", "1.00", "1.00","1.00"));
        return list;
    }

    public static String getName() {
        return TAG;
    }
}
