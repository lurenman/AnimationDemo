package com.example.administrator.animationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/21.
 */

public class AnimatorSetActivity extends BaseActivity {
    private TextView tv_Together;
    private TextView tv_orderTogether;
    private ImageView iv_namei;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_animatorset);
        tv_Together = (TextView) findViewById(R.id.tv_Together);//多动画Together
        tv_orderTogether = (TextView) findViewById(R.id.tv_orderTogether);//多动画按次序执行
        iv_namei = (ImageView) findViewById(R.id.iv_namei);
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        tv_Together.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator_x = ObjectAnimator.ofFloat(iv_namei, "scaleX", 1f, 0.4f);
                ObjectAnimator objectAnimator_y = ObjectAnimator.ofFloat(iv_namei, "scaleY", 1f, 0.4f);
                ObjectAnimator objectAnimator_alpha = ObjectAnimator.ofFloat(iv_namei, "alpha", 1f, 0.4f);
//                objectAnimator_alpha.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        float value= (float) animation.getAnimatedValue();
//                        iv_namei.setAlpha(value);
//                    }
//                });

                AnimatorSet animSet = new AnimatorSet();
                animSet.setDuration(2000);
                animSet.setInterpolator(new LinearInterpolator());
                //两个动画同时执行
                animSet.playTogether(objectAnimator_x,objectAnimator_y,objectAnimator_alpha);
                animSet.start();


            }
        });
        tv_orderTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = iv_namei.getX();
                ObjectAnimator anim1 = ObjectAnimator.ofFloat(iv_namei, "scaleX", 1f, 0.4f);
                ObjectAnimator anim2 = ObjectAnimator.ofFloat(iv_namei, "scaleY", 1f, 0.4f);
                //ObjectAnimator objectAnimator_alpha = ObjectAnimator.ofFloat(iv_namei, "alpha", 1f, 0.4f);
                ObjectAnimator anim3 = ObjectAnimator.ofFloat(iv_namei,//要想达到真正到0f应该就理用监听时刻更新getx（）
                        "x",  x ,  0f);   //这个代表在x轴的平移量
                ObjectAnimator anim4 = ObjectAnimator.ofFloat(iv_namei,
                        "x", x);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(anim1).with(anim2);
                animatorSet.play(anim2).with(anim3);
                animatorSet.play(anim4).after(anim3);
                animatorSet.setDuration(1000);
                animatorSet.start();



            }
        });
    }

    @Override
    protected void loadData() {

    }
}
