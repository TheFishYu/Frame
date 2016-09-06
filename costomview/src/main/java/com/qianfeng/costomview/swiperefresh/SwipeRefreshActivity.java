package com.qianfeng.costomview.swiperefresh;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.qianfeng.costomview.R;
import com.qianfeng.costomview.pulltorefresh.PullAdapter;

/**
 * android v4包下面的控件
 * <p/>
 * 之前ios，pulltorefresh最早是ios的设计风格
 * 公司共就一个UI,仿ios
 * 4.0 谷歌慢慢改变自己自己的设计风格
 * cardview
 * swiperefreshlayout
 */
public class SwipeRefreshActivity extends AppCompatActivity {

    protected ListView mList;
    protected SwipeRefreshLayout mSwipe;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //完成刷新
            mSwipe.setRefreshing(false);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_swipe_refresh);
        initView();
    }

    private void initView() {
        mList = (ListView) findViewById(R.id.list);
        mSwipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        //设置进度在几个颜色中进行改变
        mSwipe.setColorSchemeColors(Color.RED, Color.YELLOW, Color.BLUE);
        //设置进度圈大小
        mSwipe.setSize(SwipeRefreshLayout.LARGE);
        //设置和view的距离
        mSwipe.setProgressViewOffset(true, 200, 300);
        //设置进度圈北京色
        mSwipe.setProgressBackgroundColorSchemeColor(Color.BLACK);
        mList.setAdapter(new PullAdapter());

        //只有下拉
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new MyThread().start();

            }
        });


    }


    public class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                sleep(1000);
                mHandler.sendEmptyMessage(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
