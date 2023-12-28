package com.example.rehabilitationapplication.fragment;

import android.view.View;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.persenter.HealthPresenter;
import com.example.rehabilitationapplication.view.HealthView;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:健康页
 */
public class HealthFragment extends BaseFragment<HealthPresenter, HealthView>implements HealthView {
    @Override
    protected void init(View view) {

    }

    @Override
    protected HealthPresenter createPresenter() {
        return new HealthPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.health_fragment;
    }

    @Override
    public void onRefresh() {

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