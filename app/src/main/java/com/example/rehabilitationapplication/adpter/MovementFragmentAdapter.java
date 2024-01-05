package com.example.rehabilitationapplication.adpter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.rehabilitationapplication.R;
import com.example.rehabilitationapplication.bean.KnowledgeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2023/12/28
 * 描述:知识adapter
 */
public class MovementFragmentAdapter extends BaseAdapter {
    private Context mContext;
    private List<KnowledgeBean> mData = new ArrayList();
    private onClinkTo clinkTo;
    public MovementFragmentAdapter(Context context) {
        mContext = context;
    }

    public void setDates(List datas) {
        mData.addAll(datas);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ViewHolder mViewHolder;
        if (view == null) {
            mViewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(R.layout.movement_list_item, null);
            mViewHolder.tv1 = view.findViewById(R.id.tv1);
            mViewHolder.iv1 = view.findViewById(R.id.iv1);
            view.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder) view.getTag();
        }
        mViewHolder.tv1.setText(mData.get(position).getTitle());
        mViewHolder.iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clinkTo.goToPage(mData.get(position).getId());
            }
        });
        return view;
    }

    class ViewHolder {
        TextView tv1;
        ImageView iv1;
    }

    public static interface onClinkTo{
        public void goToPage(String id);
    }

    public void setOnClinkTo(onClinkTo clinkTo){
        this.clinkTo = clinkTo;
    }
}