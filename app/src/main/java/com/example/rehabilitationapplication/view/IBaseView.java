package com.example.rehabilitationapplication.view;

/**
 * 作者: qgl
 * 创建日期：2022/11/30
 * 描述:V层基类
 */
public interface IBaseView {
    //显示错误消息
    void showErrorMessage(String msg);
    //显示加载框
    void showProgress();
    //隐藏加载框
    void downProgress();
} 