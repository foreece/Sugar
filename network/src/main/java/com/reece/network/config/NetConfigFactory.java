package com.reece.network.config;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/18/17
 * @Description
 */

public class NetConfigFactory {
    private static NetworkConfig mDefaultNetworkConfig;
    public static NetworkConfig getDefault() {
        if (mDefaultNetworkConfig == null) {
            mDefaultNetworkConfig = new NetworkConfig.Builder().build();
        }
        return mDefaultNetworkConfig;
    }
}
