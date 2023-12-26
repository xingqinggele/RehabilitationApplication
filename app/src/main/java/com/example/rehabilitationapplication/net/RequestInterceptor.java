package com.example.rehabilitationapplication.net;

import android.util.Log;


import com.example.rehabilitationapplication.app.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:自定义日志拦截器
 */
public class RequestInterceptor implements Interceptor {

    private String token = "";

    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取本地存储的密钥
        if (!MyApplication.getApp().getToken().equals("") && !MyApplication.getApp().getToken().equals("null") && MyApplication.getApp().getToken() != "" && MyApplication.getApp().getToken() != null) {
            token = MyApplication.getApp().getToken();
        }
        Log.e("TAG", "TOKEN--->" + token);
        Request originalRequest;
        //判断是否是登录接口、登录接口不需要Token
        if (chain.request().url().toString().equals("http://www.poshb.cn:8081/login")) {
            originalRequest = chain
                    .request()
                    .newBuilder()
                    .build();
        } else {
            originalRequest = chain
                    .request()
                    .newBuilder()
                    .header("Authorization", token)
                    .build();
        }

        /**
         * 开始时间
         */
        long startTime = System.currentTimeMillis();
        Log.e("TAG", "\n" + "requestUrl=" + originalRequest.url());
        String method = originalRequest.method();
        if ("POST".equals(method)) {
            try {
                JSONObject jsonObject = new JSONObject();
                if (originalRequest.body() instanceof FormBody) {
                    FormBody body = (FormBody) originalRequest.body();
                    for (int i = 0; i < body.size(); i++) {
                        jsonObject.put(body.encodedName(i), body.encodedValue(i));
                    }
                    Log.e("TAG", "入参JSON= " + jsonObject.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        Response response = chain.proceed(originalRequest);
        /**
         * 这里不能直接使用response.body().string()的方式输出日志
         * 因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一个新的response给应用层处理
         */
        ResponseBody responseBody = response.peekBody(1024 * 1024);
        Log.e("TAG", "出参JSON=" + responseBody.string());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Log.e("TAG", "----------" + "耗时:" + duration + "毫秒----------");
        return response;

    }

}