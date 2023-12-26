package com.example.rehabilitationapplication.view;


import com.example.rehabilitationapplication.bean.LoginBean;

/**
 * 作者: qgl
 * 创建日期：2022/11/30
 * 描述:登录V层
 */
public interface LoginView extends IBaseView{
    //显示数据
    void showGoodList(LoginBean bean);
}