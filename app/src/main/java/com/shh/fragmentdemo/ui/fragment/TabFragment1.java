package com.shh.fragmentdemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.shh.fragmentdemo.R;
import com.shh.fragmentdemo.base.BaseFragment;
import com.shh.fragmentdemo.base.LazyLoadFragment;

import butterknife.OnClick;

public class TabFragment1 extends LazyLoadFragment {
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

    public TabFragment1() {
        // Required empty public constructor
    }

    public static TabFragment1 newInstance(String data) {
        TabFragment1 fragment = new TabFragment1();
        Bundle args = new Bundle();
        args.putString(DATA, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int initLayoutRes() {
        return R.layout.fragment_layout3;
    }

    @Override
    protected void initData() {
        if (getArguments() != null) {
            data = getArguments().getString(DATA);
        }

        fragmentManager = getChildFragmentManager();

        fragments = new BaseFragment[3];
        fragments[0] = TabFragment.newInstance("tabA");
        fragments[1] = TabFragment.newInstance("tabB");
        fragments[2] = TabFragment.newInstance("tabC");
    }

    @Override
    protected void initView() {
        fragmentManager.beginTransaction()
                .add(R.id.fl_container, fragments[0], fragments[0].getClass().getName())
                .add(R.id.fl_container, fragments[1], fragments[1].getClass().getName())
                .add(R.id.fl_container, fragments[2], fragments[2].getClass().getName())
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

    @Override
    protected boolean isNeedReload() {
        return true;
    }
}
