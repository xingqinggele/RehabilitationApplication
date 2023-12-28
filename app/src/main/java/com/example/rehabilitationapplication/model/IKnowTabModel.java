package com.example.rehabilitationapplication.model;

import com.example.rehabilitationapplication.bean.KnowledgeBean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/28
 * 描述:
 */
public interface IKnowTabModel {

    void isKnowTabData(String id,OnKnowTabListener listener);

    interface OnKnowTabListener{
        void showData(List<KnowledgeBean> data);
        void showError(String error);

    }
} 