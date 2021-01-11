package com.qgsstrive.sassecurity.custom.handan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.qgsstrive.sassecurity.util.SASContent;
import com.qgsstrive.sassecurity.util.SpUtil;

/**
 * @date 2020/11/22 14:14
 */
public class SevenCustom2 extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private Canvas mCanvas1;
    private Paint mColorpaint;

    public SevenCustom2(Context context) {
        this(context, null);
    }

    public SevenCustom2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SevenCustom2(Context context, AttributeSet attrs, int defStyleAttr) {
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
        //笔宽3像素
        mPaint.setStrokeWidth(3);
        //设置为红笔
        mPaint.setColor(Color.parseColor("#01B030"));
        //#D20707红色
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置图像抖动处理
        mPaint.setDither(true);
        //设置图像的结合方式
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        Log.e("123456", width + "    111    " + height);
        initView(canvas);
    }

    private void initView(Canvas canvas) {
        SpUtil itcast1 = new SpUtil(getContext(), "itcast77");
        String track = itcast1.getTrack();
        String line = itcast1.getLine();
        String state = itcast1.getState();

        if (track.equals(SASContent.entrance7)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(850, 530, 970, 530, mPaint);
                canvas.drawLine(720, 290, 750, 290, mPaint);
                canvas.drawLine(750, 290, 850, 530, mPaint);
                canvas.drawLine(680, 170, 720, 290, mPaint);
                canvas.drawLine(250, 170, 680, 170, mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 150, 410, mPaint);
                canvas.drawLine(250, 170, 680, 170, mPaint);
                canvas.drawLine(250, 170, 150, 410, mPaint);
                canvas.drawLine(680, 170, 720, 290, mPaint);
            }
        }
    }
}
