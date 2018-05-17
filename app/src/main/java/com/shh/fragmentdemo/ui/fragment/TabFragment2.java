package com.shh.fragmentdemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.shh.fragmentdemo.R;
import com.shh.fragmentdemo.base.BaseFragment;
import com.shh.fragmentdemo.base.LazyLoadFragment;

import butterknife.OnClick;

public class TabFragment2 extends LazyLoadFragment {
    private static final String DATA = "data";

    private String data;

    private BaseFragment[] fragments;
    private FragmentManager fragmentManager;
    private int lastIndex;

    @OnClick(R.id.tv_tab0)
    public void tab0() {
        switchTab(0);
    }

    @OnClick(R.id.tv_tab1)
    public void tab1() {
        switchTab(1);
    }

    @OnClick(R.id.tv_tab2)
    public void tab2() {
        switchTab(2);
    }

    public TabFragment2() {
        // Required empty public constructor
    }

    public static TabFragment2 newInstance(String data) {
        TabFragment2 fragment = new TabFragment2();
        Bundle args = new Bundle();
        args.putString(DATA, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int initLayoutRes() {
        return R.layout.fragment_layout4;
    }

    @Override
    protected void initData() {
        if (getArguments() != null) {
            data = getArguments().getString(DATA);
        }

        fragmentManager = getChildFragmentManager();

        fragments = new BaseFragment[3];
        fragments[0] = TabFragment.newInstance("3-1");
        fragments[1] = TabFragment.newInstance("3-2");
        fragments[2] = TabFragment.newInstance("3-3");
    }

    @Override
    protected void initView() {
        fragmentManager.beginTransaction()
                .add(R.id.fl_container, fragments[0], "3-1")
                .add(R.id.fl_container, fragments[1], "3-2")
                .add(R.id.fl_container, fragments[2], "3-3")
                .hide(fragments[0])
                .hide(fragments[1])
                .hide(fragments[2])
                .show(fragments[0])
                .commit();
        lastIndex = 0;
    }

    private void switchTab(int currentIndex) {
        if (currentIndex == lastIndex) {
            return;
        }
        fragmentManager.beginTransaction()
                .hide(fragments[lastIndex])
                .show(fragments[currentIndex])
                .commit();
        lastIndex = currentIndex;
    }

    @Override
    protected void loadData() {
        Log.e("load", data);
    }
}
