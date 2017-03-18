package com.reece.network.config;

import com.reece.network.RequestFetcher;
import com.reece.network.http.fetcher.FetchContext;
import com.reece.network.http.fetcher.FetcherFactory;
import com.reece.network.http.fetcher.ok.OkHttpFetcherFactory;
import com.reece.network.util.DebugHelper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/15/17
 * @Description
 */

public class NetworkConfig {
    private FetcherFactory mFetcherFactory;
    private RequestFetcher<FetchContext> mRequestFetcher;

    private NetworkConfig(Builder builder) {
        this.mFetcherFactory = builder.mFetcherFactory;
        mRequestFetcher = this.mFetcherFactory.getRequestFetcher();
    }

    public RequestFetcher<FetchContext> getRequestFetcher() {
        return mRequestFetcher;
    }

    public static class Builder{
        private FetcherFactory mFetcherFactory;

        public Builder setFetcherFactory(FetcherFactory factory) {
            this.mFetcherFactory = factory;
            return this;
        }

        public NetworkConfig build() {
            if (mFetcherFactory == null) {
                //the default factory is OkHttp
                OkHttpClient.Builder builder = new OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS);
                if (DebugHelper.isDebugBuild()) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                    builder.addInterceptor(interceptor);
                }
                mFetcherFactory = new OkHttpFetcherFactory(builder.build());
            }
            return new NetworkConfig(this);
        }
    }
}
