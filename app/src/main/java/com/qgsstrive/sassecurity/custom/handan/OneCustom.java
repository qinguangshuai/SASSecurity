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
public class OneCustom extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private Canvas mCanvas1;
    private Paint mColorpaint;

    public OneCustom(Context context) {
        this(context, null);
    }

    public OneCustom(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OneCustom(Context context, AttributeSet attrs, int defStyleAttr) {
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
        SpUtil itcast1 = new SpUtil(getContext(), "itcast1");
        String track = itcast1.getTrack();
        String line = itcast1.getLine();
        String state = itcast1.getState();
        if (track.equals(SASContent.entrance1)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(240, 530, 970, 530, mPaint);
                canvas.drawLine(200, 410, 240, 530, mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 200, 410, mPaint);
                canvas.drawLine(240, 530, 800, 530, mPaint);
                canvas.drawLine(200, 410, 240, 530, mPaint);
            }
        }

        if (track.equals(SASContent.entrance2)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(670, 530, 970, 530, mPaint);
                canvas.drawLine(300, 470, 650, 470, mPaint);
                canvas.drawLine(280, 410, 300, 470, mPaint);
                canvas.drawLine( 650, 470, 670,530,mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 280, 410, mPaint);
                canvas.drawLine(300, 470, 650, 470, mPaint);
                canvas.drawLine(280, 410, 300, 470, mPaint);
                canvas.drawLine( 650, 470, 670,530,mPaint);
            }
        }

        if (track.equals(SASContent.entrance3)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(730, 530, 970, 530, mPaint);
                canvas.drawLine(300, 410, 680, 410, mPaint);
                canvas.drawLine(680, 410, 730, 530, mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 680, 410, mPaint);
                canvas.drawLine(680, 410, 730, 530, mPaint);
            }
        }

        if (track.equals(SASContent.entrance4)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(850, 530, 970, 530, mPaint);
                canvas.drawLine(750, 290, 850, 530, mPaint);
                canvas.drawLine(700, 290, 750, 290, mPaint);
                canvas.drawLine(450, 350, 680, 350, mPaint);
                canvas.drawLine(420, 290, 450, 350, mPaint);
                canvas.drawLine(680, 350, 700, 290, mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 330, 410, mPaint);
                canvas.drawLine(380, 290, 330, 410, mPaint);
                canvas.drawLine(380, 290, 420, 290, mPaint);
                canvas.drawLine(450, 350, 680, 350, mPaint);
                canvas.drawLine(420, 290, 450, 350, mPaint);
                canvas.drawLine(680, 350, 700, 290, mPaint);
            }
        }

        if (track.equals(SASContent.entrance5)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(850, 530, 970, 530, mPaint);
                canvas.drawLine(380, 290, 750, 290, mPaint);
                canvas.drawLine(380, 290, 330, 410, mPaint);
                canvas.drawLine(750, 290, 850, 530, mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 330, 410, mPaint);
                canvas.drawLine(380, 290, 750, 290, mPaint);
                canvas.drawLine(380, 290, 330, 410, mPaint);
                canvas.drawLine(750, 290, 850, 530, mPaint);
            }
        }

        if (track.equals(SASContent.entrance6)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(850, 530, 970, 530, mPaint);
                canvas.drawLine(720, 290, 750, 290, mPaint);
                canvas.drawLine(750, 290, 850, 530, mPaint);
                canvas.drawLine(680, 170, 720, 290, mPaint);
                canvas.drawLine(600, 170, 680, 170, mPaint);
                canvas.drawLine(330, 230, 580, 230, mPaint);
                canvas.drawLine(300, 170, 330, 230, mPaint);
                canvas.drawLine(580, 230, 600, 170, mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 150, 410, mPaint);
                canvas.drawLine(250, 170, 300, 170, mPaint);
                canvas.drawLine(250, 170, 150, 410, mPaint);
                canvas.drawLine(330, 230, 580, 230, mPaint);
                canvas.drawLine(300, 170, 330, 230, mPaint);
                canvas.drawLine(580, 230, 600, 170, mPaint);
            }
        }

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

        if (track.equals(SASContent.entrance8)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(850, 530, 970, 530, mPaint);
                canvas.drawLine(720, 290, 750, 290, mPaint);
                canvas.drawLine(750, 290, 850, 530, mPaint);
                canvas.drawLine(680, 170, 720, 290, mPaint);
                canvas.drawLine(650, 170, 680, 170, mPaint);
                canvas.drawLine(380, 110, 630, 110, mPaint);
                canvas.drawLine(380, 110, 350, 170, mPaint);
                canvas.drawLine(630, 110, 650, 170, mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 150, 410, mPaint);
                canvas.drawLine(250, 170, 350, 170, mPaint);
                canvas.drawLine(250, 170, 150, 410, mPaint);
                canvas.drawLine(380, 110, 630, 110, mPaint);
                canvas.drawLine(380, 110, 350, 170, mPaint);
                canvas.drawLine(630, 110, 650, 170, mPaint);
            }
        }

        if (track.equals(SASContent.entrance9)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(550, 530, 970, 530, mPaint);
                canvas.drawLine(580, 590, 720, 590, mPaint);
                canvas.drawLine(550, 530, 580, 590, mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 200, 410, mPaint);
                canvas.drawLine(240, 530, 550, 530, mPaint);
                canvas.drawLine(200, 410, 240, 530, mPaint);
                canvas.drawLine(580, 590, 720, 590, mPaint);
                canvas.drawLine(550, 530, 580, 590, mPaint);
            }
        }

        if (track.equals(SASContent.entrance10)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(770, 530, 970, 530, mPaint);
                canvas.drawLine(800, 590, 940, 590, mPaint);
                canvas.drawLine(770, 530, 800, 590, mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 200, 410, mPaint);
                canvas.drawLine(240, 530, 770, 530, mPaint);
                canvas.drawLine(200, 410, 240, 530, mPaint);
                canvas.drawLine(800, 590, 940, 590, mPaint);
                canvas.drawLine(770, 530, 800, 590, mPaint);
            }
        }

        if (track.equals(SASContent.entrance11)) {
            if (line.equals(SASContent.line1)) {
                canvas.drawLine(320, 530, 970, 530, mPaint);
                canvas.drawLine(350, 590, 500, 590, mPaint);
                canvas.drawLine(320, 530, 350, 590, mPaint);
            }
            if (line.equals(SASContent.line2)) {
                canvas.drawLine(50, 410, 200, 410, mPaint);
                canvas.drawLine(240, 530, 320, 530, mPaint);
                canvas.drawLine(200, 410, 240, 530, mPaint);
                canvas.drawLine(350, 590, 500, 590, mPaint);
                canvas.drawLine(320, 530, 350, 590, mPaint);
            }
        }
    }
}
