package com.example.rehabilitationapplication.persenter;

import com.example.rehabilitationapplication.bean.KnowledgeBean;
import com.example.rehabilitationapplication.model.IKnowTabModel;
import com.example.rehabilitationapplication.model.KnowTabModel;
import com.example.rehabilitationapplication.view.KnowledgeView;
import com.example.rehabilitationapplication.view.TabView;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:主页P
 */
public class TabPresenter<T extends TabView> extends BasePresenter{

    IKnowTabModel model = new KnowTabModel();

    public void isKnowTabData(String id){
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && model != null) {
            model.isKnowTabData(id, new IKnowTabModel.OnKnowTabListener() {
                @Override
                public void showData(List<KnowledgeBean> data) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showMePartnerData(data);
                }

                @Override
                public void showError(String error) {

                }
            });
        }
    }

} 