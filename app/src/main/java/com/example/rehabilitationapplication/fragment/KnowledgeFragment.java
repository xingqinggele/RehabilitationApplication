package com.example.rehabilitationapplication.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.adpter.ViewPagerAdapter;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.persenter.KnowledgePresenter;
import com.example.rehabilitationapplication.view.KnowledgeView;

import java.util.ArrayList;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:知识
 */
public class KnowledgeFragment extends BaseFragment<KnowledgePresenter, KnowledgeView>implements KnowledgeView {

    private ViewPager viewPager;
//    private Fragment[] mFragmentArrays = new Fragment[5];
//    private String[] mTabTitles = new String[5];
    ArrayList<Fragment> fragmentList = new ArrayList<>();
    ArrayList<String> titleDatas = new ArrayList<>();

    @Override
    protected void init(View view) {
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.tab_viewpager);


        titleDatas.add("有氧运动");
        titleDatas.add("抗阻运动");
        titleDatas.add("柔韧性运动");
        titleDatas.add("平衡性运动");
        titleDatas.add("呼吸训练");

        fragmentList.add(TabFragment.newInstance("1"));
        fragmentList.add(TabFragment.newInstance("1"));
        fragmentList.add(TabFragment.newInstance("1"));
        fragmentList.add(TabFragment.newInstance("1"));
        fragmentList.add(TabFragment.newInstance("1"));

//      tabLayout.setTabMode(TabLayout.MODE_FIXED); //固定模式，也就是说 tab顶部不能滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE); //滚动模式 ,可左右滚动，类 今日头条

//            mFragmentArrays[0] = TabFragment.newInstance();
//        mFragmentArrays[1] = TabFragment.newInstance();
//        mFragmentArrays[2] = TabFragment.newInstance();
//        mFragmentArrays[3] = TabFragment.newInstance();
//        mFragmentArrays[4] = TabFragment.newInstance();

//        PagerAdapter pagerAdapter = new MyViewPagerAdapter(getActivity().getSupportFragmentManager());
//        viewPager.setAdapter(pagerAdapter);
        //将ViewPager和TabLayout绑定
//        tabLayout.setupWithViewPager(viewPager);


        ViewPagerAdapter myViewPageAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), titleDatas, fragmentList);
        //设置选中的标签指示器、默认选中第一个
        tabLayout.setSelectedTabIndicator(0);
        //viewPager设置适配器
        viewPager.setAdapter(myViewPageAdapter);
        //设置ViewPager
//        data_partner_results_tab_layout.setupWithViewPager(data_partner_results_viewpager);
        //设置选项卡
        tabLayout.setupWithViewPager(viewPager);

    }

//    final class MyViewPagerAdapter extends FragmentPagerAdapter {
//        public MyViewPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return fragmentList[position];
//        }
//
//        @Override
//        public int getCount() {
//            return mFragmentArrays.length;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mTabTitles[position];
//        }
//    }

    @Override
    protected KnowledgePresenter createPresenter() {
        return new KnowledgePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.know_ledge_fragment;
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