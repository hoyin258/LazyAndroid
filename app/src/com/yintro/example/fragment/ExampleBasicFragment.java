package com.yintro.example.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yintro.lazyandroid.app.R;
import com.yintro.lazyandroid.app.fragment.BaseFragment;

/**
 * Created by hoyin on 11/5/14.
 * Yintro.com
 */
public class ExampleBasicFragment extends BaseFragment {
    protected TextView tvTitle;
    protected Button btnHello;

    @Override
    protected void assignViews() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        btnHello = (Button) findViewById(R.id.btnHello);
    }

    @Override
    protected void setListeners() {
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                say("hello");
            }
        });
    }

    @Override
    protected void init() {

    }

    @Override
    protected void getData() {

    }

}
