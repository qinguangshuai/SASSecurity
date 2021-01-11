package com.qgsstrive.sassecurity.custom.handan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @date 2020/11/22 14:14
 */
public class HeadCustom extends View {

    private Paint mPaint, paint;
    private Bitmap mBitmap;
    private Canvas mCanvas1;
    private Paint mColorpaint;
    private Paint mTextPaint, mTextPaint1;

    public HeadCustom(Context context) {
        this(context, null);
    }

    public HeadCustom(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeadCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建一个画笔
        mPaint = new Paint(Paint.DITHER_FLAG);
        mColorpaint = new Paint(Paint.DITHER_FLAG);
        mTextPaint = new Paint(Paint.DITHER_FLAG);
        mTextPaint1 = new Paint(Paint.DITHER_FLAG);
        //设置位图的宽高
        mBitmap = Bitmap.createBitmap(1280, 800, Bitmap.Config.RGB_565);
        //绘制内容保存到Bitmap
        mCanvas1 = new Canvas(mBitmap);
        //设置非填充
        mPaint.setStyle(Paint.Style.STROKE);
        mColorpaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint1.setStyle(Paint.Style.FILL);
        //笔宽3像素
        mPaint.setStrokeWidth(3);
        mColorpaint.setStrokeWidth(3);
        mTextPaint.setStrokeWidth(1);
        mTextPaint1.setStrokeWidth(1);
        mTextPaint.setTextSize(18);
        mTextPaint1.setTextSize(18);
        //设置为红笔
        mPaint.setColor(Color.parseColor("#59747F"));
        mColorpaint.setColor(Color.parseColor("#44A41C"));
        mTextPaint.setColor(Color.parseColor("#F9F900"));
        mTextPaint1.setColor(Color.parseColor("#C00000"));
        //#D20707红色
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        mColorpaint.setAntiAlias(true);
        mTextPaint.setAntiAlias(true);
        mTextPaint1.setAntiAlias(true);
        //设置图像抖动处理
        mPaint.setDither(true);
        mColorpaint.setDither(true);
        mTextPaint.setDither(true);
        mTextPaint1.setDither(true);
        //设置图像的结合方式
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mColorpaint.setStrokeJoin(Paint.Join.ROUND);
        mTextPaint.setStrokeJoin(Paint.Join.ROUND);
        mTextPaint1.setStrokeJoin(Paint.Join.ROUND);
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        Log.e("123456", width + "    111    " + height);
        initView(canvas);
    }

    private void initView(Canvas canvas) {
        canvas.drawLine(380, 110, 630, 110, mPaint);
        canvas.drawLine(380, 110, 350, 170, mPaint);
        canvas.drawLine(630, 110, 650, 170, mPaint);
        canvas.drawText("8", 500, 130, mTextPaint);

        canvas.drawLine(250, 170, 680, 170, mPaint);
        canvas.drawLine(250, 170, 150, 410, mPaint);
        canvas.drawLine(680, 170, 720, 290, mPaint);
        canvas.drawText("7", 500, 190, mTextPaint);

        canvas.drawLine(330, 230, 580, 230, mPaint);
        canvas.drawLine(300, 170, 330, 230, mPaint);
        canvas.drawLine(580, 230, 600, 170, mPaint);
        canvas.drawText("6", 500, 250, mTextPaint);

        canvas.drawLine(380, 290, 750, 290, mPaint);
        canvas.drawLine(380, 290, 330, 410, mPaint);
        canvas.drawLine(750, 290, 850, 530, mPaint);
        canvas.drawText("5", 550, 310, mTextPaint);

        canvas.drawLine(450, 350, 680, 350, mPaint);
        canvas.drawLine(420, 290, 450, 350, mPaint);
        canvas.drawLine(680, 350, 700, 290, mPaint);
        canvas.drawText("4", 550, 370, mTextPaint);

        canvas.drawLine(50, 410, 680, 410, mPaint);
        canvas.drawLine(680, 410, 730, 530, mPaint);
        canvas.drawText("3", 500, 430, mTextPaint);
        canvas.drawText("2号作业区域入口", 50, 430, mTextPaint);

        canvas.drawLine(300, 470, 650, 470, mPaint);
        canvas.drawLine(280, 410, 300, 470, mPaint);
        canvas.drawLine(650, 470, 670, 530, mPaint);
        canvas.drawText("2", 500, 490, mTextPaint);

        canvas.drawLine(240, 530, 970, 530, mPaint);
        canvas.drawLine(200, 410, 240, 530, mPaint);
        canvas.drawText("1", 500, 550, mTextPaint);
        canvas.drawText("1号作业区域入口", 850, 520, mTextPaint);

        canvas.drawLine(350, 590, 500, 590, mPaint);
        canvas.drawLine(320, 530, 350, 590, mPaint);
        canvas.drawText("11", 480, 610, mTextPaint);
        canvas.drawLine(580, 590, 720, 590, mPaint);
        canvas.drawLine(550, 530, 580, 590, mPaint);
        canvas.drawText("9", 700, 610, mTextPaint);
        canvas.drawLine(800, 590, 940, 590, mPaint);
        canvas.drawLine(770, 530, 800, 590, mPaint);
        canvas.drawText("10", 920, 610, mTextPaint);
    }
}
