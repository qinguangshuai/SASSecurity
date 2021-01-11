package com.qgsstrive.sassecurity.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.qgsstrive.sassecurity.R;
import com.qgsstrive.sassecurity.SerialPortActivity;
import com.qgsstrive.sassecurity.custom.chongqing.EighthCustom;
import com.qgsstrive.sassecurity.custom.chongqing.FifthCustom;
import com.qgsstrive.sassecurity.custom.chongqing.FirstCustom;
import com.qgsstrive.sassecurity.custom.chongqing.FourthCustom;
import com.qgsstrive.sassecurity.custom.chongqing.HeadCustom;
import com.qgsstrive.sassecurity.custom.chongqing.NinthCustom;
import com.qgsstrive.sassecurity.custom.chongqing.SecondCustom;
import com.qgsstrive.sassecurity.custom.chongqing.SeventhCustom;
import com.qgsstrive.sassecurity.custom.chongqing.SixthCustom;
import com.qgsstrive.sassecurity.custom.chongqing.ThridCustom;
import com.qgsstrive.sassecurity.util.SpUtil;

import util.ByteUtil;
import util.HexUtil;

public class CQNSASActivity extends Activity {

    private TextView mHead,mTitle;
    private SpUtil mCqncast1,mCqncast2,mCqncast3,mCqncast4,mCqncast5,mCqncast6,mCqncast7,mCqncast8,mCqncast9;
    private FirstCustom mFirst;
    private String mEncodeHexStr;
    private String mDataHeader;
    private String mData;
    private String mState;
    private String mSum;
    private String mDataLength;
    private String mTrackNumber;
    private String mH;
    private SecondCustom mSecond;
    private ThridCustom mThrid;
    private FourthCustom mFourth;
    private FifthCustom mFifth;
    private SixthCustom mSixth;
    private SeventhCustom mSeventh;
    private EighthCustom mEighth;
    private NinthCustom mNinth;
    private HeadCustom mHeadcustom;

