package com.example.beelan.interInvest.supports;


import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.beelan.interInvest.R;

public class TextviewRobotoLight extends TextView{

    public TextviewRobotoLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.font_roboto_light)));
    }

    public TextviewRobotoLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.font_roboto_light)));
    }

    public TextviewRobotoLight(Context context) {
        super(context);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.font_roboto_light)));
    }
}
