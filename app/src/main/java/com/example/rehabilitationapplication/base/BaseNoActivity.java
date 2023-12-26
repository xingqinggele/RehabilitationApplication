package com.example.rehabilitationapplication.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import com.gyf.barlibrary.ImmersionBar;
import com.lwj.widget.loadingdialog.SimpleLoadingDialog;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:没有MVP的BaseActivity
 */
public abstract class BaseNoActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener {
    //加载框
    public SimpleLoadingDialog loadingDialog;
    //状态栏沉浸
    private ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //初始化加载框
        loadingDialog = new SimpleLoadingDialog(this);
        loadingDialog.setCancelable(false);
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

    protected abstract void init();

    protected abstract void initListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onGlobalLayout() {

    }
}