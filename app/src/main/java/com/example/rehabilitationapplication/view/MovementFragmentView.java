package com.example.rehabilitationapplication.view;

import com.example.rehabilitationapplication.bean.KnowledgeBean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:主页V
 */
public interface MovementFragmentView extends IBaseView{
    void showMovementData(List<KnowledgeBean> bean);

} 