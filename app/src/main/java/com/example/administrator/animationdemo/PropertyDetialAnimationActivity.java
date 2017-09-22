package com.example.administrator.animationdemo;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/21.
 * 参考鸿洋大神博客
 * http://blog.csdn.net/lmj623565791/article/details/38067475
 */

public class PropertyDetialAnimationActivity extends BaseActivity {
    private TextView tv_ObjectAnimator;
    private TextView tv_AnimatorSet;
    private TextView tv_ViewAnimate;
    private TextView tv_ValueAnimator;
    private TextView tv_LayoutTransition;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_propertydetial_animation);
        tv_ObjectAnimator = (TextView) findViewById(R.id.tv_ObjectAnimator);
        tv_AnimatorSet = (TextView) findViewById(R.id.tv_AnimatorSet);
        tv_ViewAnimate = (TextView) findViewById(R.id.tv_ViewAnimate);
        tv_ValueAnimator = (TextView) findViewById(R.id.tv_ValueAnimator);
        tv_LayoutTransition = (TextView) findViewById(R.id.tv_LayoutTransition);

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        tv_ObjectAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PropertyDetialAnimationActivity.this,ObjectAnimActivity.class);
                startActivity(intent);
            }
        });
        tv_AnimatorSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PropertyDetialAnimationActivity.this,AnimatorSetActivity
                        .class);
                startActivity(intent);
            }
        });
        tv_ViewAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PropertyDetialAnimationActivity.this,ViewAnimateActivity
                        .class);
                startActivity(intent);

            }
        });
        tv_ValueAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PropertyDetialAnimationActivity.this,ValueAnimatorActivity
                        .class);
                startActivity(intent);
            }
        });
        tv_LayoutTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PropertyDetialAnimationActivity.this,ValueAnimatorActivity
                        .class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
