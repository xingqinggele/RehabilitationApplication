package com.example.rehabilitationapplication.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.persenter.MePresenter;
import com.example.rehabilitationapplication.view.MeView;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:我的页
 */
public class MeFragment extends BaseFragment<MePresenter, MeView> implements MeView {
    @Override
    protected void init(View view) {

    }

    @Override
    protected MePresenter createPresenter() {
        return new MePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.me_fragment;
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