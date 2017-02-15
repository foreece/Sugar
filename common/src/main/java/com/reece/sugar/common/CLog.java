package com.reece.sugar.common;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by foreece@gmail.com on 17-2-15.
 */

public class CLog {
    /**
     * Priority constant for the println method; use Log.v.
     */
    public static final int VERBOSE = 2;

    /**
     * Priority constant for the println method; use Log.d.
     */
    public static final int DEBUG = 3;

    /**
     * Priority constant for the println method; use Log.i.
     */
    public static final int INFO = 4;

    /**
     * Priority constant for the println method; use Log.w.
     */
    public static final int WARN = 5;

    /**
     * Priority constant for the println method; use Log.e.
     */
    public static final int ERROR = 6;

    /**
     * Priority constant for the println method.
     */
    public static final int ASSERT = 7;

    private static String defaultTag = "Common";
    private static Boolean isDebugMode = null;

    private CLog() {
    }

    private static boolean isDebug() {
        return Log.isLoggable(defaultTag, Log.VERBOSE) || isDebugBuild();
    }

    public static void setTag(String tag) {
        defaultTag = tag;
    }

    public static int i(Object o) {
        return isDebug() && o != null ? Log.i(defaultTag, o.toString()) : -1;
    }

    public static int i(String m) {
        return isDebug() && m != null ? Log.i(defaultTag, m) : -1;
    }

    public static int d(String m) {
        return isDebug() && m != null ? Log.d(defaultTag, m) : -1;
    }

    public static int e(String m) {
        return isDebug() && m != null ? Log.e(defaultTag, m) : -1;
    }

    public static int w(String m) {
        return isDebug() && m != null ? Log.w(defaultTag, m) : -1;
    }

    public static int v(String m) {
        return isDebug() && m != null ? Log.v(defaultTag, m) : -1;
    }

    /**
     * ******************** Log **************************
     */
    public static int v(String tag, String msg) {
//        return isDebug() && msg != null ? Log.v(tag, msg) : -1;
        return isDebug() && msg != null ? v("[" + tag + "] " + msg) : -1;
    }

    public static int d(String tag, String msg) {
//        return isDebug() && msg != null ? Log.d(tag, msg) : -1;
        return isDebug() && msg != null ? d("[" + tag + "] " + msg) : -1;
    }

    public static int i(String tag, String msg) {
//        return isDebug() && msg != null ? Log.i(tag, msg) : -1;
        return isDebug() && msg != null ? i("[" + tag + "] " + msg) : -1;
    }

    public static int w(String tag, String msg) {
//        return isDebug() && msg != null ? Log.w(tag, msg) : -1;
        return isDebug() && msg != null ? w("[" + tag + "] " + msg) : -1;
    }

    public static int e(String tag, String msg) {
//        return isDebug() && msg != null ? Log.e(tag, msg) : -1;
        return isDebug() && msg != null ? e("[" + tag + "] " + msg) : -1;
    }

    /**
     * ******************** Log with object list **************************
     */
    public static int v(String tag, Object... msg) {
//        return isDebug() ? Log.v(tag, getLogMessage(msg)) : -1;
        return isDebug() && msg != null ? v("[" + tag + "] " + getLogMessage(msg)) : -1;
    }

    public static int d(String tag, Object... msg) {
//        return isDebug() ? Log.d(tag, getLogMessage(msg)) : -1;
        return isDebug() && msg != null ? d("[" + tag + "] " + getLogMessage(msg)) : -1;
    }

    public static int i(String tag, Object... msg) {
//        return isDebug() ? Log.i(tag, getLogMessage(msg)) : -1;
        return isDebug() && msg != null ? i("[" + tag + "] " + getLogMessage(msg)) : -1;
    }

    public static int w(String tag, Object... msg) {
//        return isDebug() ? Log.w(tag, getLogMessage(msg)) : -1;
        return isDebug() && msg != null ? w("[" + tag + "] " + getLogMessage(msg)) : -1;
    }

    public static int e(String tag, Object... msg) {
//        return isDebug() ? Log.e(tag, getLogMessage(msg)) : -1;
        return isDebug() && msg != null ? e("[" + tag + "] " + getLogMessage(msg)) : -1;
    }

