package com.example.rehabilitationapplication.fragment;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.View;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.activity.BloodOxygenActivity;
import com.example.rehabilitationapplication.activity.BloodPressureActivity;
import com.example.rehabilitationapplication.activity.HeartRateActivity;
import com.example.rehabilitationapplication.base.BaseFragment;
import com.example.rehabilitationapplication.persenter.HealthPresenter;
import com.example.rehabilitationapplication.view.HealthView;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:健康页
 */
public class HealthFragment extends BaseFragment<HealthPresenter, HealthView> implements HealthView, View.OnClickListener {
    //血氧
    private ConstraintLayout blood_oxygen_con;
    private ConstraintLayout blood_pressure_con;
    private ConstraintLayout blood_heart_rate_con;

    @Override
    protected void init(View view) {
        blood_oxygen_con = view.findViewById(R.id.blood_oxygen_con);
        blood_pressure_con = view.findViewById(R.id.blood_pressure_con);
        blood_heart_rate_con = view.findViewById(R.id.blood_heart_rate_con);
        blood_oxygen_con.setOnClickListener(this);
        blood_pressure_con.setOnClickListener(this);
        blood_heart_rate_con.setOnClickListener(this);
    }

    @Override
    protected HealthPresenter createPresenter() {
        return new HealthPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.health_fragment;
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.blood_oxygen_con:
                startActivity(new Intent(getActivity(), BloodOxygenActivity.class));
                break;
            case R.id.blood_pressure_con:
                startActivity(new Intent(getActivity(), BloodPressureActivity.class));
                break;
            case R.id.blood_heart_rate_con:
                startActivity(new Intent(getActivity(), HeartRateActivity.class));
                break;
        }
    }
}