package com.qianfeng.android_day42;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

/**
 * ActionBar只能存在于页面的顶部
 * 而Toolbar可以存在页面任何位置
 * 可以随便自定义,还可以当做一个普通的view
 * 为什么开发过程中有些人喜欢自定义
 * （自定义难度也不大，可以不同的设计随意的更改，不用受到api的限制
 * UI一般采取一种设计风格，把title放在居中的位置
 * ）
 */
public class MainActivity extends AppCompatActivity {

    protected DrawerLayout mDraw;
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        initView();
        mToolbar.setTitle("1605");
        mToolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(mToolbar);
    }

    private void initView() {
        mDraw = (DrawerLayout) findViewById(R.id.draw);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

//        mDraw.openDrawer(Gravity.LEFT);
//        mDraw.closeDrawer(Gravity.LEFT);


        //TODO 
        mDraw.addDrawerListener(new ActionBarDrawerToggle(this, mDraw, mToolbar, R.string.app_name, R.string.app_name) {

        });

//        mDraw.addDrawerListener(new DrawerLayout.DrawerListener() {
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//
//            }
//
//            @Override
//            public void onDrawerStateChanged(int newState) {
//
//            }
//        });


    }
}
