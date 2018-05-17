package com.shh.fragmentdemo.ui.activity;

import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.shh.fragmentdemo.R;
import com.shh.fragmentdemo.base.BaseActivity;
import com.shh.fragmentdemo.base.BaseFragment;
import com.shh.fragmentdemo.ui.fragment.TabFragment;
import com.shh.fragmentdemo.ui.fragment.TabFragment1;

import butterknife.OnClick;

public class TabActivity extends BaseActivity {

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

    @OnClick(R.id.tv_tab3)
    public void tab3() {
        switchTab(3);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_tab;
    }

    @Override
    protected void initData() {
        fragmentManager = getSupportFragmentManager();

        fragments = new BaseFragment[4];
        fragments[0] = TabFragment.newInstance("1-1");
        fragments[1] = TabFragment1.newInstance("1-2");
        fragments[2] = TabFragment.newInstance("1-3");
        fragments[3] = TabFragment.newInstance("1-4");
    }

    @Override
    protected void initView() {
        fragmentManager.beginTransaction()
                .add(R.id.fl_container, fragments[0], "1-1")
                .add(R.id.fl_container, fragments[1], "1-2")
                .add(R.id.fl_container, fragments[2], "1-3")
                .add(R.id.fl_container, fragments[3], "1-4")
                .hide(fragments[0])
                .hide(fragments[1])
                .hide(fragments[2])
                .hide(fragments[3])
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
}
