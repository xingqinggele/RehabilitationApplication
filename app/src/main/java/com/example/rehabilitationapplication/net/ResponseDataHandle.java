package com.example.rehabilitationapplication.net;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:封装回调接口和要转换的实体对象
 */
public class ResponseDataHandle {

    public ResponseCallback callback = null;

    public Class<?> aClass = null;

    public ResponseDataHandle(ResponseCallback callback) {
        this.callback = callback;
    }

    public ResponseDataHandle(ResponseCallback callback, Class<?> aClass) {
        this.callback = callback;
        this.aClass = aClass;
    }
}