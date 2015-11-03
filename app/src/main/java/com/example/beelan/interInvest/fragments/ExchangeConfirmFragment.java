package com.example.beelan.interInvest.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.beelan.interInvest.R;
import com.example.beelan.interInvest.adapters.LayoutFragmentAdapter;
import com.example.beelan.interInvest.supports.FragmentComponentsList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by beeLAN on 26.10.2015.
 */
public class ExchangeConfirmFragment extends Fragment {

    public static final String TAG = "ExchangeConfirmFragment";

    public static final int FRAGMENT_EXCHANGE_CONFIRM = R.layout.fragment_exchange_confirm;
    public static final int LIST_ITEM = R.layout.confirm_list_item;
    public static final int LIST_VIEW_ID = R.id.exchange_confirm_list;
    public static final int BTN_EXCHANGE_CANCEL = R.id.btn_exchange_cancel;
    public static final int BTN_EXCHANGE_SUBMIT = R.id.btn_exchange_submit;

    private ListView listView;
    private Button submit;
    private Button cancel;
    private String currentTime = new SimpleDateFormat("HH:mm").format(new Date());
    private List<FragmentComponentsList> list;
    private LayoutFragmentAdapter mAdapter;
    private LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(FRAGMENT_EXCHANGE_CONFIRM, null);

        listView = (ListView) v.findViewById(LIST_VIEW_ID);
        list = initItemList();
        mAdapter = new LayoutFragmentAdapter(getContext(), LIST_ITEM, list);
        listView.setAdapter(mAdapter);
        submit = (Button) v.findViewById(BTN_EXCHANGE_SUBMIT);
        linearLayout = (LinearLayout) v.findViewById(R.id.alertContainer);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        cancel = (Button) v.findViewById(BTN_EXCHANGE_CANCEL);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }
    private void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Выбирите действие.")
                .setMessage("Вы желаете подтвердить?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String currTime = new SimpleDateFormat("HH:mm").format(new Date());
                        list.add(new FragmentComponentsList(5, "Именено", "сегодня," + currTime));
                        mAdapter.notifyDataSetChanged();
                        initDeleteBtn();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void initDeleteBtn() {
        cancel.setVisibility(View.GONE);
        submit.setVisibility(View.GONE);
        linearLayout.setVisibility(View.GONE);
    }


    private List<FragmentComponentsList> initItemList() {
        List<FragmentComponentsList> list1 = new ArrayList<FragmentComponentsList>();
        list1.add(new FragmentComponentsList(1, "Статус", "Ожидает подтверждения"));
        list1.add(new FragmentComponentsList(2, "Дата", "сегодня," + currentTime));
        list1.add(new FragmentComponentsList(3, "Платежная система", "Доллар"));
        list1.add(new FragmentComponentsList(4, "Сумма", "2,00"));
        return list1;

    }
}
