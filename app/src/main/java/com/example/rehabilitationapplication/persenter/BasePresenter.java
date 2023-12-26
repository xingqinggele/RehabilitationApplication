package com.example.rehabilitationapplication.persenter;


import com.example.rehabilitationapplication.view.IBaseView;

import java.lang.ref.WeakReference;

/**
 * 作者: qgl
 * 创建日期：2022/11/30
 * 描述:P层基类
 */
public class BasePresenter<T extends IBaseView> {

    //弱引用
    public WeakReference<T> iGoodsView;

    /**
     * 弱引用
     * 手动绑定
     */
    public void attachView(T view) {
        iGoodsView = new WeakReference<>(view);
    }

    /**
     * 弱引用
     * 手动解除绑定
     */
    public void deatchView() {
        if (iGoodsView != null) {
            iGoodsView.clear();
            iGoodsView = null;
        }
    }
} 