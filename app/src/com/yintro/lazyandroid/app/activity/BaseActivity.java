package com.yintro.lazyandroid.app.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by hoyin on 10/5/14.
 * Yintro.com
 */
public abstract class BaseActivity extends Activity {

    protected Context mContext;

    // 自動從Plugin生成
    protected abstract void assignViews();

    // View 內的事件放這裡
    protected abstract void setListeners();

    // Assign Value....etc
    protected abstract void init();

    // 取得後台資料
    protected abstract void getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutIdFromClassName());
        assignViews();
        setListeners();
        init();
        getData();
    }

    private int getLayoutIdFromClassName() {
        String name = "activity_" + getClass().getSimpleName().replace("Activity", "").toLowerCase();
        return getResources().getIdentifier(name, "layout", mContext.getPackageName());
    }


}
