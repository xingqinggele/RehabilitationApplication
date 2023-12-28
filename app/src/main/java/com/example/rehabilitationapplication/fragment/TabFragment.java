package com.example.rehabilitationapplication.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.activity.KnowledgeDetailActivity;
import com.example.rehabilitationapplication.adpter.KnowledgeTabAdapter;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.bean.KnowledgeBean;
import com.example.rehabilitationapplication.persenter.TabPresenter;
import com.example.rehabilitationapplication.view.TabView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述: 知识子页
 */
public class TabFragment extends BaseFragment<TabPresenter, TabView> implements TabView, BaseQuickAdapter.OnItemClickListener {
    private SwipeRefreshLayout swipe_layout;
    private RecyclerView recycle_view;
    private KnowledgeTabAdapter mAdapter;
    private List<KnowledgeBean>mData = new ArrayList<>();
    //当前查询的ID
    private static String listId = "";

    public static Fragment newInstance(String id) {
        TabFragment fragment = new TabFragment();
        listId = id;
        return fragment;
    }


    @Override
    protected void init(View view) {
        swipe_layout = view.findViewById(R.id.swipe_layout);
        recycle_view = view.findViewById(R.id.recycle_view);
        initView();
        presenter.isKnowTabData(listId);
    }

    private void initView() {
        //下拉样式
        swipe_layout.setColorSchemeResources(R.color.app_color, R.color.green, R.color.colorAccent);
        //上拉刷新初始化
        swipe_layout.setOnRefreshListener(this);
        //adapter配置data
        mAdapter = new KnowledgeTabAdapter( R.layout.tab_list_item, mData);
        //打开加载动画
        mAdapter.openLoadAnimation();
        //设置启用加载更多 -- 没启用
//        mAdapter.setEnableLoadMore(false);
        //设置为加载更多监听器 --没启用
//        mAdapter.setOnLoadMoreListener(this, recycle_view);
        //数据为空显示xml
        mAdapter.setEmptyView(LayoutInflater.from(getActivity()).inflate(R.layout.list_empty, null));
        //RecyclerView设置布局管理器
        recycle_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        //RecyclerView配置adapter
        recycle_view.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }


    @Override
    protected TabPresenter createPresenter() {
        return new TabPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tab;
    }

    @Override
    public void onRefresh() {
        swipe_layout.setRefreshing(true);
        presenter.isKnowTabData(listId);
    }

    @Override
    public void showErrorMessage(String msg) {

    }

    @Override
    public void showProgress() {
        swipe_layout.setRefreshing(true);
    }

    @Override
    public void downProgress() {
        swipe_layout.setRefreshing(false);
    }

    @Override
    public void showMePartnerData(List<KnowledgeBean> bean) {
        mData.clear();
        mData.addAll(bean);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 点击列表详情
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        startActivity(new Intent(getActivity(), KnowledgeDetailActivity.class));
    }
}