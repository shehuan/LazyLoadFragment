package com.shh.fragmentdemo.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.shh.fragmentdemo.R;
import com.shh.fragmentdemo.base.LazyLoadFragment;

import butterknife.BindView;

public class SecondLevelAFragment extends LazyLoadFragment {
    private static final String DATA = "data";

    private String data;

    @BindView(R.id.tv_data)
    TextView dataTv;

    public SecondLevelAFragment() {
        // Required empty public constructor
    }

    public static SecondLevelAFragment newInstance(String data) {
        SecondLevelAFragment fragment = new SecondLevelAFragment();
        Bundle args = new Bundle();
        args.putString(DATA, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int initLayoutRes() {
        return R.layout.fragment_layout1;
    }

    @Override
    protected void initData() {
        if (getArguments() != null) {
            data = getArguments().getString(DATA);
        }
    }

    @Override
    protected void initView() {
        dataTv.setText("content:" + data);
    }

    @Override
    protected void loadData() {
        Log.e("load", "2-1");
    }
}
