package com.example.rehabilitationapplication.activity;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseActivity;
import com.example.rehabilitationapplication.persenter.BloodPressurePresenter;
import com.example.rehabilitationapplication.view.BloodPressureView;

/**
 * 作者: qgl
 * 创建日期：2024/1/2
 * 描述:血压
 */
public class BloodPressureActivity extends BaseActivity<BloodPressurePresenter, BloodPressureView>implements BloodPressureView {
    @Override
    protected int getLayoutId() {
        return R.layout.blood_pressure_activity;
    }

    @Override
    protected BloodPressurePresenter createPresenter() {
        return new BloodPressurePresenter();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initListener() {

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
}