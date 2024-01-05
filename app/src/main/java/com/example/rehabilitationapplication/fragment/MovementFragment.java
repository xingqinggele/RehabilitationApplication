package com.example.rehabilitationapplication.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.activity.GoSportsActivity;
import com.example.rehabilitationapplication.activity.SportsIntroductionActivity;
import com.example.rehabilitationapplication.adpter.MovementFragmentAdapter;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.bean.KnowledgeBean;
import com.example.rehabilitationapplication.myview.MyListView;
import com.example.rehabilitationapplication.persenter.MovementFragmentPresenter;
import com.example.rehabilitationapplication.view.MovementFragmentView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/29
 * 描述:运动
 */
public class MovementFragment extends BaseFragment<MovementFragmentPresenter,MovementFragmentView> implements MovementFragmentView, View.OnClickListener, MovementFragmentAdapter.onClinkTo {
    private MyListView recycler_view;
    private MovementFragmentAdapter mAdapter;
    private List<KnowledgeBean> mData = new ArrayList<>();
    //去运动按钮
    private ImageView go_sports_iv;
    @Override
    protected void init(View view) {
        recycler_view = view.findViewById(R.id.recycler_view);
        go_sports_iv = view.findViewById(R.id.go_sports_iv);
        presenter.isShowData();
        go_sports_iv.setOnClickListener(this);
        mAdapter.setOnClinkTo(this);
    }

    @Override
    protected MovementFragmentPresenter createPresenter() {
        return new  MovementFragmentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.movement_fragment;
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
        mAdapter = new MovementFragmentAdapter(getActivity());
        mAdapter.setDates(mData);
        recycler_view.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.go_sports_iv:
                startActivity(new Intent(getActivity(), SportsIntroductionActivity.class));
                break;
        }
    }

    /**
     * 点击运动
     * @param id
     */
    @Override
    public void goToPage(String id) {
        startActivity(new Intent(getActivity(), SportsIntroductionActivity.class));
    }
}