    private static String getLogMessage(Object... msg) {
        if (msg != null && msg.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (Object s : msg) {
                if (msg != null && s != null) sb.append(s.toString());
            }
            return sb.toString();
        }
        return "";
    }

    /**
     * ******************** Log with Throwable **************************
     */
    public static int v(String tag, String msg, Throwable tr) {
//        return isDebug() && msg != null ? Log.v(tag, msg, tr) : -1;
        return isDebug() && msg != null ? Log.v(defaultTag, "[" + tag + "] " + msg, tr) : -1;
    }

    public static int d(String tag, String msg, Throwable tr) {
//        return isDebug() && msg != null ? Log.d(tag, msg, tr) : -1;
        return isDebug() && msg != null ? Log.d(defaultTag, "[" + tag + "] " + msg, tr) : -1;
    }

    public static int i(String tag, String msg, Throwable tr) {
//        return isDebug() && msg != null ? Log.i(tag, msg, tr) : -1;
        return isDebug() && msg != null ? Log.i(defaultTag, "[" + tag + "] " + msg, tr) : -1;
    }

    public static int w(String tag, String msg, Throwable tr) {
//        return isDebug() && msg != null ? Log.w(tag, msg, tr) : -1;
        return isDebug() && msg != null ? Log.w(defaultTag, "[" + tag + "] " + msg, tr) : -1;
    }

    public static int e(String tag, String msg, Throwable tr) {
//        return isDebug() && msg != null ? Log.e(tag, msg, tr) : -1;
        return isDebug() && msg != null ? Log.e(defaultTag, "[" + tag + "] " + msg, tr) : -1;
    }

    /**
     * ******************** TAG use Object Tag **************************
     */
    public static int v(Object tag, String msg) {
//        return isDebug() ? Log.v(tag.getClass().getSimpleName(), msg) : -1;
        return isDebug() ? Log.v(defaultTag, "[" + tag.getClass().getSimpleName() + "] " + msg) : -1;
    }

    public static int d(Object tag, String msg) {
//        return isDebug() ? Log.d(tag.getClass().getSimpleName(), msg) : -1;
        return isDebug() ? Log.d(defaultTag, "[" + tag.getClass().getSimpleName() + "] " + msg) : -1;
    }

    public static int i(Object tag, String msg) {
//        return isDebug() ? Log.i(tag.getClass().getSimpleName(), msg) : -1;
        return isDebug() ? Log.i(defaultTag, "[" + tag.getClass().getSimpleName() + "] " + msg) : -1;
    }

    public static int w(Object tag, String msg) {
//        return isDebug() ? Log.w(tag.getClass().getSimpleName(), msg) : -1;
        return isDebug() ? Log.w(defaultTag, "[" + tag.getClass().getSimpleName() + "] " + msg) : -1;
    }

    public static int e(Object tag, String msg) {
//        return isDebug() ? Log.e(tag.getClass().getSimpleName(), msg) : -1;
        return isDebug() ? Log.e(defaultTag, "[" + tag.getClass().getSimpleName() + "] " + msg) : -1;
    }

    /**
     * 判断app的build模式
     *
     * @return 如果app是 debug build 则返回true，release build 返回false.
     */
    public static boolean isDebugBuild() {
        if (isDebugMode != null)
            return isDebugMode;

        try {
            final Class<?> activityThread = Class.forName("android.app.ActivityThread");
            final Method currentPackage = activityThread.getMethod("currentPackageName");
            final String packageName = (String) currentPackage.invoke(null, (Object[]) null);
            final Class<?> buildConfig = Class.forName(packageName + ".BuildConfig");
            final Field DEBUG = buildConfig.getField("DEBUG");
            DEBUG.setAccessible(true);
            isDebugMode = DEBUG.getBoolean(null);
        } catch (final Throwable t) {
            final String message = t.getMessage();
            if (message != null && message.contains("BuildConfig")) {
                // Proguard obfuscated build. Most likely a production build.
                isDebugMode = false;
            } else {
                isDebugMode = true;
            }
        }
        return isDebugMode;
    }

    public static boolean isLoggable(String tag, int level) {
        return isDebug();
    }
}
