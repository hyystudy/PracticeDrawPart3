package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by heyangyang on 2017/11/9.
 * 这个view 主要是用来体现android view 的绘制流程
 * view的绘制基本都在 draw() 方法中
 * draw里面又包含了
 * 1.drawBackground(canvas) //不能重写
 * 2.onDraw(canvas) //绘制主题
 * 3.dispatchDraw(canvas);//绘制子view（viewgroup中会调用）
 * 4.drawForeground(canvas); 绘制前景
 * viewgroup 中一般为了提高效率  会绕过draw()方法  在dispatchDraw()中进行绘制，
 * 当然我们可以通过给viewgroup设置View.setWillNotDraw(false)来让viewgroup不跳过draw方法
 */

public class MyCustomDrawView extends View {
    private static final String TAG = "MyCustomDrawView";

    public MyCustomDrawView(Context context) {
        super(context);
    }

    public MyCustomDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "ondraw");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Log.d(TAG, "dispatchDraw");

    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
        Log.d(TAG, "onDrawForeground");

    }
}
