package com.example.rehabilitationapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rehabilitationapplication.MainActivity;
import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseActivity;
import com.example.rehabilitationapplication.base.BaseNoActivity;
import com.example.rehabilitationapplication.bean.LoginBean;
import com.example.rehabilitationapplication.persenter.LoginPresenter;
import com.example.rehabilitationapplication.util.StatusBarUtil;
import com.example.rehabilitationapplication.view.LoginView;

/**
 * 作者: qgl
 * 创建日期：2023/12/26
 * 描述:登录
 */
public class LoginActivity extends BaseActivity<LoginPresenter, LoginView> implements LoginView, View.OnClickListener {
    private Button login_btn;
    private EditText user_name_ed;
    private EditText user_id_number_ed;
    private EditText user_phone_ed;

    @Override
    protected int getLayoutId() {
        StatusBarUtil.transparencyBar(LoginActivity.this);
        return R.layout.login_activity;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void init() {
        login_btn = findViewById(R.id.login_btn);
        user_name_ed = findViewById(R.id.user_name_ed);
        user_id_number_ed = findViewById(R.id.user_id_number_ed);
        user_phone_ed = findViewById(R.id.user_phone_ed);
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
        switch (view.getId()) {
            case R.id.login_btn:
                if (TextUtils.isEmpty(user_name_ed.getText().toString().trim())) {
                    Toast.makeText(LoginActivity.this, "请输入姓名", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(user_id_number_ed.getText().toString().trim())) {
                    Toast.makeText(LoginActivity.this, "请输入身份证号码", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(user_phone_ed.getText().toString().trim())) {
                    Toast.makeText(LoginActivity.this, "请输入手机号码", Toast.LENGTH_LONG).show();
                    return;
                }
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}