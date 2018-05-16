package com.shh.fragmentdemo.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.shh.fragmentdemo.R;
import com.shh.fragmentdemo.adapter.SubPagerAdapter;
import com.shh.fragmentdemo.base.BaseFragment;
import com.shh.fragmentdemo.base.LazyLoadFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FirstLevelBFragment extends LazyLoadFragment {

    private List<BaseFragment> mFragments;
    private List<String> mTitles;

    @BindView(R.id.tablayout_sub)
    TabLayout mTabLayout;

    @BindView(R.id.viewpager_sub)
    ViewPager mViewPager;

    public FirstLevelBFragment() {
        // Required empty public constructor
    }

    public static FirstLevelBFragment newInstance() {
        FirstLevelBFragment fragment = new FirstLevelBFragment();
        return fragment;
    }

    @Override
    protected int initLayoutRes() {
        return R.layout.fragment_layout2;
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(SecondLevelAFragment.newInstance("2-1"));
        mFragments.add(SecondLevelBFragment.newInstance());
        mFragments.add(SecondLevelCFragment.newInstance("2-3"));

        mTitles = new ArrayList<>();
        mTitles.add("2-1");
        mTitles.add("2-2");
        mTitles.add("2-3");
    }

    @Override
    protected void initView() {
        SubPagerAdapter pagerAdapter = new SubPagerAdapter(getChildFragmentManager());
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

    @Override
    protected void loadData() {
        Log.e("load", "1-2");
    }
}
