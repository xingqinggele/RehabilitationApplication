package com.example.rehabilitationapplication.activity;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseActivity;
import com.example.rehabilitationapplication.persenter.SportsIntroductionPresenter;
import com.example.rehabilitationapplication.view.SportsIntroductionView;

/**
 * 作者: qgl
 * 创建日期：2024/1/2
 * 描述:运动介绍
 */
public class SportsIntroductionActivity extends BaseActivity<SportsIntroductionPresenter,SportsIntroductionView> implements SportsIntroductionView {
    @Override
    protected int getLayoutId() {
        return R.layout.sports_introduction_activity;
    }

    @Override
    protected SportsIntroductionPresenter createPresenter() {
        return new SportsIntroductionPresenter();
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