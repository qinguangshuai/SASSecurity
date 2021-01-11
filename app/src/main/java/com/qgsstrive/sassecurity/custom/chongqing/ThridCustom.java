package com.qgsstrive.sassecurity.custom.chongqing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.qgsstrive.sassecurity.util.SpUtil;

/**
 * @date 2020/10/22 15:33
 * 货7
 */
public class ThridCustom extends View {

    private Paint mPaint, paint;
    private Bitmap mBitmap;
    private Canvas mCanvas1;
    private Paint mColorpaint;
    private Paint mTextPaint;

    public ThridCustom(Context context) {
        this(context, null);
    }

    public ThridCustom(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ThridCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建一个画笔
        mPaint = new Paint(Paint.DITHER_FLAG);
        mColorpaint = new Paint(Paint.DITHER_FLAG);
        mTextPaint = new Paint(Paint.DITHER_FLAG);
        //设置位图的宽高
        mBitmap = Bitmap.createBitmap(1280, 800, Bitmap.Config.RGB_565);
        //绘制内容保存到Bitmap
        mCanvas1 = new Canvas(mBitmap);
        //设置非填充
        mPaint.setStyle(Paint.Style.STROKE);
        mColorpaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setStyle(Paint.Style.FILL);
        //笔宽3像素
        mPaint.setStrokeWidth(3);
        mColorpaint.setStrokeWidth(3);
        mTextPaint.setStrokeWidth(1);
        mTextPaint.setTextSize(18);
        //设置为红笔
        mPaint.setColor(Color.parseColor("#59747F"));
        mColorpaint.setColor(Color.parseColor("#44A41C"));
        mTextPaint.setColor(Color.parseColor("#FFFFFF"));
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        mColorpaint.setAntiAlias(true);
        mTextPaint.setAntiAlias(true);
        //设置图像抖动处理
        mPaint.setDither(true);
        mColorpaint.setDither(true);
        mTextPaint.setDither(true);
        //设置图像的结合方式
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mColorpaint.setStrokeJoin(Paint.Join.ROUND);
        mTextPaint.setStrokeJoin(Paint.Join.ROUND);
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        SpUtil cqncast3 = new SpUtil(getContext(), "cqncast3");
        String name3 = cqncast3.getName();

        if (name3.equals("true")) {
            canvas.drawLine(50, 240, 585, 240, mColorpaint);
            canvas.drawLine(590, 240, 640, 360, mColorpaint);
            canvas.drawLine(640, 360, 960, 360, mColorpaint);
        }else if (name3.equals("false")) {
            canvas.drawLine(50, 240, 585, 240, mPaint);
            canvas.drawLine(590, 240, 640, 360, mPaint);
            canvas.drawLine(640, 360, 960, 360, mPaint);
        }
    }
}
