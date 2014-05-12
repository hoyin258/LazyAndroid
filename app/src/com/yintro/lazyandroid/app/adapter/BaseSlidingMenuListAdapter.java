package com.yintro.lazyandroid.app.adapter;

import android.content.Context;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;

/**
 * Created by hoyin on 12/5/14.
 * Yintro.com
 */
public abstract class BaseSlidingMenuListAdapter<Bundle> extends BaseExpandableListAdapter {

    protected Context mContext;
    protected ArrayList<Bundle> mGroup;
    protected ArrayList<ArrayList<Bundle>> mChild;


    public BaseSlidingMenuListAdapter(Context context) {
        mContext = context;
    }

    public void setData(ArrayList<Bundle> mGroup, ArrayList<ArrayList<Bundle>> mChild) {
        this.mGroup = mGroup;
        this.mChild = mChild;
    }

    @Override
    public int getGroupCount() {
        return mGroup.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mChild.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return mGroup.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        return mChild.get(i).get(i2);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        //Assume child size <1000
        return i*1000+i2;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
