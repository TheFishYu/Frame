package com.qianfeng.costomview.pulltorefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.costomview.R;

public class PullTorefreshActivity extends AppCompatActivity {

    protected PullToRefreshListView mPulllist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_pull_torefresh);
        initView();
    }

    private void initView() {
        mPulllist = (PullToRefreshListView) findViewById(R.id.pulllist);
        PullAdapter pullAdapter = new PullAdapter();
        mPulllist.setAdapter(pullAdapter);

        mPulllist.setMode(PullToRefreshBase.Mode.BOTH);
        mPulllist.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {

            //下拉监听
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //请求网络


                //数据请求完毕之后恢复到默认的样子
                mPulllist.onRefreshComplete();
            }

            //上拉的监听
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });

        //
        ILoadingLayout loadingLayoutProxy = mPulllist.getLoadingLayoutProxy();
        loadingLayoutProxy.setLoadingDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        loadingLayoutProxy.setPullLabel("setPullLabel");
        loadingLayoutProxy.setRefreshingLabel("setRefreshingLabel");

    }


}
