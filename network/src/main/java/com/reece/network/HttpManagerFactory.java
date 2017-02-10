package com.reece.network;

import com.reece.network.retrofit.RetrofitHttpManager;

/**
 * Created by foreece@gmail.com on 17-2-10.
 */

public class HttpManagerFactory {

    public static IHttpManager createRetrofitHttpManager() {
        return RetrofitHttpManager.getInstance();
    }
}
