package com.yintro.lazyandroid.app.helper;

import android.content.Context;

/**
 * Created by hoyin on 10/5/14.
 * Yintro.com
 */
public class YintroHelper {

    public static int getLayoutIdFromName(Context context , String type, String name){
        String layoutName = type +"_" + name.replaceAll("(.)(\\p{Lu})", "$1_$2").toLowerCase();
        return context.getResources().getIdentifier(layoutName, "layout", context.getPackageName());
    }

}
