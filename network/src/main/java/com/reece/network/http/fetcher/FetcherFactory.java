package com.reece.network.http.fetcher;

import com.reece.network.RequestFetcher;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/15/17
 * @Description
 */

public interface FetcherFactory {
    RequestFetcher<FetchContext> getRequestFetcher();
}
