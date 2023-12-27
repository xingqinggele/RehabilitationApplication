package com.example.rehabilitationapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.rehabilitationapplication.base.BaseNoActivity;
import com.example.rehabilitationapplication.fragment.HealthFragment;
import com.example.rehabilitationapplication.fragment.HomeFragment;
import com.example.rehabilitationapplication.fragment.KnowledgeFragment;
import com.example.rehabilitationapplication.fragment.MeFragment;
import com.example.rehabilitationapplication.util.Utils;

public class MainActivity extends BaseNoActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottom_nav;
    private Fragment[] fragments; //fragment数组
    private int lastFragmentIndex = 0;//初始显示的页码

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setItemIconTintList(null);
        fragments = new Fragment[]{
                new HomeFragment(),
                new HealthFragment(),
                new KnowledgeFragment(),
                new MeFragment()};
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frame, fragments[0])
                .commit();

    }

    @Override
    protected void initListener() {
        bottom_nav.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //选中效果
        item.setChecked(true);
        switch (item.getItemId()) {
            //首页
            case R.id.home_btn:
                //设置状态栏颜色,修改状态栏字体颜色
//                statusBarConfig(R.color.white, true).init();
                switchFragment(0);
                break;
                //健康
            case R.id.health_btn:
                //设置状态栏颜色
//                statusBarConfig(R.color.new_theme_color, false).init();
                switchFragment(1);
                break;
                //知识
            case R.id.knowledge_btn:
                //设置状态栏颜色
//                statusBarConfig(R.color.new_theme_color, false).init();
                switchFragment(2);
                break;
                //我的
            case R.id.me_btn:
                //设置状态栏颜色
//                statusBarConfig(R.color.new_theme_color, false).init();
                switchFragment(3);
                break;
        }
        return false;
    }

    private void switchFragment(int to) {
        if (lastFragmentIndex == to) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragments[to].isAdded()) {
            transaction.add(R.id.main_frame, fragments[to]);
        } else {
            transaction.show(fragments[to]);
        }
        transaction.hide(fragments[lastFragmentIndex]).commitAllowingStateLoss();
        lastFragmentIndex = to;
    }

    //退出
    @Override
    public void onBackPressed() {
        Utils.onFinish(this, getResources().getString(R.string.app_name));
    }
}