package com.yintro.lazyandroid.app.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.yintro.lazyandroid.app.R;
import com.yintro.lazyandroid.app.helper.YintroHelper;

/**
 * Created by hoyin on 10/5/14.
 * Yintro.com
 */
public abstract class BaseSlidingFragmentActivity extends SlidingFragmentActivity {

    public abstract Fragment getDefaultFragment();

    protected Fragment mCurrentFragment;
    protected SlidingMenu mSlidingMenu;


    @Override
    protected void assignViews() {

    }

    @Override
    protected void init() {

    }

    @Override
    protected void beforeSetContentView(Bundle savedInstanceState) {
        super.beforeSetContentView(savedInstanceState);
        setBehindContentView(getMenuLayoutId());
        initSlidingMenu();
    }

    @Override
    protected void afterOnCreate(Bundle savedInstanceState) {
        super.afterOnCreate(savedInstanceState);
        assignFragment(savedInstanceState);
    }

    protected int getMenuLayoutId() {
        String menuName = getClass().getSimpleName().replace("Activity", "")+"Menu";
        return YintroHelper.getLayoutIdFromName(mContext, "activity", menuName);
    }

    protected void assignFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            try {
                Bundle fragmentBundle = getIntent().getExtras();
                if (fragmentBundle == null) {
                    mCurrentFragment = getDefaultFragment();
                } else {
                    String fragmentName = fragmentBundle.getString(KEY_FRAGMENT_NAME);
                    Bundle bundle = fragmentBundle.getBundle(KEY_FRAGMENT_BUNDLE);
                    mCurrentFragment = (Fragment) Class.forName(fragmentName).newInstance();
                    if (bundle != null) {
                        mCurrentFragment.setArguments(bundle);
                    }
                }
                getFragmentManager().beginTransaction()
                        .add(R.id.vgContent, mCurrentFragment)
                        .commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            mCurrentFragment = getFragmentManager().findFragmentById(R.id.vgContent);
        }
    }


    //會導致Memory 增加
    public void toSamePageWithHistory(Fragment fragment) {
        mCurrentFragment = fragment;
        getFragmentManager().beginTransaction()
                .replace(R.id.vgContent, mCurrentFragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showContent();
                    }
                }, 400);
            }
        });
    }

    public void toSamePage(Fragment fragment) {
        mCurrentFragment = fragment;
        getFragmentManager().beginTransaction()
                .replace(R.id.vgContent, mCurrentFragment)
                .commit();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showContent();
                    }
                }, 400);
            }
        });
    }

    protected void initSlidingMenu() {
        mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        mSlidingMenu.setTouchModeAbove(SlidingMenu.LEFT);
        mSlidingMenu.setShadowDrawable(R.drawable.slidingmenu_sidebar_right_shadow);
    }

}
