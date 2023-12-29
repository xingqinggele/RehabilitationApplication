package com.example.rehabilitationapplication.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.persenter.HomePresenter;
import com.example.rehabilitationapplication.util.StatusBarUtil;
import com.example.rehabilitationapplication.view.HomeView;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:主页
 */
public class HomeFragment extends BaseFragment<HomePresenter,HomeView> implements HomeView, RadioGroup.OnCheckedChangeListener {
    private RadioGroup radio_group;
    private Fragment[] fragments; //fragment数组
    private int lastFragmentIndex = 0;//初始显示的页码
    @Override
    protected void init(View view) {
        fragments = new Fragment[]{

                new MovementFragment(),
                new RehabilitationFragment()};
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.home_frame, fragments[0])
                .commit();

        radio_group = view.findViewById(R.id.radio_group);
        radio_group.setOnCheckedChangeListener(this);
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutId() {
        //导航栏设置
        StatusBarUtil.transparencyBar(getActivity());
        return R.layout.home_fragment;
    }

    @Override
    public void onRefresh() {

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
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.tab1:
                switchFragment(0);
                break;
            case R.id.tab2:
                switchFragment(1);
                break;
        }
    }


    private void switchFragment(int to) {
        if (lastFragmentIndex == to) {
            return;
        }
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        if (!fragments[to].isAdded()) {
            transaction.add(R.id.main_frame, fragments[to]);
        } else {
            transaction.show(fragments[to]);
        }
        transaction.hide(fragments[lastFragmentIndex]).commitAllowingStateLoss();
        lastFragmentIndex = to;
    }
}