package com.yintro.lazyandroid.app.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yintro.lazyandroid.app.helper.YintroHelper;

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
        mView = inflater.inflate(getLayoutId(), container, false);
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

    //正常不會做任何Action
    public boolean onBackPressed() {
        return false;
    }

    protected View findViewById(int id) {
        return mView.findViewById(id);
    }

    protected void say(String message){
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    protected int getLayoutId() {
        return YintroHelper.getLayoutIdFromName(mContext, "fragment", getClass().getSimpleName().replace("Fragment", ""));
    }

}
