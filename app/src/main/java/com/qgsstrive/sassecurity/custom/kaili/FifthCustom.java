package com.qgsstrive.sassecurity.custom.kaili;

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
 */
public class FifthCustom extends View {

    private Paint mPaint, paint;
    private Bitmap mBitmap;
    private Canvas mCanvas1;
    private Paint mColorpaint;
    private Paint mTextPaint;

    public FifthCustom(Context context) {
        this(context, null);
    }

    public FifthCustom(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public FifthCustom(Context context, AttributeSet attrs, int defStyleAttr) {
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
        Log.e("123456", width + "    111    " + height);
        SpUtil itcast4 = new SpUtil(getContext(), "itcast4");
        String name4 = itcast4.getName();

        //initView(canvas);

        if (name4.equals("true")) {
            canvas.drawLine(50, 450, 680, 450, mColorpaint);
            canvas.drawLine(680, 450, 900, 135, mColorpaint);
            canvas.drawLine(900, 130, 960, 130, mColorpaint);
            //canvas.drawText("货4",150,470,mTextPaint);
            //canvas.drawText("C1",600,470,mTextPaint);
        }else if (name4.equals("false")) {
            canvas.drawLine(50, 450, 680, 450, mPaint);
            canvas.drawLine(680, 450, 900, 135, mPaint);
            canvas.drawLine(900, 130, 960, 130, mPaint);
            //canvas.drawText("货4",150,470,mTextPaint);
            //canvas.drawText("C1",600,470,mTextPaint);
        }
    }

    private void initView(Canvas canvas) {
        //canvas.drawLine(50, 130, 960, 130, mPaint);

        canvas.drawLine(50, 210, 445, 210, mPaint);
        canvas.drawText("货7",150,230,mTextPaint);

        /*canvas.drawLine(50, 290, 400, 290, mPaint);
        canvas.drawLine(400, 290, 450, 210, mPaint);
        canvas.drawLine(450, 210, 650, 210, mPaint);
        canvas.drawLine(650, 210, 700, 135, mPaint);
        canvas.drawText("货6",150,310,mTextPaint);
        canvas.drawText("C2",500,230,mTextPaint);

        canvas.drawLine(50, 370, 400, 370, mPaint);
        canvas.drawLine(400, 370, 450, 445, mPaint);
        canvas.drawText("货5",150,390,mTextPaint);

        canvas.drawLine(50, 450, 680, 450, mPaint);
        canvas.drawLine(680, 450, 900, 135, mPaint);
        canvas.drawText("货4",150,470,mTextPaint);
        canvas.drawText("C1",600,470,mTextPaint);

        canvas.drawLine(50, 530, 500, 530, mPaint);
        canvas.drawLine(500, 530, 550, 455, mPaint);
        canvas.drawText("货1",150,550,mTextPaint);*/
    }
}