    /*@Override
    protected void onDataReceived(final byte[] buffer, final int size, final int type) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (type==232) {
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
                        if (mDataHeader.equals("AA55")) {
                            if (mTrackNumber.equals("09")) {
                                if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mFirst.setVisibility(View.VISIBLE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSixth.setVisibility(View.GONE);
                                    mSeventh.setVisibility(View.GONE);
                                    mEighth.setVisibility(View.GONE);
                                    mNinth.setVisibility(View.GONE);
                                    mCqncast1.setName("true");
                                    mFirst.invalidate();
                                }else if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mFirst.setVisibility(View.GONE);
                                    mCqncast1.setName("false");
                                    mFirst.invalidate();
                                }
                            }
                            if (mTrackNumber.equals("08")) {
                                if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mSecond.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSixth.setVisibility(View.GONE);
                                    mSeventh.setVisibility(View.GONE);
                                    mEighth.setVisibility(View.GONE);
                                    mNinth.setVisibility(View.GONE);
                                    mCqncast2.setName("true");
                                    mSecond.invalidate();
                                }else if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mSecond.setVisibility(View.GONE);
                                    mCqncast2.setName("false");
                                    mSecond.invalidate();
                                }
                            }
                            if (mTrackNumber.equals("07")) {
                                if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mThrid.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSixth.setVisibility(View.GONE);
                                    mSeventh.setVisibility(View.GONE);
                                    mEighth.setVisibility(View.GONE);
                                    mNinth.setVisibility(View.GONE);
                                    mCqncast3.setName("true");
                                    mThrid.invalidate();
                                }else if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mThrid.setVisibility(View.GONE);
                                    mCqncast3.setName("false");
                                    mThrid.invalidate();
                                }
                            }
                            if (mTrackNumber.equals("06")) {
                                if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mFourth.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSixth.setVisibility(View.GONE);
                                    mSeventh.setVisibility(View.GONE);
                                    mEighth.setVisibility(View.GONE);
                                    mNinth.setVisibility(View.GONE);
                                    mCqncast4.setName("true");
                                    mFourth.invalidate();
                                }else if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mFourth.setVisibility(View.GONE);
                                    mCqncast4.setName("false");
                                    mFourth.invalidate();
                                }
                            }
                            if (mTrackNumber.equals("05")) {
                                if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mFifth.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mSixth.setVisibility(View.GONE);
                                    mSeventh.setVisibility(View.GONE);
                                    mEighth.setVisibility(View.GONE);
                                    mNinth.setVisibility(View.GONE);
                                    mCqncast5.setName("true");
                                    mFifth.invalidate();
                                }else if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mFifth.setVisibility(View.GONE);
                                    mCqncast5.setName("false");
                                    mFifth.invalidate();
                                }
                            }
                            if (mTrackNumber.equals("04")) {
                                if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mSixth.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSeventh.setVisibility(View.GONE);
                                    mEighth.setVisibility(View.GONE);
                                    mNinth.setVisibility(View.GONE);
                                    mCqncast6.setName("true");
                                    mSixth.invalidate();
                                }else if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mSixth.setVisibility(View.GONE);
                                    mCqncast6.setName("false");
                                    mSixth.invalidate();
                                }
                            }
                            if (mTrackNumber.equals("03")) {
                                if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mSeventh.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSixth.setVisibility(View.GONE);
                                    mEighth.setVisibility(View.GONE);
                                    mNinth.setVisibility(View.GONE);
                                    mCqncast7.setName("true");
                                    mSeventh.invalidate();
                                }else if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mSeventh.setVisibility(View.GONE);
                                    mCqncast7.setName("false");
                                    mSeventh.invalidate();
                                }
                            }
                            if (mTrackNumber.equals("02")) {
                                if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mEighth.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSixth.setVisibility(View.GONE);
                                    mSeventh.setVisibility(View.GONE);
                                    mNinth.setVisibility(View.GONE);
                                    mCqncast8.setName("true");
                                    mEighth.invalidate();
                                }else if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mEighth.setVisibility(View.GONE);
                                    mCqncast8.setName("false");
                                    mEighth.invalidate();
                                }
                            }
                            if (mTrackNumber.equals("01")) {
                                if (mState.equals("01")) {
                                    //开通状态，绿色
                                    mNinth.setVisibility(View.VISIBLE);
                                    mFirst.setVisibility(View.GONE);
                                    mSecond.setVisibility(View.GONE);
                                    mThrid.setVisibility(View.GONE);
                                    mFourth.setVisibility(View.GONE);
                                    mFifth.setVisibility(View.GONE);
                                    mSixth.setVisibility(View.GONE);
                                    mSeventh.setVisibility(View.GONE);
                                    mEighth.setVisibility(View.GONE);
                                    mCqncast9.setName("true");
                                    mNinth.invalidate();
                                }else if (mState.equals("00")) {
                                    //未开通状态，正常色
                                    mNinth.setVisibility(View.GONE);
                                    mCqncast9.setName("false");
                                    mNinth.invalidate();
                                }
                            }else if (mTrackNumber.equals("FF")) {
                                mCqncast1.setName("false");
                                mFirst.setVisibility(View.GONE);
                                mFirst.invalidate();
                                mCqncast2.setName("false");
                                mSecond.setVisibility(View.GONE);
                                mSecond.invalidate();
                                mCqncast3.setName("false");
                                mThrid.setVisibility(View.GONE);
                                mThrid.invalidate();
                                mCqncast4.setName("false");
                                mFourth.setVisibility(View.GONE);
                                mFourth.invalidate();
                                mCqncast5.setName("false");
                                mFifth.setVisibility(View.GONE);
                                mFifth.invalidate();
                                mCqncast6.setName("false");
                                mSixth.setVisibility(View.GONE);
                                mSixth.invalidate();
                                mCqncast7.setName("false");
                                mSeventh.setVisibility(View.GONE);
                                mSeventh.invalidate();
                                mCqncast8.setName("false");
                                mEighth.setVisibility(View.GONE);
                                mEighth.invalidate();
                                mCqncast9.setName("false");
                                mNinth.setVisibility(View.GONE);
                                mNinth.invalidate();
                            }
                            if (mState.equals("00")) {
                                mCqncast1.setName("false");
                                mFirst.setVisibility(View.GONE);
                                mFirst.invalidate();
                                mCqncast2.setName("false");
                                mSecond.setVisibility(View.GONE);
                                mSecond.invalidate();
                                mCqncast3.setName("false");
                                mThrid.setVisibility(View.GONE);
                                mThrid.invalidate();
                                mCqncast4.setName("false");
                                mFourth.setVisibility(View.GONE);
                                mFourth.invalidate();
                                mCqncast5.setName("false");
                                mFifth.setVisibility(View.GONE);
                                mFifth.invalidate();
                                mCqncast6.setName("false");
                                mSixth.setVisibility(View.GONE);
                                mSixth.invalidate();
                                mCqncast7.setName("false");
                                mSeventh.setVisibility(View.GONE);
                                mSeventh.invalidate();
                                mCqncast8.setName("false");
                                mEighth.setVisibility(View.GONE);
                                mEighth.invalidate();
                                mCqncast9.setName("false");
                                mNinth.setVisibility(View.GONE);
                                mNinth.invalidate();
                            }

                        }
                    }else {
                        Log.e("串口不对", "串口不对");
                    }
                } catch (Exception e) {
                    Log.e("Exception", e + "");
                }
            }
        });
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cqnsas);
        initView();
        initData();
    }

    private void initView() {
        //初始化控件
        mHead = findViewById(R.id.head);
        mTitle = findViewById(R.id.title);
        mHeadcustom = findViewById(R.id.headcustom);
        mFirst = findViewById(R.id.first);
        mSecond = findViewById(R.id.second);
        mThrid = findViewById(R.id.thrid);
        mFourth = findViewById(R.id.fourth);
        mFifth = findViewById(R.id.fifth);
        mSixth = findViewById(R.id.sixth);
        mSeventh = findViewById(R.id.seventh);
        mEighth = findViewById(R.id.eighth);
        mNinth = findViewById(R.id.ninth);
    }

    private void initData() {
        mHead.setText("重庆南SAS系统");
        mTitle.setText("SAS非集中区调车进路安全防护系统");

        spData();
    }

    private void spData() {
        mCqncast1 = new SpUtil(getApplicationContext(), "cqncast1");
        mCqncast2 = new SpUtil(getApplicationContext(), "cqncast2");
        mCqncast3 = new SpUtil(getApplicationContext(), "cqncast3");
        mCqncast4 = new SpUtil(getApplicationContext(), "cqncast4");
        mCqncast5 = new SpUtil(getApplicationContext(), "cqncast5");
        mCqncast6 = new SpUtil(getApplicationContext(), "cqncast6");
        mCqncast7 = new SpUtil(getApplicationContext(), "cqncast7");
        mCqncast8 = new SpUtil(getApplicationContext(), "cqncast8");
        mCqncast9 = new SpUtil(getApplicationContext(), "cqncast9");
        mCqncast1.setName("false");
        mCqncast2.setName("false");
        mCqncast3.setName("false");
        mCqncast4.setName("false");
        mCqncast5.setName("false");
        mCqncast6.setName("false");
        mCqncast7.setName("false");
        mCqncast8.setName("false");
        mCqncast9.setName("false");
    }

    @Override
    protected void onResume() {
        //设置为横屏
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
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
}
