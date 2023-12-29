package com.example.rehabilitationapplication.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.persenter.MovementFragmentPresenter;
import com.example.rehabilitationapplication.view.MovementFragmentView;

/**
 * 作者: qgl
 * 创建日期：2023/12/29
 * 描述:运动
 */
public class MovementFragment extends BaseFragment<MovementFragmentPresenter,MovementFragmentView>implements MovementFragmentView {
    @Override
    protected void init(View view) {

    }

    @Override
    protected MovementFragmentPresenter createPresenter() {
        return new  MovementFragmentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.movement_fragment;
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