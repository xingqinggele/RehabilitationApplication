package com.example.rehabilitationapplication.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.persenter.KnowledgePresenter;
import com.example.rehabilitationapplication.view.KnowledgeView;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:知识
 */
public class KnowledgeFragment extends BaseFragment<KnowledgePresenter, KnowledgeView>implements KnowledgeView {

    private ViewPager viewPager;
    private Fragment[] mFragmentArrays = new Fragment[8];
    private String[] mTabTitles = new String[8];
    @Override
    protected void init(View view) {
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.tab_viewpager);


        mTabTitles[0] = "推荐";
        mTabTitles[1] = "热点";
        mTabTitles[2] = "科技";
        mTabTitles[3] = "体育";
        mTabTitles[4] = "健康";
        mTabTitles[5] = "军事";
        mTabTitles[6] = "娱乐";
        mTabTitles[7] = "热点";

//        tabLayout.setTabMode(TabLayout.MODE_FIXED); //固定模式，也就是说 tab顶部不能滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE); //滚动模式 ,可左右滚动，类 今日头条

        mFragmentArrays[0] = TabFragment.newInstance();
        mFragmentArrays[1] = TabFragment.newInstance();
        mFragmentArrays[2] = TabFragment.newInstance();
        mFragmentArrays[3] = TabFragment.newInstance();
        mFragmentArrays[4] = TabFragment.newInstance();
        mFragmentArrays[5] = TabFragment.newInstance();
        mFragmentArrays[6] = TabFragment.newInstance();
        mFragmentArrays[7] = TabFragment.newInstance();

        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);



    }

    final class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentArrays[position];
        }

        @Override
        public int getCount() {
            return mFragmentArrays.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitles[position];
        }
    }

    @Override
    protected KnowledgePresenter createPresenter() {
        return new KnowledgePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.know_ledge_fragment;
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
}