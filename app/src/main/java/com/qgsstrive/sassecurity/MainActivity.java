package com.qgsstrive.sassecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.qgsstrive.sassecurity.custom.FirstCustom;
import com.qgsstrive.sassecurity.util.SpUtil;

import util.ByteUtil;
import util.HexUtil;

public class MainActivity extends SerialPortActivity implements View.OnClickListener {

    private Context mContext = null;
    private String mEncodeHexStr;
    private String aa = "A700000000";
    private SpUtil mItcast;
    private FirstCustom mFirst;
    private TextView mTitle, mHead;
    private Button mUnlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        //setSystemUIVisible(false);
        initView();
        initData();
    }

    /*@Override
    protected void onResume() {
        *//**
         * 设置为横屏
         *//*
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }*/

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
                        Log.e("121212", mEncodeHexStr + "      121212");
                        if (mEncodeHexStr.equals(aa)) {
                            mItcast = new SpUtil(getApplicationContext(), "itcast");
                            mItcast.setName("true");
                            mFirst.invalidate();
                        }
                    }
                } catch (Exception e) {
                    Log.e("Exception", e + "");
                }
            }
        });
    }

    private void initView() {
        mFirst = findViewById(R.id.first);
        mTitle = findViewById(R.id.title);
        mHead = findViewById(R.id.head);
        mUnlock = findViewById(R.id.unlock);
        mUnlock.setOnClickListener(this);
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
            case R.id.unlock:
                Toast.makeText(mContext, "故障解锁", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
