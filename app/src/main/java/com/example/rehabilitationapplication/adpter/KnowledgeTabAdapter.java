package com.example.rehabilitationapplication.adpter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.bean.KnowledgeBean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/28
 * 描述:知识adapter
 */
public class KnowledgeTabAdapter extends BaseQuickAdapter<KnowledgeBean, BaseViewHolder> {

    public KnowledgeTabAdapter(int layoutResId, @Nullable List<KnowledgeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, KnowledgeBean item) {
        helper.setText(R.id.title_tv,item.getTitle());
        helper.setText(R.id.data_tv,item.getYear());
    }
}