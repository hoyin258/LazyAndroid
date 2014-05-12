package com.yintro.lazyandroid.app.fragment;

import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.yintro.lazyandroid.app.R;

/**
 * Created by hoyin on 11/5/14.
 * Yintro.com
 */
public abstract class BaseViewPagerFragment extends BaseFragment {

    protected PagerSlidingTabStrip pstsTab;
    protected ViewPager vpContent;

    @Override
    protected void assignViews() {
        pstsTab = (PagerSlidingTabStrip) findViewById(R.id.pstsTab);
        vpContent = (ViewPager) findViewById(R.id.vpContent);
    }


}
