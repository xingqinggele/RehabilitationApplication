package com.example.rehabilitationapplication.persenter;

import com.example.rehabilitationapplication.bean.KnowledgeBean;
import com.example.rehabilitationapplication.model.IKnowTabModel;
import com.example.rehabilitationapplication.model.IMovementModel;
import com.example.rehabilitationapplication.model.KnowTabModel;
import com.example.rehabilitationapplication.model.MovementModel;
import com.example.rehabilitationapplication.view.HomeView;
import com.example.rehabilitationapplication.view.MovementFragmentView;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:主页P
 */
public class MovementFragmentPresenter<T extends MovementFragmentView> extends BasePresenter{

    IMovementModel model = new MovementModel();

    public void isShowData(){
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && model != null) {
            model.isShowData(new IMovementModel.OnMovementListener() {
                @Override
                public void showData(List<KnowledgeBean> data) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showMovementData(data);
                }

                @Override
                public void showError(String error) {

                }
            });
        }
    }


} 