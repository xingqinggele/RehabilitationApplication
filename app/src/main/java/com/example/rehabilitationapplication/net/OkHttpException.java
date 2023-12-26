package com.example.rehabilitationapplication.net;

/**
 * 作者: qgl
 * 描述: 错误码处理
 */
public class OkHttpException extends Exception{
    //错误码
    private int fCode;
    //错误消息
    private String fMsg;
    //构造器
    public OkHttpException(int fCode, String fMsg) {
        this.fCode = fCode;
        this.fMsg = fMsg;
    }

    public int getfCode() {
        return fCode;
    }

    public void setfCode(int fCode) {
        this.fCode = fCode;
    }

    public String getfMsg() {
        return fMsg;
    }

    public void setfMsg(String fMsg) {
        this.fMsg = fMsg;
    }
}