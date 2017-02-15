package com.reece.sugar.common;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Kevin
 * @version V1.0
 * @Date 7/17/16
 * @Description
 */
public class ToastUtil {
    private static Toast instanceShort = null;
    private static Toast instanceLong = null;

    public ToastUtil() {
    }

    public static void ToastShort(Context mContext, String content) {
        if(instanceLong != null) {
            instanceLong.cancel();
        }

        if(instanceShort == null) {
            instanceShort = Toast.makeText(mContext, content, Toast.LENGTH_SHORT);
        } else {
            instanceShort.setText(content);
        }

        instanceShort.show();
    }

    public static void ToastLong(Context mContext, String content) {
        if(instanceShort != null) {
            instanceShort.cancel();
        }

        if(instanceLong == null) {
            instanceLong = Toast.makeText(mContext, content, Toast.LENGTH_LONG);
        } else {
            instanceLong.setText(content);
        }

        instanceLong.show();
    }

    public static void ToastShort(Context mContext, int resId) {
        ToastShort(mContext, mContext.getResources().getString(resId));
    }

    public static void ToastLong(Context mContext, int resId) {
        ToastLong(mContext, mContext.getResources().getString(resId));
    }
}

