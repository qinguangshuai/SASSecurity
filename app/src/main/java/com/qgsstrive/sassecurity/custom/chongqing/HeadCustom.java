package com.qgsstrive.sassecurity.custom.chongqing;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.qgsstrive.sassecurity.db.CQUser;
import com.qgsstrive.sassecurity.db.CQAsynTask;
import com.qgsstrive.sassecurity.util.AssetsDatabaseManager;

import java.util.List;

/**
 * @date 2020/10/22 15:33
 */
public class HeadCustom extends View {

    private Paint mPaint, paint;
    private Bitmap mBitmap;
    private Canvas mCanvas1;
    private Paint mColorpaint;
    private Paint mTextPaint,mTextPaint1;

    public HeadCustom(Context context) {
        this(context, null);
    }

    public HeadCustom(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
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
        canvas.drawLine(50, 120, 540, 120, mPaint);
        canvas.drawLine(540, 120, 640, 360, mPaint);
        canvas.drawText("货9", 60, 140, mTextPaint);

        canvas.drawLine(50, 180, 560, 180, mPaint);
        canvas.drawText("货8", 60, 200, mTextPaint);
        canvas.drawText("G6", 520, 170, mTextPaint1);

        canvas.drawLine(50, 240, 585, 240, mPaint);
        canvas.drawText("货7", 60, 260, mTextPaint);
        canvas.drawText("G5", 555, 230, mTextPaint1);

        canvas.drawLine(50, 300, 530, 300, mPaint);
        canvas.drawLine(530, 300, 560,360,mPaint);
        canvas.drawText("货6", 60, 320, mTextPaint);
        canvas.drawText("G7", 370, 320, mTextPaint1);

        canvas.drawLine(50, 360, 360, 360, mPaint);
        canvas.drawLine(360, 360, 410,300,mPaint);
        canvas.drawLine(410, 360, 960,360,mPaint);
        canvas.drawText("货5", 60, 380, mTextPaint);
        canvas.drawText("货4", 440, 380, mTextPaint);
        canvas.drawText("G3", 600, 350, mTextPaint1);
        canvas.drawText("G4", 550, 380, mTextPaint1);

        canvas.drawLine(50, 420, 790, 420, mPaint);
        canvas.drawText("货3", 60, 440, mTextPaint);
        canvas.drawText("G1", 770, 380, mTextPaint1);

        canvas.drawLine(50, 480, 770, 480, mPaint);
        canvas.drawText("货2", 60, 500, mTextPaint);
        canvas.drawText("G8", 750, 440, mTextPaint1);

        canvas.drawLine(50, 540, 750, 540, mPaint);
        canvas.drawLine(750, 540,810,360, mPaint);
        canvas.drawText("货1", 60, 560, mTextPaint);
        canvas.drawText("G9", 730, 500, mTextPaint1);
    }
}
