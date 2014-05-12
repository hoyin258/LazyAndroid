package com.yintro.lazyandroid.app.fragment;

import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yintro.lazyandroid.app.R;

/**
 * Created by hoyin on 11/5/14.
 * Yintro.com
 */
public abstract class BaseListFragment extends BaseFragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    protected abstract ListAdapter getAdapter();
    protected abstract String getEmptyMessage();


    protected ListView lvContent;
    protected TextView tvEmpty;
    protected ListAdapter mListAdapter;

    @Override
    protected void assignViews() {
        lvContent = (ListView) findViewById(R.id.lvContent);
        tvEmpty = (TextView) findViewById(R.id.tvEmpty);
    }

    @Override
    protected void setListeners() {
        lvContent.setOnItemClickListener(this);
        lvContent.setOnItemLongClickListener(this);
    }

    protected void init() {
        tvEmpty.setText(getEmptyMessage());
        mListAdapter = getAdapter();
        lvContent.setEmptyView(tvEmpty);
        lvContent.setAdapter(mListAdapter);
    }
}
