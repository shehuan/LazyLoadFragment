package com.shh.fragmentdemo.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.shh.fragmentdemo.R;
import com.shh.fragmentdemo.base.LazyLoadFragment;
import com.shh.fragmentdemo.ui.activity.TabActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class FirstLevelCFragment extends LazyLoadFragment {
    private static final String DATA = "data";

    private String data;

    @BindView(R.id.tv_data)
    TextView dataTv;

    @OnClick(R.id.tv_data)
    public void start() {
        if ("1-3".equals(data)) {
            startActivity(new Intent(mActivity, TabActivity.class));
        }
    }

    public FirstLevelCFragment() {
        // Required empty public constructor
    }

    public static FirstLevelCFragment newInstance(String data) {
        FirstLevelCFragment fragment = new FirstLevelCFragment();
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
        if ("1-3".equals(data)) {
            dataTv.setText("Open FragmentManager Test");
        } else {
            dataTv.setText("content:" + data);
        }
    }

    @Override
    protected void loadData() {
        Log.e("load", "1-3");
    }
}
