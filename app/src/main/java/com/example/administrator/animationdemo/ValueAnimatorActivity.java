package com.example.administrator.animationdemo;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/22.
 */

public class ValueAnimatorActivity extends BaseActivity {
    private ImageView iv_namei;
    private TextView tv_verticalRun;
    private TextView tv_paowuxian;
    private TextView tv_fadeOut;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_valueanimator);
        iv_namei = (ImageView) findViewById(R.id.iv_namei);
        tv_verticalRun = (TextView) findViewById(R.id.tv_verticalRun);//垂直
        tv_paowuxian = (TextView) findViewById(R.id.tv_paowuxian);//抛物线
        tv_fadeOut = (TextView) findViewById(R.id.tv_fadeOut);//淡出且删除

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        tv_verticalRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, iv_namei.getHeight());
                valueAnimator.setTarget(iv_namei);
                valueAnimator.setDuration(1000);
                valueAnimator.start();

                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Object animatedValue = animation.getAnimatedValue();

                        //  iv_namei.setTranslationX((float)animatedValue);
                        iv_namei.setTranslationY((float) animatedValue);
                        //   iv_namei.setTranslationZ((float)animatedValue);//没试出啥效果

                    }
                });


            }
        });
        tv_paowuxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ValueAnimator valueAnimator = ValueAnimator.ofObject(new TypeEvaluator() {
//                    @Override
//                    public Object evaluate(float fraction, Object startValue, Object endValue) {
//                        return null;
//                    }
//                }, new PointF(0, 0));
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setDuration(3000);
                valueAnimator.setObjectValues(new PointF(0, 0));
                //说白了也就是一种类型值的变换转换
                valueAnimator.setEvaluator(new TypeEvaluator() {
                    @Override
                    public PointF evaluate(float fraction, Object startValue, Object endValue) {
                        // x方向200px/s ，则y方向0.5 * g * t (g = 100px / s*s)
                        PointF point = new PointF();
                        point.x = 200 * fraction * 3;
                        point.y = 0.5f * 100 * (fraction * 3) * (fraction * 3);
                        return point;
                    }
                });
                valueAnimator.start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        PointF point = (PointF) animation.getAnimatedValue();
                        iv_namei.setX(point.x);
                        iv_namei.setY(point.y);

                    }
                });
            }
        });
        tv_fadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 0.4f);
                valueAnimator.setTarget(iv_namei);
                valueAnimator.setDuration(2000);
                valueAnimator.start();
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float animatedValue = (float) animation.getAnimatedValue();
                        iv_namei.setAlpha(animatedValue);
                    }
                });

                valueAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        ViewGroup parent = (ViewGroup) iv_namei.getParent();
                        if (null!=parent)
                            parent.removeView(iv_namei);

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });


            }
        });
    }

    @Override
    protected void loadData() {

    }
}
