package com.shh.fragmentdemo.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.shh.fragmentdemo.ui.fragment.FirstLevelAFragment;
import com.shh.fragmentdemo.ui.fragment.FirstLevelBFragment;
import com.shh.fragmentdemo.R;
import com.shh.fragmentdemo.adapter.SubPagerAdapter;
import com.shh.fragmentdemo.base.BaseActivity;
import com.shh.fragmentdemo.base.BaseFragment;
import com.shh.fragmentdemo.ui.fragment.FirstLevelCFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private List<BaseFragment> mFragments;
    private List<String> mTitles;

    @BindView(R.id.tablayout_main)
    TabLayout mTabLayout;

    @BindView(R.id.viewpager_main)
    ViewPager mViewPager;

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(FirstLevelAFragment.newInstance("1-1"));
        mFragments.add(FirstLevelBFragment.newInstance());
        mFragments.add(FirstLevelCFragment.newInstance("1-3"));

        mTitles = new ArrayList<>();
        mTitles.add("1-1");
        mTitles.add("1-2");
        mTitles.add("1-3");
    }

    @Override
    protected void initView() {
        SubPagerAdapter pagerAdapter = new SubPagerAdapter(getSupportFragmentManager());
        pagerAdapter.setData(mFragments, mTitles);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOffscreenPageLimit(mTitles.size());
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
