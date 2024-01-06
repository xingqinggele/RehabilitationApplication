package com.example.rehabilitationapplication.activity;

import android.app.Dialog;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseActivity;
import com.example.rehabilitationapplication.myview.CustomDialog;
import com.example.rehabilitationapplication.persenter.GoSportsPresenter;
import com.example.rehabilitationapplication.view.GoSportsView;

/**
 * 作者: qgl
 * 创建日期：2024/1/3
 * 描述:去运动
 */
public class GoSportsActivity extends BaseActivity<GoSportsPresenter, GoSportsView> implements GoSportsView, View.OnClickListener {
    Button dialog;
    private LinearLayout iv_back;
    @Override
    protected int getLayoutId() {
        statusBarConfig(R.color.white,true).init();
        return R.layout.go_sports_activity;
    }

    @Override
    protected GoSportsPresenter createPresenter() {
        return new GoSportsPresenter();
    }

    @Override
    protected void init() {
//        dialog = findViewById(R.id.dialog);
        iv_back = findViewById(R.id.iv_back);
    }

    @Override
    protected void initListener() {
//        dialog.setOnClickListener(this);
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
        switch (view.getId()){
//            case R.id.dialog:
//                showDialog("是否结束运动?");
//                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }


    /**
     * 弹框
     * @param title
     */
    private void showDialog(String title) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_content, null);
        TextView title_tv = view.findViewById(R.id.title);
        Button confirm = view.findViewById(R.id.confirm);
        Button cancel = view.findViewById(R.id.cancel);
        title_tv.setText(title);
        Dialog dialog = new CustomDialog(this,true,true) {
            @Override
            protected void onCreateView(WindowManager windowManager) {
                DisplayMetrics outMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(outMetrics);
                setDialogWidth((int) (outMetrics.widthPixels * (float) 0.9));
                setDialogHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                setContentView(view);
            }
        };
        dialog.show();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                showToast("点击确定");
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }


}