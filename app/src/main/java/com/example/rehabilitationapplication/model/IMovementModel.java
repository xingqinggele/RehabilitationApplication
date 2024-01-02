package com.example.rehabilitationapplication.model;

import com.example.rehabilitationapplication.bean.KnowledgeBean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/28
 * 描述:
 */
public interface IMovementModel {

    void isShowData(OnMovementListener listener);

    interface OnMovementListener{
        void showData(List<KnowledgeBean> data);
        void showError(String error);

    }
} 