package com.reece.network;

import com.reece.network.ok.OkHttpManager;

/**
 * Created by foreece@gmail.com on 17-2-17.
 */

public class HttpManagerFactory {
    public static IHttpManager createOkHttpManager() {
        return OkHttpManager.get();
    }
}
