package com.example.administrator.animationdemo;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/21.
 * 没有啥好的素材（暂时就这样）
 */

public class FrameAnimationActivity extends BaseActivity {
    private ImageView iv_frame_animation;
    private TextView tv_startframe;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_frameanimation);
        iv_frame_animation = (ImageView) findViewById(R.id.iv_frame_animation);
        tv_startframe = (TextView) findViewById(R.id.tv_startframe);

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
//        有一点需要强调的是：启动Frame动画的代码animationDrawable.start();不能应用在OnCreate()方法中，
//        因为在OnCreate()中AnimationDrawable还没有完全的与ImageView绑定。在OnCreate()中启动动画，只能看到第一张图片。
//        这里在触摸事件中实现的
        tv_startframe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_frame_animation.setBackgroundResource(R.drawable.frame);
                AnimationDrawable animationDrawable = (AnimationDrawable) iv_frame_animation.getBackground();
                animationDrawable.start();

            }
        });

    }

    @Override
    protected void loadData() {

    }
}
