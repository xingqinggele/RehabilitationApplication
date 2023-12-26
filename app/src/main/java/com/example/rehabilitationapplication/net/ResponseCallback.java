package com.example.rehabilitationapplication.net;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述: 回调状态接口
 */
public interface ResponseCallback {
    //成功回调、返回对象
    void onSuccess(Object responseObj);
    //失败回调、返回异常
    void onFailure(OkHttpException okHttpException);
} 