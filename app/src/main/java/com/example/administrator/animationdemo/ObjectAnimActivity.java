package com.example.administrator.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/21.
 */

public class ObjectAnimActivity extends BaseActivity {
    private ImageView iv_namei;
    private TextView tv_scaleX;
    private TextView tv_scaleXY;
    private TextView tv_rotation;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_objectanim);
        iv_namei = (ImageView) findViewById(R.id.iv_namei);
        tv_scaleX = (TextView) findViewById(R.id.tv_scaleX);
        tv_scaleXY = (TextView) findViewById(R.id.tv_scaleXY);
        tv_rotation = (TextView) findViewById(R.id.tv_rotation);
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        iv_namei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //感觉这个东西就是一个在一段期间改变一个值通过它做出的效果
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv_namei, "by", 1.0F, 0.4F);
                objectAnimator.setDuration(2000);
                //添加一个插补器
                objectAnimator.setInterpolator(new BounceInterpolator());
                //这个东西是确定值更新范围的，根据前后值顺序更新
                // objectAnimator.setFloatValues(0.8F,0.2F);
                //  objectAnimator.setCurrentFraction(0.4F);//待解
                objectAnimator.start();

                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        iv_namei.setScaleX(value);
                        iv_namei.setScaleY(value);
                    }
                });
            }
        });
        //下面方式通过xml方式实现objectAnimator 属性动画 用到AnimatorInflater
        tv_scaleX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animator anim = AnimatorInflater.loadAnimator(mContext, R.animator.scalex);
                anim.setTarget(iv_namei);
                anim.start();
                //如果  android:propertyName="scaleX" 这个不指定可以用下面的方式来UpdateListener完成ui更新的操作
                //感觉不管咋做propertyName 这个东西里知道
//                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(mContext,R.animator.scalex);
//                objectAnimator.setTarget(iv_namei);
//                objectAnimator.start();
//                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        float value= (float) animation.getAnimatedValue();
//                        iv_namei.setScaleX(value);
//                    }
//                });

            }
        });
        tv_scaleXY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 加载动画
                Animator anim = AnimatorInflater.loadAnimator(mContext, R.animator.scale);
                //这个东西指定缩放中心的，xml中可以定义默认是中心
                iv_namei.setPivotX(0);
                iv_namei.setPivotY(0);
//                iv_namei.setPivotX(iv_namei.getWidth()/2);
//                iv_namei.setPivotY(iv_namei.getHeight()/2);
                anim.setTarget(iv_namei);
                anim.start();
            }
        });
        tv_rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发现不用   AnimatorSet也可以，要是补间动画就白扯了
                ObjectAnimator
                        .ofFloat(iv_namei, "rotationX", 0.0F, 360.0F)
                        .setDuration(500)
                        .start();
                ObjectAnimator
                        .ofFloat(iv_namei, "rotationY", 0.0F, 360.0F)
                        .setDuration(500)
                        .start();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
