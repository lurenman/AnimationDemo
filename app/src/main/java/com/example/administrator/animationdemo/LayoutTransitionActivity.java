package com.example.administrator.animationdemo;

/**
 * Created by Administrator on 2017/9/22.
 * 过渡的类型一共有四种：
 * LayoutTransition.APPEARING 当一个View在ViewGroup中出现时，对此View设置的动画
 * LayoutTransition.CHANGE_APPEARING 当一个View在ViewGroup中出现时，对此View对其他View位置造成影响，对其他View设置的动画
 * LayoutTransition.DISAPPEARING  当一个View在ViewGroup中消失时，对此View设置的动画
 * LayoutTransition.CHANGE_DISAPPEARING 当一个View在ViewGroup中消失时，对此View对其他View位置造成影响，对其他View设置的动画
 * LayoutTransition.CHANGE 不是由于View出现或消失造成对其他View位置造成影响，然后对其他View设置的动画。
 * 注意动画到底设置在谁身上，此View还是其他View
 */

public class LayoutTransitionActivity extends BaseActivity {
    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_layouttransition);

    }

    @Override
    protected void loadData() {

    }
}
