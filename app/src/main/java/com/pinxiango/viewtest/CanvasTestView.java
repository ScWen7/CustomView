package com.pinxiango.viewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 解晓辉 on 2017/5/31.
 * 作用：
 */

public class CanvasTestView extends View{

    //画笔
    private Paint mPaint;

    private int mWidth; //视图的宽度
    private int mHeight; //视图的高度

    public CanvasTestView(Context context) {
        this(context,null);
    }

    public CanvasTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {

       /*
        画布的Tanslate 的操作测试
       mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(100,100,50,mPaint);

        canvas.translate(100,100);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(100,100,50,mPaint);*/

        //画布的Scale 操作测试
        //ｓｃａｌｅ　值为负数时，视图会根据缩放中心轴进行旋转

       /* mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        canvas.translate(mWidth/2,mHeight/2); //移动到画布中心
        RectF rectF = new RectF(0,-200,200,0);
        canvas.drawRect(rectF,mPaint);

        canvas.scale(-0.5f,-0.5f,100,0);

        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rectF,mPaint);*/


        //对Canvas 进行旋转操作测试
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        canvas.translate(mWidth/2,mHeight/2);
        RectF rectF = new RectF(-200,-200,200,200);
        canvas.drawCircle(0,0,400,mPaint);
        canvas.drawCircle(0,0,380,mPaint);


        canvas.save();
        mPaint.setColor(Color.RED);
        for (int i=0;i<=360;i+=10){
            canvas.drawLine(0,380,0,400,mPaint);
            canvas.rotate(10);
        }
        canvas.restore();

        mPaint.setColor(Color.GREEN);

        float stopX = -380*(float)Math.sin(30);
        float stopY = 380*(float)Math.cos(30);

        Path path = new Path();
        path.moveTo(0,-380);
        path.lineTo(380*(float)Math.sin(30),380*(float)Math.cos(30));
        path.lineTo(stopX,stopY);
        path.close();

//        canvas.drawPath(path,mPaint);

            canvas.drawPath(path,mPaint);
            canvas.rotate(180);
        canvas.drawPath(path,mPaint);


    }
}
