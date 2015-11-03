package com.example.beelan.interInvest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.beelan.interInvest.R;
import com.example.beelan.interInvest.supports.DepositComponentsList;

import java.util.List;

public class DepositAdapter extends BaseAdapter {

    private List<DepositComponentsList> list;
    private LayoutInflater layoutInflater;
    private int itemListLayout;
    private TextView key;
    private TextView value1;
    private TextView value2;
    private TextView value3;

    public DepositAdapter(List<DepositComponentsList> list, Context context, int resours) {
        this.list = list;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemListLayout = resours;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null){
            view = layoutInflater.inflate(itemListLayout, null);
        }

        key    = (TextView) view.findViewById(R.id.key);
        value1 = (TextView) view.findViewById(R.id.value1);
        value2 = (TextView) view.findViewById(R.id.value2);
        value3 = (TextView) view.findViewById(R.id.value3);
        DepositComponentsList items = getConfirmList(position);

        key.setText(items.getKey());
        value1.setText(items.getValue1());
        value2.setText(items.getValue2());
        value3.setText(items.getValue3());


        return view;
    }

    private DepositComponentsList getConfirmList(int position){
        return (DepositComponentsList) getItem(position);
    }

}
