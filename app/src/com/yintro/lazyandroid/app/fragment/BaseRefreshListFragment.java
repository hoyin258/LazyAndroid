package com.yintro.lazyandroid.app.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.yintro.lazyandroid.app.R;

/**
 * Created by hoyin on 11/5/14.
 * Yintro.com
 */
public abstract class BaseRefreshListFragment extends BaseFragment  implements AdapterView.OnItemClickListener, PullToRefreshBase.OnRefreshListener, PullToRefreshBase.OnLastItemVisibleListener {

    protected abstract ListAdapter getAdapter();
    protected abstract String getEmptyMessage();

    protected FrameLayout vgRefreshListContainer;
    protected ProgressBar pgList;
    protected TextView tvEmpty;
    protected PullToRefreshListView lvRefreshContent;
    protected ListAdapter mListAdapter;

    @Override
    protected void assignViews() {
        vgRefreshListContainer = (FrameLayout) findViewById(R.id.vgRefreshListContainer);
        pgList = (ProgressBar) findViewById(R.id.pgList);
        tvEmpty = (TextView) findViewById(R.id.tvEmpty);
        lvRefreshContent = (PullToRefreshListView) findViewById(R.id.lvRefreshContent);
    }

    @Override
    protected void setListeners() {
        lvRefreshContent.setOnItemClickListener(this);
        lvRefreshContent.setOnRefreshListener(this);
        lvRefreshContent.setOnLastItemVisibleListener(this);
    }

    protected void init() {

        pgList.setVisibility(View.VISIBLE);
        lvRefreshContent.setVisibility(View.GONE);

        tvEmpty.setText(getEmptyMessage());
        lvRefreshContent.setEmptyView(tvEmpty);
        mListAdapter = getAdapter();
        lvRefreshContent.setAdapter(mListAdapter);
        onRefresh(lvRefreshContent);
    }


    public void finishLoading() {
        pgList.setVisibility(View.GONE);
        lvRefreshContent.setVisibility(View.VISIBLE);
        lvRefreshContent.onRefreshComplete();
    }
}
