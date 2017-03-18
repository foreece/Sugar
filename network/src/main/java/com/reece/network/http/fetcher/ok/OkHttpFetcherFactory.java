package com.reece.network.http.fetcher.ok;

import com.reece.network.RequestFetcher;
import com.reece.network.http.fetcher.FetchContext;
import com.reece.network.http.fetcher.FetcherFactory;

import okhttp3.OkHttpClient;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/15/17
 * @Description
 */

public class OkHttpFetcherFactory implements FetcherFactory {
    private final String TAG = getClass().getSimpleName();
    private RequestFetcher<FetchContext> sOkHttpRequestFetcher;
    private final OkHttpClient mOkHttpClient;
    public OkHttpFetcherFactory(OkHttpClient okHttpClient) {
        this.mOkHttpClient = okHttpClient;
    }
    @Override
    public RequestFetcher<FetchContext> getRequestFetcher() {
        if (sOkHttpRequestFetcher == null) {
            sOkHttpRequestFetcher = new OkHttpRequestFetcher(mOkHttpClient);
        }
        return sOkHttpRequestFetcher;
    }
}
