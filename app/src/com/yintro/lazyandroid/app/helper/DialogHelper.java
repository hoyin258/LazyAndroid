package com.yintro.lazyandroid.app.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by hoyin on 11/5/14.
 * Yintro.com
 */
public class DialogHelper {

    public static void showListDialog(
            Context context,
            String title,
            CharSequence[] items,
            DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setItems(items, onClickListener);
        AlertDialog alert = builder.create();
        alert.show();
    }


    public void showDecisionMsg(
            Context context,
            String title,
            String msg,
            String posName,
            DialogInterface.OnClickListener onClickListener1,
            String negName,
            DialogInterface.OnClickListener onClickListener2,
            boolean cancelable) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setCancelable(cancelable)
                .setPositiveButton(posName, onClickListener1)
                .setNegativeButton(negName, onClickListener2)
                .create()
                .show();
    }

    public void showAlertMsg(Context context,
                             String title,
                             String msg,
                             String posName,
                             DialogInterface.OnClickListener onClickListener,
                             boolean cancelable) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setCancelable(cancelable)
                .setPositiveButton(posName, onClickListener)
                .create()
                .show();
    }

    public void showAlertMsg(Context context,
                             String title,
                             String msg,
                             String posName) {
        showAlertMsg(context, title, msg, posName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }, false);
    }
}
