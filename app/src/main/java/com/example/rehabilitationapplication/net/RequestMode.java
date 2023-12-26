package com.example.rehabilitationapplication.net;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:请求模式
 */
public class RequestMode {

    /**
     * GET请求
     * @param url
     * @param params
     * @param callback
     * @param clazz
     */
    public static void getRequest(String url,RequestParams params,ResponseCallback callback,Class<?>clazz){
        CommonOkHttpClient.sendRequest(CommonRequest.createGetRequest(url,params),new ResponseDataHandle(callback,clazz));
    }


    /**
     * POST请求
     * @param url
     * @param params
     * @param callback
     * @param clazz
     */
    public static void posRequest(String url,RequestParams params,ResponseCallback callback,Class<?>clazz){
        CommonOkHttpClient.sendRequest(CommonRequest.createPosRequest(url,params),new ResponseDataHandle(callback,clazz));
    }



} 