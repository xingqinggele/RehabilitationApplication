package com.example.rehabilitationapplication.model;

import com.example.rehabilitationapplication.bean.KnowledgeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/28
 * 描述:知识子页model
 */
public class MovementModel implements IMovementModel {
    List<KnowledgeBean>beans = new ArrayList<>();
    @Override
    public void isShowData(OnMovementListener listener) {

        for (int i = 0; i < 5; i++) {
            KnowledgeBean knowledgeBean = new KnowledgeBean();
            knowledgeBean.setId(i+"");
            knowledgeBean.setImg("");
            knowledgeBean.setTitle("标题"+i);
            knowledgeBean.setYear("2023-12-1"+i);
            beans.add(knowledgeBean);
        }
        listener.showData(beans);


    }
}