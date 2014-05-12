package com.yintro.example.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yintro.lazyandroid.app.R;
import com.yintro.lazyandroid.app.activity.BaseActivity;


public class ExampleBasicMainActivity extends BaseActivity {


    protected TextView tvTitle;
    protected Button btnHello;

    protected void assignViews() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        btnHello = (Button) findViewById(R.id.btnHello);
    }


    @Override
    protected void setListeners() {
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                say("Hello");
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
