package com.itheima.mypractice;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

/**
 * Created by XuZhaoyu on 2016/12/18.
 */

public class MyDialog extends Dialog {
    public MyDialog(Context context) {
        super(context);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = getContext().getResources().getDisplayMetrics().widthPixels;
        attributes.gravity = Gravity.BOTTOM;
        attributes.flags = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        window.setAttributes(attributes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viee_item_dialog);
        ListView listView = (ListView) findViewById(R.id.lv_dialog);

    }
}
