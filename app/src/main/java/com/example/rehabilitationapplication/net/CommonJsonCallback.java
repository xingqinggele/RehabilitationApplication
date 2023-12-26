package com.example.rehabilitationapplication.net;

import android.os.Handler;
import android.os.Looper;


import com.example.rehabilitationapplication.app.MyApplication;
import com.example.rehabilitationapplication.util.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述: 处理接口返回的数据 、json数据处理
 */
public class CommonJsonCallback implements Callback {

    /**
     * errorCode是根据接口返回的标识 实际根据自己接口返回为准
     */
    protected final String RESULT_CODE = "code";
    protected final int RESULT_CODE_VALUE = 200;

    /**
     * errorMsg字段提示信息，实际根据自己接口返回为准
     */
    protected final String ERROR_MSG = "msg";
    protected final String NETWORK_MSG = "请求失败";
    protected final String JSON_MSG = "解析失败";

    /**
     * 自定义异常类型
     */
    protected final int NETWORK_ERROR = -1; //网络失败
    protected final int JSON_ERROR = -2; //解析失败
    protected final int OTHER_ERROR = -3; //未知错误
    protected final int TIMEOUT_ERROR = -4; //请求超时
    protected final int UGF = 401; //请求超时

    private Handler mDeliveryHandler; //进行消息的转发
    private ResponseCallback mListener;
    private Class<?> mClass;

    public CommonJsonCallback(ResponseDataHandle handle) {
        this.mListener = handle.callback;
        this.mClass = handle.aClass;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * 请求失败
     *
     * @param call
     * @param e
     */
    @Override
    public void onFailure(Call call, IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                if (!Utils.isConnected(MyApplication.context)) {
                    mListener.onFailure(new OkHttpException(NETWORK_ERROR, "请检查网络"));
                } else if (e instanceof SocketTimeoutException) {
                    //判断超时异常
                    mListener.onFailure(new OkHttpException(TIMEOUT_ERROR, "请求超时"));
                } else if (e instanceof ConnectException) {
                    //判断超时异常
                    mListener.onFailure(new OkHttpException(OTHER_ERROR, "请求服务器失败"));
                } else {
                    mListener.onFailure(new OkHttpException(NETWORK_ERROR, e.getMessage()));
                }

            }
        });
    }

    /**
     * 请求成功 回调在主线程
     *
     * @param call
     * @param response
     * @throws IOException
     */
    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result = response.body().string();
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });


    }

    private void handleResponse(Object result) {
        if (null == result && "".equals(result.toString().trim())) {
            mListener.onFailure(new OkHttpException(NETWORK_ERROR, NETWORK_MSG));
            return;
        }

        try {
            JSONObject jsonObject = new JSONObject(result.toString());
            //判断存在某个字段
            if (jsonObject.has(RESULT_CODE)) {
                //判断code  == 200
                if (jsonObject.getInt(RESULT_CODE) == RESULT_CODE_VALUE) {

                    if (mClass == null) {
                        mListener.onSuccess(jsonObject);
                    } else {
                        //解析json-------------------------------------
                        Gson gson = new GsonBuilder().serializeNulls().create();
                        Object json = new JSONTokener(jsonObject.getString("data")).nextValue();
                        Object obj;
                        //判断是否是一个类的实例
                        if (json instanceof JSONObject) {
                            obj = gson.fromJson(String.valueOf(jsonObject.getJSONObject("data")), mClass);
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            mListener.onSuccess(obj);
                        } else {
                            mListener.onFailure(new OkHttpException(JSON_ERROR, NETWORK_MSG));
                        }

                    }


                } else {
                    //将服务端返回的异常回调到应用层去处理
                    mListener.onFailure(new OkHttpException(jsonObject.getInt(RESULT_CODE), jsonObject.get(ERROR_MSG) + ""));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            mListener.onFailure(new OkHttpException(OTHER_ERROR, e.getMessage()));
        }

    }
}