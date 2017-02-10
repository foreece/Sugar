package com.reece.network;

import com.reece.network.http.IHttpCallback;

import java.util.Map;

/**
 * Created by foreece@gmail.com on 17-2-10.
 *
 */

public interface IHttpManager {
    void get(String url, Map<String, String> params, String time, IHttpCallback callback);
    void post(String url, Map<String, String> params, String time, IHttpCallback callback);
}
