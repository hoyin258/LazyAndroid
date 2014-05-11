package com.yintro.lazyandroid.app;

import android.graphics.Bitmap;
import android.os.Environment;

import com.activeandroid.ActiveAndroid;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.io.File;

/**
 * Created by hoyin on 14/4/14.
 */
public class BaseApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader();
        initActiveAndroid();


    }
    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }


    protected void initActiveAndroid(){
        ActiveAndroid.initialize(this);
    }

    protected void initImageLoader() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.EXACTLY)
                .cacheOnDisk(true)
                .displayer(new FadeInBitmapDisplayer(200))
                .build();

        File cacheDir;
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            cacheDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        } else {
            cacheDir = getCacheDir();
        }
        ImageLoaderConfiguration.Builder configBuilder = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(2)
                .memoryCache(new WeakMemoryCache())
                .denyCacheImageMultipleSizesInMemory()
                .diskCache(new UnlimitedDiscCache(cacheDir))
                .defaultDisplayImageOptions(options);
        if (BuildConfig.DEBUG) {
            configBuilder.writeDebugLogs();
        }
        ImageLoader.getInstance().init(configBuilder.build());
    }
}