package com.example.rehabilitationapplication.app;

import android.app.Application;
import android.content.Context;

import com.example.rehabilitationapplication.util.SPUtils;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 作者: qgl
 * 描述:
 */
public class MyApplication extends Application {
    public static Context context;
    private static MyApplication allApp;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Fresco.initialize(this);
        allApp = this;
    }

    /**
     * 获得上下文的全局对象
     *
     * @return 全局app
     */
    public static MyApplication getApp() {
        return allApp;
    }

    //获取本地存储的密钥
    public String getToken(){
        return SPUtils.get(context, "Token", "").toString();
    }


}