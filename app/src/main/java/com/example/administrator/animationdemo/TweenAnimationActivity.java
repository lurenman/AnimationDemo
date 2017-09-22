package com.example.administrator.animationdemo;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/20.
 * 参考文章
 * https://www.2cto.com/kf/201410/342375.html
 * http://blog.csdn.net/xiaanming/article/details/8997260
 * 发现开启alpha动画会组织其他动画（可能我想错了）
 *
 */

public class TweenAnimationActivity extends BaseActivity {
    private TextView tv_Translate;
    private TextView tv_Scale;
    private TextView tv_Alpha;
    private TextView tv_Rotate;
    private ImageView iv_namei;
    private TextView tv_Set;

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_tweenanimation);
        iv_namei = (ImageView) findViewById(R.id.iv_namei);
        tv_Translate = (TextView) findViewById(R.id.tv_Translate);//平移
        tv_Scale = (TextView) findViewById(R.id.tv_Scale);//缩放
        tv_Alpha = (TextView) findViewById(R.id.tv_Alpha);//透明度
        tv_Rotate = (TextView) findViewById(R.id.tv_Rotate);//旋转
        tv_Set = (TextView) findViewById(R.id.tv_Set);//多种动画混合
    }
//Animation.RELATIVE_TO_SEL 这个方法
    @Override
    protected void initEnvent() {
        super.initEnvent();
        tv_Translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //方式一通过代码的方式定义位移动画
                Animation translateAnimation = new TranslateAnimation(0, 150, 0, 0);
                translateAnimation.setDuration(2000);
                //设置动画插入器 下面注解有好几种插入器可以依次试试
                translateAnimation.setInterpolator(mContext, android.R.anim.bounce_interpolator);
             //   iv_namei.offsetLeftAndRight(150); //这个方法是让view位置真实的平移的
                //设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
                translateAnimation.setFillAfter(true);
            /*    参数fillBefore为是否执行起始填充效果，true表示使能该效果，false表示禁用该效果。
                该方法的执行，需要首先通过setFillEnabled方法使能填充效果，否则设置无效。*/
//                translateAnimation.setFillEnabled(true);
                //没发现有啥效果 请参考http://blog.csdn.net/fengkuanghun/article/details/7878862
//                translateAnimation.setFillBefore(true);
                iv_namei.startAnimation(translateAnimation);
                //方式二通过在xml中定义 位移动画    xml 根节点一定要是translate（如果是set就达不到想要的效果）
//                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.translate);//加载Xml文件中的动画
//                iv_namei.startAnimation(animation);


            }
        });
        tv_Scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fromXScale（浮点型）属性为动画起始时X坐标上的缩放尺寸
//                fromYScale（浮点型）属性为动画起始时Y坐标上的缩放尺寸
//                toXScale（浮点型） 属性为动画结束时X坐标上的缩放尺寸
//                toYScale（浮点型） 属性为动画结束时Y坐标上的缩放尺寸
                //           float pivotX, float pivotY 可以指定缩放中心坐标
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 1.0f, 1.0f);//不解释
                scaleAnimation.setDuration(2000);
                scaleAnimation.setFillAfter(true);
                //这个重复的次数是你执行一次动画之后在次执行的次数（所以你就会看到3次重复）
                scaleAnimation.setRepeatCount(2);
//                设置动画重复的模式，有Animation.REVERSE和Animation.RESTART两种方式，默认为Animation.RESTART，Animation.RESTART
//                的意思就是说比如你设置重复次数为1，当执行完第一次动画之后，回到动画开始然后执行第二次动画，而你设置Animation.REVERSE时候，
//                比如你动画是从不透明----->透明，执行完第一次动画的时候，变为不透明，然后执行第二次动画，他就从不透明到透明.
                //scaleAnimation.setRepeatMode(Animation.REVERSE); //这个可以体会一下还有注意RepeatCount
                iv_namei.startAnimation(scaleAnimation);
//                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.scale);
//                iv_namei.startAnimation(animation);


            }
        });
        tv_Alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlphaAnimation alphaAnimation = new AlphaAnimation(1, (float) 0.2);
//                alphaAnimation.setDuration(2000);
//                alphaAnimation.setFillAfter(true);
//                iv_namei.startAnimation(alphaAnimation);

                //xml方式
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.alpha);
                iv_namei.startAnimation(animation);

            }
        });
        tv_Rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RotateAnimation rotateAnimation = new RotateAnimation(0, 180, iv_namei.getWidth()/2, iv_namei.getHeight()/2);
//                rotateAnimation.setDuration(2000);
//                rotateAnimation.setFillAfter(true);
//                iv_namei.startAnimation(rotateAnimation);
                //xml方式
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.rotate);
                iv_namei.startAnimation(animation);
            }
        });

        tv_Set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //方式一通过代码的方式定义动画集 在new一个AnimationSet中传入true则所有的Animation共用Interpolator
//                AnimationSet animationSet = new AnimationSet(true);
//                Animation translateanimation = AnimationUtils.loadAnimation(mContext, R.anim.translate);
//                Animation scaleanimation = AnimationUtils.loadAnimation(mContext, R.anim.scale);
//                Animation alphaanimation = AnimationUtils.loadAnimation(mContext, R.anim.alpha);
//                Animation rotateanimation = AnimationUtils.loadAnimation(mContext, R.anim.rotate);
//
//                animationSet.addAnimation(translateanimation);
//                animationSet.addAnimation(scaleanimation);
//                animationSet.addAnimation(alphaanimation);
//                animationSet.addAnimation(rotateanimation);
//                animationSet.setInterpolator(mContext,android.R.anim.bounce_interpolator);
//                animationSet.setDuration(4000);
//                animationSet.setFillAfter(true);
//                iv_namei.startAnimation(animationSet);

                //xml方式   默认AnimationSet(true)，对默认就是true
                Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.animset);
                iv_namei.startAnimation(animation);
            }
        });


    }

    @Override
    protected void loadData() {

    }
/*  我们可以为每一个动画设置动画插入器，Android自带的几种动画插入器：
    AccelerateInterpolator
    加速，开始时慢中间加速
    DecelerateInterpolator
    减速，开始时快然后减速
    AccelerateDecelerateInterolator
    先加速后减速，开始结束时慢，中间加速
    AnticipateInterpolator
    反向，先向相反方向改变一段再加速播放
    AnticipateOvershootInterpolator
    反向加超越，先向相反方向改变，再加速播放，会超出目的值然后缓慢移动至目的值
    BounceInterpolator
    跳跃，快到目的值时值会跳跃，如目的值100，后面的值可能依次为85，77，70，80，90，100
    CycleIinterpolator
    循环，动画循环一定次数，值的改变为一正弦函数：Math.sin(2* mCycles* Math.PI* input)
    LinearInterpolator
    线性，线性均匀改变
    OvershottInterpolator
   超越，最后超出目的值然后缓慢改变到目的值*/
}
