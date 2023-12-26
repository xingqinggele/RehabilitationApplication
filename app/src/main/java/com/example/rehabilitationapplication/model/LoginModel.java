package com.example.rehabilitationapplication.model;


import com.example.rehabilitationapplication.bean.LoginBean;
import com.example.rehabilitationapplication.net.HttpRequest;
import com.example.rehabilitationapplication.net.OkHttpException;
import com.example.rehabilitationapplication.net.RequestParams;
import com.example.rehabilitationapplication.net.ResponseCallback;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 作者: qgl
 * 创建日期：2022/11/30
 * 描述:登录model
 */
public class LoginModel implements ILoginModel {
    @Override
    public void login(String userName, String passWord, OnLoadListener onLoadListener) {
        RequestParams params = new RequestParams();
        params.put("username",userName);
        params.put("password",passWord);
        HttpRequest.getLogin(params, new ResponseCallback() {
            @Override
            public void onSuccess(Object responseObj) {
                Gson gson = new GsonBuilder().serializeNulls().create();
                try {
                    JSONObject object = new JSONObject(responseObj.toString());
                    LoginBean data = gson.fromJson(object.toString(), LoginBean.class);
                    onLoadListener.showData(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(OkHttpException okHttpException) {
                onLoadListener.showError(okHttpException.getfMsg());
            }
        });
    }
}