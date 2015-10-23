package com.example.beelan.fiveten.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.beelan.fiveten.R;
import com.example.beelan.fiveten.supports.FragmentComponentsList;

import java.util.List;

public class LayoutFragmentAdapter extends ArrayAdapter<FragmentComponentsList> {

    List<FragmentComponentsList> list1;
    LayoutInflater layoutInflater;
    private int itemListLayout;

    public LayoutFragmentAdapter(Context context, int resource, List<FragmentComponentsList> list) {
        super(context, resource, list);
        this.list1 = list;
        this.itemListLayout = resource;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null){
            view = layoutInflater.inflate(itemListLayout, null);
        }

        FragmentComponentsList confirmList = getConfirmList(position);

        TextView title  = (TextView) view.findViewById(R.id.aaaaa);
        TextView value  = (TextView) view.findViewById(R.id.qqqq);

        title.setText(confirmList.getTitle());
        value.setText(confirmList.getValue());

        return view;
    }

    private FragmentComponentsList getConfirmList(int position){
        return getItem(position);
    }

//    @Override
//    public int getCount() {
//        return list1.size();
//    }
//
//    @Override
//    public FragmentComponentsList getItem(int position) {
//        return list1.get(position);
//    }
//
//
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
}
