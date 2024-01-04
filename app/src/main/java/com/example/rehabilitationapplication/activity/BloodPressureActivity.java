package com.example.rehabilitationapplication.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.base.BaseActivity;
import com.example.rehabilitationapplication.myview.MPLineChartManager;
import com.example.rehabilitationapplication.myview.MyMarkerView;
import com.example.rehabilitationapplication.persenter.BloodPressurePresenter;
import com.example.rehabilitationapplication.view.BloodPressureView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2024/1/2
 * 描述:血压
 */
public class BloodPressureActivity extends BaseActivity<BloodPressurePresenter, BloodPressureView>implements BloodPressureView {

    private LineChart line_chart;
    private ArrayList<Entry> entryList = new ArrayList<>();
    private ArrayList<Entry> entryList1 = new ArrayList<>();
    private ArrayList<String> xValue= new ArrayList<>();
    private MyMarkerView mv;
    private MPLineChartManager mpLineChartManager;
    @Override
    protected int getLayoutId() {
        return R.layout.blood_pressure_activity;
    }

    @Override
    protected BloodPressurePresenter createPresenter() {
        return new BloodPressurePresenter();
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

        entryList1.add(new Entry(0, 20));
        entryList1.add(new Entry(1, 20));
        entryList1.add(new Entry(2, 20));
        entryList1.add(new Entry(3, 20));
        entryList1.add(new Entry(4, 20));
        //填充数据到线形图
        clickLineChart(line_chart, entryList,xValue,5);
    }









    /*************************************************** 新的折线图 start *****************************************/
    private void clickLineChart(LineChart lineChart, ArrayList<Entry> entries, ArrayList<String> xvalue, int xCount) {
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
        mpLineChartManager.addData(entries, null, 0f, getResources().getColor(R.color.linecolor), 8f, true, 5f, 0, false, getResources().getColor(R.color.bomcolor));
        mpLineChartManager.addData(entryList1, null, 0f, getResources().getColor(R.color.linecolor), 8f, true, 5f, 0, false, getResources().getColor(R.color.bomcolor));
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
    protected void initListener() {

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