package com.yintro.example.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.TextView;

import com.yintro.lazyandroid.app.R;
import com.yintro.lazyandroid.app.view.BaseView;

/**
 * Created by hoyin on 12/5/14.
 * Yintro.com
 */
public class ExampleSlidingMenuGroupView extends BaseView {

    protected TextView tvMenuGroup;

    public ExampleSlidingMenuGroupView(Context context) {
        super(context);
    }

    public ExampleSlidingMenuGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExampleSlidingMenuGroupView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void assignViews() {
        tvMenuGroup = (TextView) findViewById(R.id.tvMenuGroup);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void init() {

    }

    @Override
    protected void getData() {

    }

    @Override
    public void parse(Object object) {
        Bundle value= (Bundle) object;
        tvMenuGroup.setText(value.getString("title"));
    }
}
