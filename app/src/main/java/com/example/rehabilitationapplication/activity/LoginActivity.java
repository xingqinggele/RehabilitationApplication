package com.example.rehabilitationapplication.activity;

import com.example.rehabilitationapplication.base.BaseActivity;
import com.example.rehabilitationapplication.persenter.LoginPresenter;
import com.example.rehabilitationapplication.view.LoginView;

/**
 * 作者: qgl
 * 创建日期：2023/12/26
 * 描述:登录
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginView> {
    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initListener() {

    }
}