package com.example.rehabilitationapplication.net;


import com.example.rehabilitationapplication.app.MyApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:初始化 okHttpClint 对象
 */
public class CommonOkHttpClient {
    /**
     * 超时时间
     */
    private static final int TIME_OUT = 30;
    private static OkHttpClient okHttpClient;
    static {
        //获取缓存路径
        File cacheDir = MyApplication.context.getExternalCacheDir();
        //设置缓存的大小
        int cacheSize = 10 * 1024 * 1024;
        //创建我们Client对象的构建者
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder
                //连接超时时间
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                //读取超时时间
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                //写超时
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                ////websocket轮训间隔(单位:秒)
                .pingInterval(20, TimeUnit.SECONDS)
                //设置缓存
                .cache(new Cache(cacheDir.getAbsoluteFile(), cacheSize))
                //允许重定向
                .followRedirects(true)
                //设置拦截器
                .addInterceptor(new RequestInterceptor());

        okHttpClient = builder.build();
    }


    /**
     *处理请求
     * @param request
     * @param handle
     * @return
     */
    public static Call sendRequest(Request request, ResponseDataHandle handle){
        Call newCall = okHttpClient.newCall(request);
        newCall.enqueue(new CommonJsonCallback(handle));
        return newCall;
    }


} 