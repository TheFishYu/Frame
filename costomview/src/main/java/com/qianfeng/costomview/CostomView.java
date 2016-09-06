package com.qianfeng.costomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by dupengfei on 16/8/15.
 */
public class CostomView extends View {

    private int length = 100;

    public CostomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CostomView(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawLine(0, 0, length, length, paint);
    }


    /**
     * 用于测量view的宽高
     * 当自定义的宽高设置为wrap的时候显示不是我们想要结果
     * TextView这种官方控件已经重写了自己的宽和高
     * macth 固定宽高
     * 需要针对wrap的情况动态计算宽高
     * 1首先要判断目前宽高是哪种赋值(wrap还是固定宽高)
     * 2如果是wrap，需要重写计算宽高的方法，不是的话就按照本来设置的宽高
     *
     * @param widthMeasureSpec  测量值
     * @param heightMeasureSpec 测量值
     *                          <p/>
     *                          测量值 = 测量模式+测量尺寸（就是宽和高的值）
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);

        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(modeWidth == MeasureSpec.AT_MOST ? length : sizeWidth,
                modeHeight == MeasureSpec.AT_MOST ? length : sizeHeight);
    }
}
