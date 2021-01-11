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
import com.qgsstrive.sassecurity.custom.handan.OneCustom;
import com.qgsstrive.sassecurity.util.SASContent;
import com.qgsstrive.sassecurity.util.SpUtil;

import util.ByteUtil;
import util.HexUtil;

public class HanDanActivity extends SerialPortActivity {

    private TextView mHead, mTitle;
    private OneCustom mOneCustom;
    private SpUtil mItcast1;
    private String mEncodeHexStr;
    private String mData;
    private String mDataHeader;
    private String mEntrance;
    private String mTrack;
    private String mState;
    private String mSum;

    @Override
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
                        //开通状态
                        mState = mData.substring(12, 14);
                        if (mDataHeader.equals(SASContent.HEAD)) {
                            //入口
                            mEntrance = mData.substring(8, 10);
                            //股道号
                            mTrack = mData.substring(10, 12);
                            //总和
                            mSum = mData.substring(14, 16);
                            //入口
                            if (mState.equals("01")) {
                                if (mTrack.equals("01")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }else if (mTrack.equals("02")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }else if (mTrack.equals("03")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }else if (mTrack.equals("04")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }else if (mTrack.equals("05")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }else if (mTrack.equals("06")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }else if (mTrack.equals("07")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }else if (mTrack.equals("08")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }else if (mTrack.equals("09")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }else if (mTrack.equals("0A")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }else if (mTrack.equals("0B")) {
                                    if (mEntrance.equals("01")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        //入口
                                        mItcast1.setLine(mEntrance);
                                        //股道
                                        mItcast1.setTrack(mTrack);
                                        //状态
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }else if (mEntrance.equals("02")) {
                                        mOneCustom.setVisibility(View.VISIBLE);
                                        mItcast1.setLine(mEntrance);
                                        mItcast1.setTrack(mTrack);
                                        mItcast1.setState(mState);
                                        mOneCustom.invalidate();
                                    }
                                }
                            } else if (mState.equals("00")) {
                                //开通状态，正常色
                                mOneCustom.setVisibility(View.GONE);
                                mOneCustom.invalidate();
                            }

                        }
                    }
                } catch (Exception e) {
                    Log.e("错误异常", e + "");
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_han_dan);
        initView();
        initData();
        initUtil();
    }

    private void initUtil() {
        mItcast1 = new SpUtil(getApplicationContext(), "itcast1");
    }

    private void initView() {
        mHead = findViewById(R.id.head);
        mTitle = findViewById(R.id.title);
        mOneCustom = findViewById(R.id.onecustom);
    }

    private void initData() {
        mTitle.setText("SAS非集中区调车进路安全防护系统");
        mHead.setText("邯郸洗选厂SAS系统");
    }

    @Override
    protected void onResume() {
        //设置为横屏
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }
}