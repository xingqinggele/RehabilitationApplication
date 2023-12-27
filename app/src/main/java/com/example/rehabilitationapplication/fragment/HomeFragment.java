package com.example.rehabilitationapplication.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.persenter.HomePresenter;
import com.example.rehabilitationapplication.util.StatusBarUtil;
import com.example.rehabilitationapplication.view.HomeView;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:主页
 */
public class HomeFragment extends BaseFragment<HomePresenter,HomeView>implements HomeView {


    @Override
    protected void init(View view) {

    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutId() {
        //导航栏设置
        StatusBarUtil.transparencyBar(getActivity());
        return R.layout.home_fragment;
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