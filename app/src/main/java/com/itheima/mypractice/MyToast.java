package com.itheima.mypractice;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by XuZhaoyu on 2016/12/18.
 */

public class MyToast {

    private WindowManager mWindowManager;
    private TextView mTextView;
    private WindowManager.LayoutParams mParams;

    public MyToast(Context context) {
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mTextView = new TextView(context);
        mParams = new WindowManager.LayoutParams();
        mParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mParams.format = PixelFormat.TRANSLUCENT;
        mParams.windowAnimations = com.android.internal.R.style.Animation_Toast;
        mParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        mParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mParams.gravity = Gravity.LEFT;
    }

    public void showToast() {
        mTextView.setOnTouchListener(new View.OnTouchListener() {

            private int mRawY;
            private int mRawX;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        mRawX = (int) event.getRawX();
                        mRawY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int endX = (int) event.getRawX();
                        int endY = (int) event.getRawY();

                        int diffX = endX - mRawX;
                        int diffY = endY - mRawY;

                        mParams.x += diffX;
                        mParams.y += diffY;

                        mWindowManager.updateViewLayout(mTextView, mParams);

                        mRawX = endX;
                        mRawY = endY;

                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                }


                return true;
            }
        });
        mWindowManager.addView(mTextView, mParams);
    }

    public void hideToast() {
        if (mWindowManager != null) {
            if (mTextView.getParent() != null) {
                mWindowManager.removeView(mTextView);
            }
        }
    }

    public void launch() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(mParams.y,0);
        valueAnimator.setDuration(400);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                mParams.y= value;
                mWindowManager.updateViewLayout(mTextView,mParams);
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });




    }
    //DialogInterface.OnCancelListener

}
