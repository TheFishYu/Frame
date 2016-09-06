package com.qianfeng.android_day42;

import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * 1drawlayout是侧滑菜单覆盖主页面，SlidiPaneLayout主页随着侧滑也向右边移动
 * 2drawlayout中第一个子view是主布局，SlidiPaneLayout中第二个是主布局
 * 3drawlayout 可以实现左右分别有侧滑，SlidiPaneLayout只能从左
 */

public class SlidiPaneActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView mText;
    protected SlidingPaneLayout mSlidingpane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_slidi_pane);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.text) {

            mSlidingpane.openPane();

            mSlidingpane.closePane();

            mSlidingpane.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
                @Override
                public void onPanelSlide(View panel, float slideOffset) {

                }

                @Override
                public void onPanelOpened(View panel) {

                }

                @Override
                public void onPanelClosed(View panel) {

                }
            });
        }
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text);
        mText.setOnClickListener(SlidiPaneActivity.this);
        mSlidingpane = (SlidingPaneLayout) findViewById(R.id.slidingpane);
    }
}
