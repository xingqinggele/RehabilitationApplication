package com.example.rehabilitationapplication.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;



import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.activity.LoginActivity;
import com.example.rehabilitationapplication.persenter.BasePresenter;
import com.example.rehabilitationapplication.util.SPUtils;
import com.example.rehabilitationapplication.view.IBaseView;
import com.lwj.widget.loadingdialog.SimpleLoadingDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:
 */
public abstract class BaseFragment<T extends BasePresenter,V extends IBaseView>extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
   protected T presenter;
    //加载框
    public SimpleLoadingDialog loadingDialog;

    public static List<Activity> activitys;

    protected Context mContext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        mContext = getActivity();
        //选择自己的表示层
        presenter = createPresenter();
        presenter.attachView((V) this);
        //初始化加载框
        loadingDialog = new SimpleLoadingDialog(getActivity());
        loadingDialog.setCancelable(false);
        if (activitys == null) {
            activitys = new ArrayList<Activity>();
        }
        activitys.add(getActivity());

        //初始化
        init(view);
        return view;
    }

    protected abstract void init(View view);

    protected abstract T createPresenter();

    protected abstract int getLayoutId();


    //Toast
    public void showToast(String text) {
        Toast.makeText(getActivity(), text + "", Toast.LENGTH_SHORT).show();
    }


    /**
     * 退出应用,返回到登录
     * @param context
     * @param sp  是否清空本地缓存
     */
    public void exitApp(Context context,boolean sp ) {
        if (sp){
            SPUtils.clear(mContext);
        }
        // 循环结束当前所有Activity
        for (Activity ac : activitys) {
            if (ac != null) {
                ac.finish();
            }
        }
        startActivity(new Intent(mContext, LoginActivity.class));
    }


    public void SwipeData(SwipeRefreshLayout swipeRefreshLayout){
//        swipeRefreshLayout.setColorSchemeResources(R.color.login_title, R.color.green, R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    public String getUserId(){
        return SPUtils.get(getActivity(), "userId", "").toString();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.deatchView();
    }



}