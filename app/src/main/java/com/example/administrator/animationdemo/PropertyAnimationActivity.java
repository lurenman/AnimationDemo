package com.example.administrator.animationdemo;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.animationdemo.view.WrapView;

/**
 * Created by Administrator on 2017/9/21.
 *
 */

public class PropertyAnimationActivity extends BaseActivity {
    private TextView tv_ceshi;
    private ImageView iv_namei;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_propertyanimation);
        tv_ceshi = (TextView) findViewById(R.id.tv_ceshi);
        iv_namei = (ImageView) findViewById(R.id.iv_namei);
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        tv_ceshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator=ObjectAnimator.ofInt(new WrapView(iv_namei),
                        "width", iv_namei.getWidth());
                animator.setDuration(2000);//设置动画持续的时间
                animator.setRepeatCount(1);//设置动画重复的次数
                animator.start();//开启动画
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
