package com.itheima.mypractice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by XuZhaoyu on 2016/12/18.
 */

public class MyView extends LinearLayout {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.view_my, this);
        TextView tvTopTitle = (TextView) view.findViewById(R.id.topTitle);
        TextView tvBottomTitle = (TextView) view.findViewById(R.id.bottomTitle);
        ImageView ivIcon = (ImageView) view.findViewById(R.id.middleIcon);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        String topTitle = typedArray.getString(R.styleable.MyView_top_title);
        String bottomTitle = typedArray.getString(R.styleable.MyView_bottom_title);
        Drawable icon = typedArray.getDrawable(R.styleable.MyView_image);

        tvTopTitle.setText(topTitle);
        tvBottomTitle.setText(bottomTitle);
        ivIcon.setImageDrawable(icon);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
