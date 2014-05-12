package com.yintro.lazyandroid.app.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yintro.lazyandroid.app.fragment.BaseFragment;
import com.yintro.lazyandroid.app.helper.YintroHelper;

/**
 * Created by hoyin on 10/5/14.
 * Yintro.com
 */
public abstract class BaseActivity extends Activity {

    public static final String KEY_FRAGMENT_NAME = "fragment_name";
    public static final String KEY_FRAGMENT_BUNDLE = "fragment_bundle";

    // 自動從Plugin生成
    protected abstract void assignViews();

    // View 內的事件放這裡
    protected abstract void setListeners();

    // Assign Value....etc
    protected abstract void init();

    // 取得後台資料
    protected abstract void getData();

    protected Context mContext;

    //跟隨Activity LifeCycle 的Background Task
    protected AsyncTask mBackgroundTask;

    protected BaseFragment mCurrentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        beforeSetContentView(savedInstanceState);
        setContentView(getLayoutId());
        assignViews();
        setListeners();
        init();
        getData();
        afterOnCreate(savedInstanceState);
    }

    protected void beforeSetContentView(Bundle savedInstanceState) {
    }

    protected void afterOnCreate(Bundle savedInstanceState) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBackgroundTask != null)
            mBackgroundTask.cancel(true);
    }


    @Override
    public void onBackPressed() {
        onBackPressed(null);
    }

    public void onBackPressed(View v) {
        if (mCurrentFragment != null) {
            if (mCurrentFragment.onBackPressed()) {
                return;
            }
        }
        super.onBackPressed();
    }


    protected int getLayoutId() {
        return YintroHelper.getLayoutIdFromName(mContext, "activity", getClass().getSimpleName().replace("Activity", ""));
    }

    protected void say(String message){
        Toast.makeText(mContext, message,Toast.LENGTH_SHORT).show();
    }

    public void toHomePage() {
        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void toNewPage(String fragmentName, Bundle bundle, Class<? extends BaseActivity> cls) {
        finish();
        Intent i = new Intent();
        i.setClass(mContext, cls.getClass());
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra(KEY_FRAGMENT_NAME, fragmentName);
        i.putExtra(KEY_FRAGMENT_BUNDLE, bundle);
        startActivity(i);
    }

    public void restart(Class<? extends BaseActivity> cls) {
        Intent i = new Intent();
        i.setClass(mContext, cls.getClass());
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);


    }
}
