package com.qianfeng.costomview.drawlayout;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.qianfeng.costomview.R;

/**
 * 1xml中最外层使用android.support.v4.widget.DrawerLayout
 * 2其中有两个布局，上面的布局代表你的主布局，下面代表侧滑菜单中的布局
 * 3手动打开或者关闭
 * 4打开或者关闭的回调
 * <p/>
 * 学会去用忘了去背
 * 高级部分的东西以用为主
 */
public class DrawLayout extends AppCompatActivity implements View.OnClickListener {

    protected Button mOpen;
    protected DrawerLayout mDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_draw_layout);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.open) {
            mDraw.openDrawer(Gravity.LEFT);
        }
    }

    private void initView() {
        mOpen = (Button) findViewById(R.id.open);
        mOpen.setOnClickListener(DrawLayout.this);
        mDraw = (DrawerLayout) findViewById(R.id.draw);
        mDraw.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

                Log.e("侧滑打开", "侧滑打开");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Log.e("侧滑关闭", "侧滑关闭");
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}
