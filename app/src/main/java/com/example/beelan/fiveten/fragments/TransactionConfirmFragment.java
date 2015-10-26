package com.example.beelan.fiveten.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.beelan.fiveten.R;
import com.example.beelan.fiveten.adapters.LayoutFragmentAdapter;
import com.example.beelan.fiveten.supports.FragmentComponentsList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionConfirmFragment extends Fragment {
    public static final String TAG = "TransactionConfirmFragment";
    public static final int LIST_ITEM = R.layout.confirm_list_item;
    public static final int LIST_VIEW_ID = R.id.transaction_confirm_list;
    public static final int BTN_TRANSACTION_CANCEL = R.id.btn_transaction_cancel;
    public static final int BTN_TRANSACTION_SUBMIT = R.id.btn_transaction_submit;
    private ListView listView;
    private Button submit;
    private Button cancel;
    private String currentTime = new SimpleDateFormat("HH:mm").format(new Date());


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_transaction_confirm, null);

        listView = (ListView) v.findViewById(LIST_VIEW_ID);
        final List<FragmentComponentsList> list = initItemList();
        final LayoutFragmentAdapter mAdapter = new LayoutFragmentAdapter(getContext(), LIST_ITEM, list);
        listView.setAdapter(mAdapter);
        submit = (Button) v.findViewById(BTN_TRANSACTION_SUBMIT);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showDialog();
                String currTime = new SimpleDateFormat("HH:mm").format(new Date());
                list.add(new FragmentComponentsList(5, "Именено", "сегодня," + currTime));
                mAdapter.notifyDataSetChanged();
                initDeleteBtn();
            }
        });

        cancel = (Button) v.findViewById(BTN_TRANSACTION_CANCEL);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }

    private void initDeleteBtn() {
        cancel.setVisibility(View.GONE);
        submit.setVisibility(View.GONE);

    }


    private List<FragmentComponentsList> initItemList() {
        List<FragmentComponentsList> list = new ArrayList<FragmentComponentsList>();
        list.add(new FragmentComponentsList(1, "Статус", "Ожидает подтверждения"));
        list.add(new FragmentComponentsList(2, "Дата", "сегодня," + currentTime));
        list.add(new FragmentComponentsList(3, "Платежная система", "Доллар"));
        list.add(new FragmentComponentsList(4, "Сумма", "2,00"));
        return list;

    }
}
