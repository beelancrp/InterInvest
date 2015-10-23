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


public class PayConfirmFragment extends Fragment {

    public static final String TAG = "PayConfirmFragment";
    public static final int PAY_CONFIR_LIST_ITEM = R.layout.pay_confir_list_item;
    public static final int LIST_VIEW_ID = R.id.pay_system_confirm_list;
    private ListView listView;
    private Button submit;
    private Button cancel;
    private String currentTime = new SimpleDateFormat("HH:mm").format(new Date());


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pay_submit, null);

        listView = (ListView) v.findViewById(LIST_VIEW_ID);
        final List<FragmentComponentsList> list = initItemList();
        final LayoutFragmentAdapter mAdapter = new LayoutFragmentAdapter(getContext(), PAY_CONFIR_LIST_ITEM, list);
        listView.setAdapter(mAdapter);
        submit = (Button) v.findViewById(R.id.btn_popolnenie_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showDialog();
                list.add(new FragmentComponentsList(5, "Именено", "сегодня," + currentTime));
                mAdapter.notifyDataSetChanged();
                initDeleteBtn();
            }
        });

        cancel = (Button) v.findViewById(R.id.btn_cancel);
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

    private String getChangedTime (String time){
        String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
        if(currentTime != time){
            return currentTime;
        }else {
            return time;
        }

    }

    public static String getName() {
        return TAG;
    }
}
