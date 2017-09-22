package com.example.administrator.animationdemo;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/22.
 */

public class ViewAnimateActivity extends BaseActivity {
    private static final String TAG = "ViewAnimateActivity";
    private TextView tv_ViewAnim;
    private TextView tv_PropertyValuesHolder;
    private ImageView iv_namei;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_viewanimate);
        iv_namei = (ImageView) findViewById(R.id.iv_namei);
        tv_ViewAnim = (TextView) findViewById(R.id.tv_ViewAnim);
        tv_PropertyValuesHolder = (TextView) findViewById(R.id.tv_PropertyValuesHolder);

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        //这种东西ObjectAnimator也能实现的
        tv_ViewAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // need API 12
                iv_namei.animate().alpha(0).y(iv_namei.getHeight() * 3 / 4).setDuration(1000)
                        // need API 12
                        .withStartAction(new Runnable() {
                            @Override
                            public void run() {
                                Log.e(TAG, "START");
                            }
                            // need API 16
                        }).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        Log.e(TAG, "END");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                iv_namei.setY(0);
                                iv_namei.setAlpha(1.0f);
                            }
                        });
                    }
                });
            }
        });
        tv_PropertyValuesHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实现一个动画更改多个效果：使用propertyValuesHolder
                //感觉和AnimatorSet 差不多，但是AnimatorSet有那个先后顺序的方法，看着来把
                PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                        0f, 1f);
                PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                        0, 1f);
                PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                        0, 1f);
                ObjectAnimator.ofPropertyValuesHolder(tv_PropertyValuesHolder, pvhX, pvhY, pvhZ).setDuration(1000).start();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
