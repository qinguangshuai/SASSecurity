package com.qgsstrive.sassecurity.ui;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.qgsstrive.sassecurity.R;
import com.qgsstrive.sassecurity.SerialPortActivity;
import com.qgsstrive.sassecurity.custom.kaili.FifthCustom;
import com.qgsstrive.sassecurity.custom.kaili.FirstCustom;
import com.qgsstrive.sassecurity.custom.kaili.FourthCustom;
import com.qgsstrive.sassecurity.custom.kaili.SecondCustom;
import com.qgsstrive.sassecurity.custom.kaili.SixthCustom;
import com.qgsstrive.sassecurity.custom.kaili.ThridCustom;
import com.qgsstrive.sassecurity.util.SpUtil;

import util.ByteUtil;
import util.HexUtil;

//凯里SAS系统
public class MainActivity extends Activity implements View.OnClickListener {

    private Context mContext = null;
    private String mEncodeHexStr;
    private SpUtil mItcast, mItcast1, mItcast2, mItcast3, mItcast4, mItcast5;
    private FirstCustom mFirst;
    private SecondCustom mSecond;
    private ThridCustom mThrid;
    private FourthCustom mFourth;
    private FifthCustom mFifth;
    private SixthCustom mSisth;
    private TextView mTitle, mHead;
    private String mDataHeader;
    private String mData;
    private String mState;
    private String mSum;
    private String mDataLength;
    private String mTrackNumber;
    private String mH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        //setSystemUIVisible(false);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        //设置为横屏
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }

    /*@Override
    protected void onDataReceived(final byte[] buffer, final int size, final int type) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (type == 232) {
                        String toString = buffer.toString();
                        char[] chars = HexUtil.encodeHex(buffer);
                        mEncodeHexStr = ByteUtil.bytes2HexString(buffer, size);
                        mData = mEncodeHexStr.replaceAll(" ", "");
                        //mEncodeHexStr = HexUtil.encodeHexStr(buffer, false, size);
                        Log.i("121212", mData + "      121212");
                        //数据头
                        mDataHeader = mData.substring(0, 4);
                        //数据长度
                        mDataLength = mData.substring(4, 6);
                        //H
                        mH = mData.substring(6, 8);
                        //股道号
                        mTrackNumber = mData.substring(8, 10);
                        //状态
                        mState = mData.substring(10, 12);
                        //总和
                        //mSum = mData.substring(12, 14);
                        //int hh = Integer.parseInt(mDistance);

                        //后两位
                        //mSum = mData.substring(0, mData.length() - 2);

                        if (mDataHeader.equals("AA55")) {

                            if (mTrackNumber.equals("01")) {
                                //货1状态显示
                                if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mItcast5.setName("false");
                                    mSisth.setVisibility(View.GONE);
                                    mSisth.invalidate();
                                } else if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mItcast5.setName("true");
                                    mSisth.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSisth.invalidate();
                                }
                            } else if (mTrackNumber.equals("04")) {
                                //货4状态显示
                                if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mItcast4.setName("false");
                                    mFifth.setVisibility(View.GONE);
                                    mFifth.invalidate();
                                } else if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mItcast4.setName("true");
                                    mFifth.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mSisth.setVisibility(View.GONE);
                                    mFifth.invalidate();
                                }
                            } else if (mTrackNumber.equals("05")) {
                                //货5状态显示
                                if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mItcast3.setName("false");
                                    mFourth.setVisibility(View.GONE);
                                    mFourth.invalidate();
                                } else if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mItcast3.setName("true");
                                    mFourth.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSisth.setVisibility(View.GONE);
                                    mFourth.invalidate();
                                }
                            } else if (mTrackNumber.equals("06")) {
                                //货6状态显示
                                if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mItcast2.setName("false");
                                    mThrid.setVisibility(View.GONE);
                                    mThrid.invalidate();
                                } else if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mItcast2.setName("true");
                                    mThrid.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSisth.setVisibility(View.GONE);
                                    mThrid.invalidate();
                                }
                            } else if (mTrackNumber.equals("07")) {
                                //货7状态显示
                                if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mItcast1.setName("false");
                                    mSecond.setVisibility(View.GONE);
                                    mSecond.invalidate();
                                } else if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mItcast1.setName("true");
                                    mSecond.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSisth.setVisibility(View.GONE);
                                    mSecond.invalidate();
                                }
                            } else if (mTrackNumber.equals("08")) {
                                //货8状态显示
                                if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mItcast.setName("false");
                                    mFirst.setVisibility(View.GONE);
                                    mFirst.invalidate();
                                } else if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mItcast.setName("true");
                                    mFirst.setVisibility(View.VISIBLE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSisth.setVisibility(View.GONE);
                                    mFirst.invalidate();
                                }
                            } else if (mTrackNumber.equals("00")) {
                                mItcast.setName("false");
                                mFirst.invalidate();
                                mFirst.setVisibility(View.GONE);
                                mItcast1.setName("false");
                                mSecond.invalidate();
                                mSecond.setVisibility(View.GONE);
                                mItcast2.setName("false");
                                mThrid.invalidate();
                                mThrid.setVisibility(View.GONE);
                                mItcast3.setName("false");
                                mFourth.invalidate();
                                mFourth.setVisibility(View.GONE);
                                mItcast4.setName("false");
                                mFifth.invalidate();
                                mFifth.setVisibility(View.GONE);
                                mItcast5.setName("false");
                                mSisth.invalidate();
                                mSisth.setVisibility(View.GONE);
                            } else if (mTrackNumber.equals("FF")) {
                                mItcast.setName("false");
                                mFirst.invalidate();
                                mFirst.setVisibility(View.GONE);
                                mItcast1.setName("false");
                                mSecond.invalidate();
                                mSecond.setVisibility(View.GONE);
                                mItcast2.setName("false");
                                mThrid.invalidate();
                                mThrid.setVisibility(View.GONE);
                                mItcast3.setName("false");
                                mFourth.invalidate();
                                mFourth.setVisibility(View.GONE);
                                mItcast4.setName("false");
                                mFifth.invalidate();
                                mFifth.setVisibility(View.GONE);
                                mItcast5.setName("false");
                                mSisth.invalidate();
                                mSisth.setVisibility(View.GONE);
                            } else {
                                mItcast.setName("false");
                                mFirst.invalidate();
                                mFirst.setVisibility(View.GONE);
                                mItcast1.setName("false");
                                mSecond.invalidate();
                                mSecond.setVisibility(View.GONE);
                                mItcast2.setName("false");
                                mThrid.invalidate();
                                mThrid.setVisibility(View.GONE);
                                mItcast3.setName("false");
                                mFourth.invalidate();
                                mFourth.setVisibility(View.GONE);
                                mItcast4.setName("false");
                                mFifth.invalidate();
                                mFifth.setVisibility(View.GONE);
                                mItcast5.setName("false");
                                mSisth.invalidate();
                                mSisth.setVisibility(View.GONE);
                            }

                        }
                    }
                } catch (Exception e) {
                    Log.e("Exception", e + "");
                }
            }
        });
    }*/

    private void initView() {
        mFirst = findViewById(R.id.first);
        mSecond = findViewById(R.id.second);
        mThrid = findViewById(R.id.thrid);
        mFourth = findViewById(R.id.fourth);
        mFifth = findViewById(R.id.fifth);
        mSisth = findViewById(R.id.sisth);
        mTitle = findViewById(R.id.title);
        mHead = findViewById(R.id.head);

        mItcast = new SpUtil(getApplicationContext(), "itcast");
        mItcast1 = new SpUtil(getApplicationContext(), "itcast1");
        mItcast2 = new SpUtil(getApplicationContext(), "itcast2");
        mItcast3 = new SpUtil(getApplicationContext(), "itcast3");
        mItcast4 = new SpUtil(getApplicationContext(), "itcast4");
        mItcast5 = new SpUtil(getApplicationContext(), "itcast5");
        /*mItcast.setName("false");
        mItcast1.setName("false");
        mItcast2.setName("false");
        mItcast3.setName("false");
        mItcast4.setName("false");
        mItcast5.setName("false");*/
    }

    private void initData() {
        mTitle.setText("SAS非集中区调车进路安全防护系统");
        mHead.setText("凯里SAS系统");
    }

    /**
     * 隐藏状态栏和导航栏
     *
     * @param show boolean类型，true:显示  false ：隐藏
     */
    private void setSystemUIVisible(boolean show) {
        if (show) {
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            uiFlags |= 0x00001000;
            getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        } else {
            int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            uiFlags |= 0x00001000;
            getWindow().getDecorView().setSystemUiVisibility(uiFlags);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
