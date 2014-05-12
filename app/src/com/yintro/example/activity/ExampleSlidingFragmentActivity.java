package com.yintro.example.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yintro.example.adapter.ExampleSlidingMenuAdapter;
import com.yintro.example.fragment.ExampleBasicFragment;
import com.yintro.lazyandroid.app.R;
import com.yintro.lazyandroid.app.activity.BaseSlidingFragmentActivity;

import java.util.ArrayList;

/**
 * Created by hoyin on 11/5/14.
 * Yintro.com
 */
public class ExampleSlidingFragmentActivity extends BaseSlidingFragmentActivity {

    protected LinearLayout vgContent;
    protected TextView tvTitle;
    protected Button btnHello;
    protected ExpandableListView elvMenu;

    protected ExampleSlidingMenuAdapter slidingMenuAdapter;

    @Override
    public Fragment getDefaultFragment() {
        return new ExampleBasicFragment();
    }

    @Override
    protected void assignViews() {
        vgContent = (LinearLayout) findViewById(R.id.content);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        btnHello = (Button) findViewById(R.id.btnHello);
        elvMenu = (ExpandableListView) findViewById(R.id.elvMenu);
    }

    @Override
    protected void setListeners() {
        elvMenu.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                say("Group click");
                return true;
            }
        });

        elvMenu.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long l) {
                say("Child click");
                return true;
            }
        });
    }

    @Override
    protected void init() {
        slidingMenuAdapter = new ExampleSlidingMenuAdapter(mContext);
        slidingMenuAdapter.setData(getMenuGroup(), getMenuChild());
        elvMenu.setAdapter(slidingMenuAdapter);
        for (int i = 0; i < slidingMenuAdapter.getGroupCount(); i++) {
            elvMenu.expandGroup(i);
        }
    }

    @Override
    protected void getData() {

    }

    private ArrayList<Bundle> getMenuGroup() {
        ArrayList<Bundle> groups = new ArrayList<Bundle>();
        for (int i = 0; i < 10; i++) {
            Bundle bundle = new Bundle();
            bundle.putString("title", "group" + i);
            groups.add(bundle);
        }
        return groups;
    }

    private ArrayList<ArrayList<Bundle>> getMenuChild() {
        ArrayList<ArrayList<Bundle>> allChilds = new ArrayList<ArrayList<Bundle>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Bundle> childs = new ArrayList<Bundle>();
            for (int j = 0; j < 10; j++) {
                Bundle bundle = new Bundle();
                bundle.putString("title", "group" + i+", child"+j);
                childs.add(bundle);
            }
            allChilds.add(childs);
        }
        return allChilds;
    }
}
