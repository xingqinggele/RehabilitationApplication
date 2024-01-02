package com.example.rehabilitationapplication.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.rehabilitationapplication.activity.LoginActivity;
import com.example.rehabilitationapplication.persenter.BasePresenter;
import com.example.rehabilitationapplication.util.SPUtils;
import com.example.rehabilitationapplication.view.IBaseView;
import com.gyf.barlibrary.ImmersionBar;
import com.lwj.widget.loadingdialog.SimpleLoadingDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2022/11/30
 * 描述:Activity 基类
 */
public abstract class BaseActivity<T extends BasePresenter, V extends IBaseView> extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener {
    protected T presenter;
    //加载框
    public SimpleLoadingDialog loadingDialog;
    //状态栏沉浸
    private ImmersionBar mImmersionBar;
    protected static Context mContext;
    public static List<Activity> activitys;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mContext = this;
        //选择自己的表示层
        presenter = createPresenter();
        //弱引用、手动绑定
        presenter.attachView((V) this);
        //初始化加载框
        loadingDialog = new SimpleLoadingDialog(this);
        //不可取消
        loadingDialog.setCancelable(false);
        if (activitys == null) {
            activitys = new ArrayList<Activity>();
        }
        activitys.add(this);
        //初始化
        init();
        //触发事件
        initListener();
    }

    /**
     * 初始化沉浸式状态栏
     */
    public ImmersionBar statusBarConfig(int color, boolean value) {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(color)
                .statusBarDarkFont(value)    //默认状态栏字体颜色为黑色
                .keyboardEnable(false, WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
                        | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
        //必须设置View树布局变化监听，否则软键盘无法顶上去，还有模式必须是SOFT_INPUT_ADJUST_PAN
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        return mImmersionBar;
    }

    protected abstract int getLayoutId();

    protected abstract T createPresenter();

    protected abstract void init();

    protected abstract void initListener();

    public String getUserId() {
        return SPUtils.get(this, "userId", "").toString();
    }

    public String getNikeName() {
        return SPUtils.get(this, "nickName", "").toString();
    }

    public String getUserName() {
        return SPUtils.get(this, "userName", "").toString();
    }

    //Toast
    public void showToast(String text) {
        Toast.makeText(this, text + "", Toast.LENGTH_SHORT).show();
    }


    /**
     * 退出应用,返回到登录
     *
     * @param context
     * @param sp      是否清空本地缓存
     */
    public void exitApp(Context context, boolean sp) {
        if (sp) {
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deatchView();
    }

    @Override
    public void onGlobalLayout() {

    }
}