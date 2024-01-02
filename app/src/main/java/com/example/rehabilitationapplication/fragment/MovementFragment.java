package com.example.rehabilitationapplication.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.adpter.MovementFragmentAdapter;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.bean.KnowledgeBean;
import com.example.rehabilitationapplication.persenter.MovementFragmentPresenter;
import com.example.rehabilitationapplication.view.MovementFragmentView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/29
 * 描述:运动
 */
public class MovementFragment extends BaseFragment<MovementFragmentPresenter,MovementFragmentView>implements MovementFragmentView {
    private RecyclerView recycler_view;
    private MovementFragmentAdapter mAdapter;
    private List<KnowledgeBean> mData = new ArrayList<>();
    @Override
    protected void init(View view) {
        recycler_view = view.findViewById(R.id.recycler_view);
        initView();
        presenter.isShowData();
    }

    @Override
    protected MovementFragmentPresenter createPresenter() {
        return new  MovementFragmentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.movement_fragment;
    }


    private void initView() {
        //adapter配置data
        mAdapter = new MovementFragmentAdapter( R.layout.movement_list_item, mData);
        //打开加载动画
        mAdapter.openLoadAnimation();
        //数据为空显示xml
        mAdapter.setEmptyView(LayoutInflater.from(getActivity()).inflate(R.layout.list_empty, null));
        //RecyclerView设置布局管理器
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        //RecyclerView配置adapter
        recycler_view.setAdapter(mAdapter);
    }


    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void downProgress() {

    }

    @Override
    public void showMovementData(List<KnowledgeBean> bean) {
        mData.clear();
        mData.addAll(bean);
        mAdapter.notifyDataSetChanged();
    }
}