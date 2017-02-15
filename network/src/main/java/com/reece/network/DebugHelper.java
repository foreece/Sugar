package com.reece.network;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/15/17
 * @Description
 */

public class DebugHelper {

    private static Boolean isDebugMode;

    /**
     * 判断app的build模式
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
}
