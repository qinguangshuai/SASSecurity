package com.qgsstrive.sassecurity.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @date 2020/10/22 15:33
 */
public class FirstCustom extends View {

    private Paint mPaint, paint;
    private Bitmap mBitmap;
    private Canvas mCanvas1;

    public FirstCustom(Context context) {
        this(context, null);
    }

    public FirstCustom(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public FirstCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建一个画笔
        mPaint = new Paint(Paint.DITHER_FLAG);
        //设置位图的宽高
        mBitmap = Bitmap.createBitmap(1280, 800, Bitmap.Config.RGB_565);
        //绘制内容保存到Bitmap
        mCanvas1 = new Canvas(mBitmap);
        //设置非填充
        mPaint.setStyle(Paint.Style.STROKE);
        //笔宽5像素
        mPaint.setStrokeWidth(3);
        //设置为红笔
        mPaint.setColor(Color.parseColor("#59747F"));
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置图像抖动处理
        mPaint.setDither(true);
        //设置图像的结合方式
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        Log.e("123456",width+"    111    "+height);

        canvas.drawLine(50,100,960,100,mPaint);
        canvas.drawLine(50,180,960,180,mPaint);
        canvas.drawLine(50,260,960,260,mPaint);
        canvas.drawLine(50,340,960,340,mPaint);
        canvas.drawLine(50,420,960,420,mPaint);
        canvas.drawLine(50,500,960,500,mPaint);
    }
}
