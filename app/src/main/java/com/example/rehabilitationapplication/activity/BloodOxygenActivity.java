package com.example.rehabilitationapplication.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseActivity;
import com.example.rehabilitationapplication.myview.MPLineChartManager;
import com.example.rehabilitationapplication.myview.MyMarkerView;
import com.example.rehabilitationapplication.persenter.BloodOxygenPresenter;
import com.example.rehabilitationapplication.util.TimeUtils;
import com.example.rehabilitationapplication.view.BloodOxygenView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2024/1/2
 * 描述:血氧
 */
public class BloodOxygenActivity extends BaseActivity<BloodOxygenPresenter, BloodOxygenView> implements BloodOxygenView, View.OnClickListener {
    private LineChart line_chart;
    private MyMarkerView mv;
    private MPLineChartManager mpLineChartManager;
    private ArrayList<String> xValue= new ArrayList<>();
    private ArrayList<Entry> entryList = new ArrayList<>();
    //时间筛选
    private TextView time_tv;
    private LinearLayout iv_back;
    @Override
    protected int getLayoutId() {
        statusBarConfig(R.color.white,true).init();
        return R.layout.blood_oxygen_activity;
    }

    @Override
    protected BloodOxygenPresenter createPresenter() {
        return new BloodOxygenPresenter();
    }

    @Override
    protected void init() {
        line_chart = findViewById(R.id.line_chart);
        xValue.add("00:00");
        entryList.add(new Entry(0, 100));
        xValue.add("06:00");
        entryList.add(new Entry(1, 70));
        xValue.add("12:00");
        entryList.add(new Entry(2, 80));
        xValue.add("18:00");
        entryList.add(new Entry(3, 90));
        xValue.add("23:59");
        entryList.add(new Entry(4, 60));
        //填充数据到线形图
        clickLineChart(line_chart, entryList, xValue, 5);
        time_tv = findViewById(R.id.time_tv);
        iv_back = findViewById(R.id.iv_back);

    }

    @Override
    protected void initListener() {
        time_tv.setOnClickListener(this);
        iv_back.setOnClickListener(this);
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

    /*************************************************** 新的折线图 start *****************************************/
    private void clickLineChart(LineChart lineChart, ArrayList<Entry> values1, ArrayList<String> xvalue, int xCount) {
        //关闭描述
        lineChart.getDescription().setEnabled(false);
        //是否显示边界
        lineChart.setDrawBorders(false);
        //是否展示网格线
        lineChart.setDrawGridBackground(false);

        mv = new MyMarkerView(this, R.layout.marker_view, lineChart, xvalue);
        mv.setChartView(lineChart);
        lineChart.setMarker(mv);
        //引入方法
        mpLineChartManager = new MPLineChartManager(lineChart);
        //X轴数据
        mpLineChartManager.setXAxis(xvalue, xCount, true, false, 10f, getResources().getColor(R.color.textcolor), XAxis.XAxisPosition.BOTTOM, 0);
        // 添加限制线值
        List<LimitLine> lineList = new ArrayList<>();
        //Y轴数据
        mpLineChartManager.setYLeftAndLimit(lineList, 6f, getResources().getColor(R.color.textcolor), getResources().getColor(R.color.linec));
        //Y轴动画 动画速度
        mpLineChartManager.animationY(1000); // 图4
        //添加线
        mpLineChartManager.addData(values1, null, 0f, getResources().getColor(R.color.app_color), 8f, true, 5f, 0, true, getResources().getColor(R.color.white));
        //切换立方
        mpLineChartManager.changeMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        //是否显示顶点值
        mpLineChartManager.changeTheVerValue(false);
        mpLineChartManager.setData();
        //设置与图表交互
        mpLineChartManager.setInteraction(true, false, false, false, false, false, false, false);
        //设置图例
        mpLineChartManager.setLegend(Legend.LegendPosition.RIGHT_OF_CHART, 10f, Color.BLACK, Legend.LegendForm.NONE);
    }
    /*************************************************** 新的折线图 end *****************************************/

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.time_tv:
                selectTime(time_tv);
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

    /**
     * 时间选择
     * @param textView
     */
    public static void selectTime(TextView textView) {
        TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                textView.setText(TimeUtils.getSelectCerTime(date));
            }
        }).setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .build();
        pvTime.show();

    }


}