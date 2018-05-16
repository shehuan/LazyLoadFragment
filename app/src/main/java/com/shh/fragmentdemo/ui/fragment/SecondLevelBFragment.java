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

public class SecondLevelBFragment extends LazyLoadFragment {
    private List<BaseFragment> mFragments;
    private List<String> mTitles;

    @BindView(R.id.tablayout_sub)
    TabLayout mTabLayout;

    @BindView(R.id.viewpager_sub)
    ViewPager mViewPager;

    public SecondLevelBFragment() {
        // Required empty public constructor
    }

    public static SecondLevelBFragment newInstance() {
        SecondLevelBFragment fragment = new SecondLevelBFragment();
        return fragment;
    }

    @Override
    protected int initLayoutRes() {
        return R.layout.fragment_layout2;
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(ThirdLevelAFragment.newInstance("3-1"));
        mFragments.add(ThirdLevelBFragment.newInstance("3-2"));
        mFragments.add(ThirdLevelCFragment.newInstance("3-3"));

        mTitles = new ArrayList<>();
        mTitles.add("3-1");
        mTitles.add("3-2");
        mTitles.add("3-3");
    }

    @Override
    protected void initView() {
        SubPagerAdapter pagerAdapter = new SubPagerAdapter(getChildFragmentManager());
        pagerAdapter.setData(mFragments, mTitles);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOffscreenPageLimit(mTitles.size() - 1);
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
        Log.e("load", "2-2");
    }
}
