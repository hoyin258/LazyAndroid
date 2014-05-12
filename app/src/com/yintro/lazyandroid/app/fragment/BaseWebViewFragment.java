package com.yintro.lazyandroid.app.fragment;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.yintro.lazyandroid.app.R;

/**
 * Created by hoyin on 11/5/14.
 * Yintro.com
 */
public abstract class BaseWebViewFragment extends BaseFragment {

    public static final String KEY_URL = "url";

    protected WebView wvContent;
    protected ProgressBar pgWeb;

    protected void assignViews() {
        wvContent = (WebView) findViewById(R.id.wvContent);
        pgWeb = (ProgressBar) findViewById(R.id.pgWeb);

    }

    @Override
    protected void setListeners() {
        wvContent.setInitialScale(1);
        wvContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.endsWith(".pdf")) {
                    String googleDocs = "https://docs.google.com/viewer?url=";
                    view.loadUrl(googleDocs + url);
                    return true;
                } else {
                    return super.shouldOverrideUrlLoading(view, url);
                }
            }
        });
        wvContent.setWebChromeClient(new WebChromeClient() {
        });

    }

    @Override
    protected void init() {
        WebSettings settings = wvContent.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setPluginState(WebSettings.PluginState.ON);
    }

    @Override
    protected void getData() {
        Bundle arguments = getArguments();
        String url = arguments.getString(KEY_URL);
        wvContent.loadUrl(url);
    }

    @Override
    public boolean onBackPressed() {
        if (wvContent.canGoBack()) {
            wvContent.goBack();
            return true;
        }
        return false;
    }
}