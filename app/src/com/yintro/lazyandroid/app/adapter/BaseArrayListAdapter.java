package com.yintro.lazyandroid.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by hoyin on 10/5/14.
 * Yintro.com
 */
public abstract class BaseArrayListAdapter<T> extends BaseAdapter {

    protected LayoutInflater mInflater;
    protected Context mContext;
    protected ArrayList<T> mArrayList;

    public BaseArrayListAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mArrayList = new ArrayList<T>();
    }

    public void set(ArrayList<T> arrayList) {
        mArrayList.clear();
        mArrayList.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void add(T data) {
        mArrayList.add(data);
        notifyDataSetChanged();
    }

    public void addAll(ArrayList<T> arrayList) {
        mArrayList.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void clear() {
        mArrayList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return mArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public abstract View getView(int i, View view, ViewGroup viewGroup);
}
