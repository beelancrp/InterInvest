package com.example.beelan.fiveten.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.beelan.fiveten.R;
import com.example.beelan.fiveten.adapters.PayConfirmAdapter;
import com.example.beelan.fiveten.supports.PayConfirmList;

import java.util.ArrayList;
import java.util.List;


public class PayConfirmFragment extends Fragment {


    public static final String TAG = "SubmitPayFragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pay_submit, null);

        ListView listView = (ListView) v.findViewById(R.id.pay_system_confirm_list);
        PayConfirmAdapter confirmAdapter = new PayConfirmAdapter(getContext(), R.layout.pay_confir_list_item, initItemList());

        listView.setAdapter(confirmAdapter);

        return v;
    }

    private List<PayConfirmList> initItemList() {
        List<PayConfirmList> list = new ArrayList<PayConfirmList>();

        list.add(new PayConfirmList(1, "Статус", "Ожидает подтверждения"));

        return list;
    }

}
