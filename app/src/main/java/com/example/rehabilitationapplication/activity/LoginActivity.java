package com.example.rehabilitationapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.rehabilitationapplication.MainActivity;
import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseActivity;
import com.example.rehabilitationapplication.base.BaseNoActivity;
import com.example.rehabilitationapplication.bean.LoginBean;
import com.example.rehabilitationapplication.persenter.LoginPresenter;
import com.example.rehabilitationapplication.view.LoginView;

/**
 * 作者: qgl
 * 创建日期：2023/12/26
 * 描述:登录
 */
public class LoginActivity extends BaseActivity<LoginPresenter,LoginView> implements LoginView, View.OnClickListener {

    private Button login_btn;

    @Override
    protected int getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void init() {
        login_btn = findViewById(R.id.login_btn);
    }

    @Override
    protected void initListener() {
        login_btn.setOnClickListener(this);
    }

    @Override
    public void showGoodList(LoginBean bean) {

    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void downProgress() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}