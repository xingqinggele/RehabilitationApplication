package com.example.rehabilitationapplication.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseActivity;
import com.example.rehabilitationapplication.persenter.KnowDetailPresenter;
import com.example.rehabilitationapplication.view.KnowDetailView;

/**
 * 作者: qgl
 * 创建日期：2023/12/28
 * 描述:知识详情
 */
public class KnowledgeDetailActivity extends BaseActivity<KnowDetailPresenter, KnowDetailView> implements KnowDetailView, View.OnClickListener {
    private LinearLayout iv_back;
    @Override
    protected int getLayoutId() {
        statusBarConfig(R.color.white,true).init();
        return R.layout.knowledge_detail_activity;
    }

    @Override
    protected KnowDetailPresenter createPresenter() {

        return new KnowDetailPresenter();
    }

    @Override
    protected void init() {
        iv_back = findViewById(R.id.iv_back);
    }

    @Override
    protected void initListener() {
        iv_back.setOnClickListener(this);
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
        finish();
    }
}