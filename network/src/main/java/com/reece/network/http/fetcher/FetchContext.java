package com.reece.network.http.fetcher;

import com.reece.network.http.HttpRequest;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/15/17
 * @Description
 */

public interface FetchContext {
    HttpRequest getRequest();
    String getUrl();
}
