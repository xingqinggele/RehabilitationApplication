package com.example.rehabilitationapplication.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseActivity;
import com.example.rehabilitationapplication.persenter.SportsIntroductionPresenter;
import com.example.rehabilitationapplication.util.StatusBarUtil;
import com.example.rehabilitationapplication.view.SportsIntroductionView;

/**
 * 作者: qgl
 * 创建日期：2024/1/2
 * 描述:运动介绍
 */
public class SportsIntroductionActivity extends BaseActivity<SportsIntroductionPresenter,SportsIntroductionView> implements SportsIntroductionView, View.OnClickListener {

    private Button go_sport_btn;

    @Override
    protected int getLayoutId() {
        statusBarConfig(R.color.sport_introduction_title,true).init();
        return R.layout.sports_introduction_activity;
    }

    @Override
    protected SportsIntroductionPresenter createPresenter() {
        return new SportsIntroductionPresenter();
    }

    @Override
    protected void init() {
        go_sport_btn = findViewById(R.id.go_sport_btn);
    }

    @Override
    protected void initListener() {
        go_sport_btn.setOnClickListener(this);
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
            case R.id.go_sport_btn:
                startActivity(new Intent(SportsIntroductionActivity.this,GoSportsActivity.class));
                break;
        }
    }
}