package com.pinxiango.viewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 解晓辉 on 2017/5/12.
 * 作用：
 */

public class ProgressView extends View {

    private int startDregress;
    /**
     * max   is  360
     */
    private int fullDregress;
    private int len;
    private RectF oval;
    private Paint arcPaint;

    private int stokeWidth = 10;
    private Paint linePaint;

    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        startDregress = 120;
        fullDregress = 300;
        arcPaint = new Paint();
        arcPaint.setColor(Color.MAGENTA);
        arcPaint.setAntiAlias(true);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(10);


        linePaint = new Paint();
        linePaint.setStrokeWidth(2);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setAntiAlias(true);
        linePaint.setColor(Color.GREEN);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        len = Math.min(width, height);
        oval = new RectF(stokeWidth / 2, stokeWidth / 2, len - stokeWidth / 2, len - stokeWidth / 2);
        setMeasuredDimension(len, len);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        绘制起始位置小圆形
//        arcPaint.setStrokeWidth(0);
//        arcPaint.setStyle(Paint.Style.FILL);
//        int circleRadius = len / 2 - stokeWidth / 2;
//        float radians = (float) (((360.0f - fullDregress) / 2) / 180 * Math.PI);
//        float startX = len/2 - circleRadius * (float) Math.sin(radians);
//        float startY = len/2 + circleRadius * (float) Math.cos(radians);
//        canvas.drawCircle(startX, startY, stokeWidth / 2, arcPaint);
        //






        arcPaint.setColor(Color.MAGENTA);
        arcPaint.setStyle(Paint.Style.STROKE);
        //
//        arcPaint.setStrokeCap(Paint.Cap.ROUND);
        arcPaint.setStrokeWidth(stokeWidth);
        canvas.drawArc(oval, startDregress, fullDregress, false, arcPaint);

        drawLineView(canvas);

    }

    private void drawLineView(Canvas canvas) {
        canvas.save();
        canvas.translate(len/2,len/2);
        canvas.rotate(startDregress-90);

        //确定每次旋转的角度
        float rotateAngle=fullDregress/100;
        for(int i=0;i<=100;i++){
            //画一条刻度线
            canvas.drawLine(0,len/2-stokeWidth,0,len/2-stokeWidth-40,linePaint);
            canvas.rotate(rotateAngle);
        }
        canvas.restore();

    }
}
