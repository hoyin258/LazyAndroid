package com.yintro.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.yintro.example.view.ExampleSlidingMenuChildView;
import com.yintro.example.view.ExampleSlidingMenuGroupView;
import com.yintro.lazyandroid.app.adapter.BaseSlidingMenuListAdapter;

/**
 * Created by hoyin on 12/5/14.
 * Yintro.com
 */
public class ExampleSlidingMenuAdapter extends BaseSlidingMenuListAdapter{

    public ExampleSlidingMenuAdapter(Context context) {
        super(context);
    }

    @Override
    public View getGroupView(int position, boolean isExpanded, View convertView, ViewGroup viewGroup) {
        ExampleSlidingMenuGroupView mView = (ExampleSlidingMenuGroupView) convertView;
        if (mView == null) {
            mView = new ExampleSlidingMenuGroupView(mContext);
        }
        mView.parse(getGroup(position));
        return mView;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        ExampleSlidingMenuChildView mView = (ExampleSlidingMenuChildView) convertView;
        if (mView == null) {
            mView = new ExampleSlidingMenuChildView(mContext);
        }
        mView.parse(getChild(groupPosition,childPosition));
        return mView;
    }
}
