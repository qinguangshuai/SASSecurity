package com.qgsstrive.sassecurity.app;

import android.app.Application;
import android.content.Intent;

import com.qgsstrive.sassecurity.ui.HanDanActivity;
import com.qgsstrive.sassecurity.ui.MainActivity;

/**
 * @date 2020/11/27 22:41
 */
public class MyApp extends Application {

    protected static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        getResources().getIdentifier("activity_main_back","layout",getPackageName());
        Thread.setDefaultUncaughtExceptionHandler(restartHandler); // 程序崩溃时触发线程  以下用来捕获程序崩溃异常
    }

    // 创建服务用于捕获崩溃异常
    private Thread.UncaughtExceptionHandler restartHandler = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable ex) {
            restartApp();//发生崩溃异常时,重启应用
        }
    };
    public void restartApp(){
        Intent intent = new Intent(instance, HanDanActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        instance.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());  //结束进程之前可以把你程序的注销或者退出代码放在这段代码之前
    }
}
