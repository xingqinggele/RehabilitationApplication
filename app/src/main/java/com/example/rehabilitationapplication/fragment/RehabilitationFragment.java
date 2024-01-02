package com.example.rehabilitationapplication.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.persenter.RehabilitationFragmentPresenter;
import com.example.rehabilitationapplication.view.RehabilitationFragmentView;

/**
 * 作者: qgl
 * 创建日期：2023/12/29
 * 描述:运动
 */
public class RehabilitationFragment extends BaseFragment<RehabilitationFragmentPresenter, RehabilitationFragmentView>implements RehabilitationFragmentView {
    @Override
    protected void init(View view) {

    }

    @Override
    protected RehabilitationFragmentPresenter createPresenter() {
        return new RehabilitationFragmentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rehabilitation_fragment;
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