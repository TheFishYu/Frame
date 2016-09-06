package com.qianfeng.costomview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dupengfei on 16/8/15.
 * ViewGroup继承与view
 * ViewGroup中可以嵌套其他view或者Group
 * ViewGroup是一个容器,侧重点是子view的排列方式
 * view的侧重点就是显示
 * <p/>
 * 当前例子视图模仿一个垂直的线性布局
 * 先执行onMeasure在执行onLayout
 */
public class CostomViewGroup extends ViewGroup {


    public CostomViewGroup(Context context) {
        super(context);
    }

    public CostomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 计算宽高
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);

        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        //垂直的线性布局
        //宽是所有子view中最宽的值，高是所有子view的高度相加

        int childCount = getChildCount();

        int width = 0;
        int height = 0;
        //唤醒所有子view去绘制自己
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //遍历所有的子view
        for (int i = 0; i < childCount; i++) {

            View childAt = getChildAt(i);
            //获取一个view的宽度
            int measuredWidth = childAt.getMeasuredWidth();
            //获取所有子view中宽度最大值
            if (measuredWidth > width) width = measuredWidth;

            //加上所有子view的高度和
            height += childAt.getMeasuredHeight();

        }


        //重新设置宽高
        setMeasuredDimension(modeWidth == MeasureSpec.AT_MOST ? width : sizeWidth,
                modeHeight == MeasureSpec.AT_MOST ? height : sizeHeight
        );

    }

    /**
     * 计算子view摆放位置的
     *
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int width = 0;
        for (int i = 0; i < childCount; i++) {

            View childAt = getChildAt(i);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            //摆放子View

            //childAt.layout(0,上一个view高度,自己的宽，上一个view的高加上自己的高);
            childAt.layout(0, width, measuredWidth, width + measuredHeight);
            width += measuredHeight;
        }

    }
}
