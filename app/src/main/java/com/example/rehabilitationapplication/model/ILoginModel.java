package com.example.rehabilitationapplication.model;


import com.example.rehabilitationapplication.bean.LoginBean;

/**
 * 作者: qgl
 * 创建日期：2022/11/30
 * 描述:登录父类model
 */
public interface ILoginModel {

    void login(String userName, String passWord, OnLoadListener onLoadListener);

    interface OnLoadListener {
        void showData(LoginBean bean);

        void showError(String msg);
    }
} 