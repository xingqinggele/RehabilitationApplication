package com.example.rehabilitationapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rehabilitationapplication.R;

/**
 * 作者: qgl
 * 创建日期：2023/12/27
 * 描述:
 */
public class TabFragment extends Fragment {

        public static Fragment newInstance() {
            TabFragment fragment = new TabFragment();
            return fragment;
        }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_tab, container, false);
//
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_list);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(new RecyclerAdapter());
//
//        return view;
//    }
} 