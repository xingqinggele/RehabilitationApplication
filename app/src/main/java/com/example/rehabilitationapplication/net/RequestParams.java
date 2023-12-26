package com.example.rehabilitationapplication.net;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:自定义的map
 */
public class RequestParams {
    //线程安全的HashMap
    public ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Object, Object> fileParams = new ConcurrentHashMap<>();

    /**
     * 无参构造器
     */
    public RequestParams() {
        this((Map<String, String>) null);
    }
    /**
     * 构造器
     * @param source
     */
    public RequestParams(Map<String, String> source) {
        if (source != null) {

            for (Map.Entry<String, String> entry : source.entrySet()) {

                put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * 构造器
     * @param key
     * @param value
     */
    public RequestParams(final String key, final String value) {
        this(new HashMap<String, String>() {
            {
                put(key, value);
            }
        });
    }

    //表单
    public void put(String key, String value) {
        if (key != null && value != null) {
            urlParams.put(key, value);
        }
    }

    //文件
    public void put(String key, Object value) {
        if (key != null && value != null) {
            fileParams.put(key, value);
        }
    }


    public boolean hasParams() {
        if (urlParams.size() > 0 || fileParams.size() > 0) {
            return true;
        }
        return false;
    }


}