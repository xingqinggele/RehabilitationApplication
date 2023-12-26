package com.example.rehabilitationapplication.net;

import android.util.Log;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述: 根据网络请求类型请求数据封装
 */
public class CommonRequest {
    /**
     * GET 请求
     * //url拼接处理 “?”"&"---------------------
     * 请求头
     *
     * @param url
     * @return
     */
    public static Request createGetRequest(String url, RequestParams params) {
        StringBuffer urlBuilder = new StringBuffer(url).append("?");
        if (params != null)
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                urlBuilder
                        .append(entry.getKey())
                        .append("=")
                        .append(entry.getValue()).append("&");
            }
        return new Request.Builder()
                .url(urlBuilder.substring(0, urlBuilder.length() - 1))
                .get().build();
    }


    /**
     * POST请求
     *
     * @param url
     * @param params
     * @return
     */
    public static Request createPosRequest(String url, RequestParams params) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Map<String, String> map = new HashMap<String, String>();
        //控制层返回的数据遍历到请求的构建中
        for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        JSONObject json =new JSONObject(map);
        Log.e("TAG: ","入参JSON="+json);
        RequestBody body = RequestBody.create(JSON,json+"");
        //通过请求构建类的build方法获取到真正的请求体对象
        return new Request.Builder()
                //请求地址
                .url(url)
                //请求体
                .post(body)
                .build();
    }

    /**
     * 混合form和图片 上传
     *
     * @param url
     * @param params
     * @param files
     * @return
     */
    public static Request createMultipartRequest(String url, RequestParams params, List<File> files) {
        //构建多部件builder
        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                //将请求参数逐一遍历添加到我们的请求构建类中
                bodyBuilder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }
        //添加图片集合放到请求体中
        if (files != null) {
            for (File f : files) {
                bodyBuilder.addFormDataPart("files", f.getName(), RequestBody.create(MediaType.parse("image/png"), f));
            }
        }


        return new Request.Builder()
                .url(url)
                .post(bodyBuilder.build())
                .build();
    }


}