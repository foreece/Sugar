package com.reece.network;

import android.util.Log;

/**
 * Created by foreece@gmail.com on 17-2-10.
 * Log util.
 */

public class NLog {

    public static boolean isDebug = NetworkConfig.IS_DEBUG;
    private static final String TAG = "NetWork";

    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(TAG, tag + ": " + msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.i(TAG, tag + ": " + msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.i(TAG, tag + ": " + msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(TAG, tag + ": " + msg);
    }
}
