package com.example.administrator.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_tweenAnimation;
    private TextView tv_frameAnimation;
    private TextView tv_propertyAnimation;
    private TextView tv_propertyDetialAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
    }
    private void initViews() {
        tv_tweenAnimation = (TextView) findViewById(R.id.tv_tweenAnimation);
        tv_frameAnimation = (TextView) findViewById(R.id.tv_frameAnimation);
        tv_propertyAnimation = (TextView) findViewById(R.id.tv_propertyAnimation);
        tv_propertyDetialAnimation = (TextView) findViewById(R.id.tv_propertyDetialAnimation);
    }
    private void initEvents() {
        tv_tweenAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TweenAnimationActivity.class);
                startActivity(intent);
            }
        });
        tv_frameAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FrameAnimationActivity.class);
                startActivity(intent);
            }
        });
        tv_propertyAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PropertyAnimationActivity.class);
                startActivity(intent);
            }
        });
        tv_propertyDetialAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PropertyDetialAnimationActivity.class);
                startActivity(intent);
            }
        });
    }

}
