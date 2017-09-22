package com.example.administrator.animationdemo.view;

import android.view.View;

/**
 * Created by Administrator on 2017/9/21.
 * *包装类用于封装View的with、height,
 * 你可以通过getXxx以及setXxx方法设置View的宽和高
 * 参考，有讲解
 * https://www.2cto.com/kf/201410/342375.html
 */

public class WrapView {
    private View view;
    private int width;
    private int height;
    public WrapView(View view){
        this.view=view;
    }
    public int getWidth() {
        return view.getLayoutParams().width;
    }
    public void setWidth(int width) {
        this.width = width;
        view.getLayoutParams().width=width;//修改View的高度
        view.requestLayout();//刷新View的布局
    }
    public int getHeight() {
        return view.getLayoutParams().height;
    }
    public void setHeight(int height) {
        this.height=height;
        view.getLayoutParams().height = height;
        view.requestLayout();
    }
}
