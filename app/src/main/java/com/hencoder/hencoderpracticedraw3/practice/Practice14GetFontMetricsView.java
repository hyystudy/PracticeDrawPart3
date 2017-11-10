package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice14GetFontMetricsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String[] texts = {"A", "a", "J", "j", "Â", "â"};
    int top = 200;
    int bottom = 400;
    private float mOffset;

    public Practice14GetFontMetricsView(Context context) {
        super(context);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        mOffset = -(fontMetrics.descent + fontMetrics.ascent) / 2;

        //fontMetric 由textSize 决定 对于不同字母 不管大小写 都是一样的
        //而paint2.getTextBounds（）则是由 不同字母 大小写决定了文字矩形范围的大小
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getFontMetrics() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐

        int middle = (top + bottom) / 2;
        canvas.drawText(texts[0], 100, middle + mOffset, paint2);
        canvas.drawText(texts[1], 200, middle + mOffset, paint2);
        canvas.drawText(texts[2], 300, middle + mOffset, paint2);
        canvas.drawText(texts[3], 400, middle + mOffset, paint2);
        canvas.drawText(texts[4], 500, middle + mOffset, paint2);
        canvas.drawText(texts[5], 600, middle + mOffset, paint2);
    }
}
