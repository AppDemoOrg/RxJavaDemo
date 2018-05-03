package com.abt.rxjava;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @描述： @RxJavaApplication
 * @作者： @黄卫旗
 * @创建时间： @2018/5/3
 */
public class RxJavaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

}
