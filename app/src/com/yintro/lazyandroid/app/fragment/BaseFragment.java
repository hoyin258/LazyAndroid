package com.yintro.lazyandroid.app.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    protected View mView;
    protected Context mContext;
    protected Fragment mFragment;


    // 自動從Plugin生成
    protected abstract void assignViews();

    // View 內的事件放這裡
    protected abstract void setListeners();

    // Assign Value....etc
    protected abstract void init();

    // 取得後台資料
    protected abstract void getData();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutIdFromClassName(), container, false);
        assignViews();
        setListeners();
        init();
        getData();
        return mView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = getActivity();
        mFragment = this;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mContext = null;
        mFragment = null;
        mView = null;
        System.gc();
        Runtime.getRuntime().gc();
    }

    protected View findViewById(int id) {
        return mView.findViewById(id);
    }


    private int getLayoutIdFromClassName() {
        String name = "fragment_" + getClass().getSimpleName().replace("Fragment", "").toLowerCase();
        return getResources().getIdentifier(name, "layout", mContext.getPackageName());
    }

}
