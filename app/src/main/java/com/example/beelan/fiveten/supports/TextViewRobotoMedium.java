package com.example.beelan.fiveten.supports;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.beelan.fiveten.R;

public class TextViewRobotoMedium extends TextView {

    public TextViewRobotoMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.font_roboto_medium)));
    }

    public TextViewRobotoMedium(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.font_roboto_medium)));
    }

    public TextViewRobotoMedium(Context context) {
        super(context);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), context.getResources().getString(R.string.font_roboto_medium)));
    }
}