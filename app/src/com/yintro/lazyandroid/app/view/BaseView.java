package com.yintro.lazyandroid.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.yintro.lazyandroid.app.helper.YintroHelper;

/**
 * Created by hoyin on 10/5/14.
 * Yintro.com
 */
public abstract class BaseView extends FrameLayout{

    protected View mView;
    protected Context mContext;

    public BaseView(Context context) {
        super(context);
        initTemplate();
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTemplate();
    }

    public BaseView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initTemplate();
    }

    // 自動從Plugin生成
    protected abstract void assignViews();

    // View 內的事件放這裡
    protected abstract void setListeners();

    // Assign Value....etc
    protected abstract void init();

    // 取得後台資料
    protected abstract void getData();

    private void initTemplate(){
        mView = inflate(getContext(),getLayoutIdFromClassName(), this);
        assignViews();
        setListeners();
        init();
        getData();
    }


    private int getLayoutIdFromClassName() {
        return YintroHelper.getLayoutIdFromName(mContext, "view", getClass().getSimpleName().replace("View", ""));
    }
}
