package com.example.rehabilitationapplication.net;

/**
 * 作者: qgl
 * 描述:请求接口存放类
 */
public class HttpRequest {

    /**
     * 登录接口
     *
     * @param params
     * @param callback
     */
    public static void getLogin(RequestParams params, ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "login", params, callback, null);
    }

    /**
     * 首页数据接口
     *
     * @param params
     * @param callback
     */
    public static void getHomeDate(RequestParams params, ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/homepage/data", params, callback, null);
    }
} 