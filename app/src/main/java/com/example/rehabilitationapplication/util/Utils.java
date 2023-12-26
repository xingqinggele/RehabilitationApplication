package com.example.rehabilitationapplication.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:工具类
 */
public class Utils {
    //退出软件，开始时间
    private static long mPressedTime = 0;

    /**
     * 判断是否网络链接
     *
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        if (null != connectivityManager) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            if (null != activeNetwork && activeNetwork.isConnected()) {
                if (activeNetwork.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 推出软件
     * @param context
     */
    public static void onFinish(Activity context,String appName){
        long mNowTime = System.currentTimeMillis();
        //获取第一次按键时间
        if ((mNowTime - mPressedTime) > 2000) {
            //比较两次按键时间差
            Toast.makeText(context, "再按一次退出" + appName, Toast.LENGTH_SHORT).show();
            mPressedTime = mNowTime;
        } else {
            //退出程序
            context.finish();
        }
    }


    /**
     * 隐藏软键盘
     * @param view    :一般为EditText
     */
    public static void hideKeyboard(View view) {
        InputMethodManager manager = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
} 