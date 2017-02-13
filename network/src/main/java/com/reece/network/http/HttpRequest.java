package com.reece.network.http;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by foreece@gmail.com on 17-2-13.
 */

public class HttpRequest<T> {

    public static final int HTTP_GET = 0;
    public static final int HTTP_POST = 1;

    private String mBaseUrl;
    private String mUrl;
    private IHttpCallback<T> mHttpCallback;
    private int mHttpMethod = HTTP_GET;
    private String mCacheTime = "0";
    private Map<String, String> mRequestParams = new HashMap<String, String>();
    private Converter.Factory mConvertFactory = GsonConverterFactory.create();

    public HttpRequest(String baseUrl, String url, IHttpCallback<T> httpCallback) {
        this.mBaseUrl = baseUrl;
        this.mUrl = url;
        this.mHttpCallback = httpCallback;
    }

    public String getUrl() {
        return mUrl;
    }

    public IHttpCallback<T> getHttpCallback() {
        return mHttpCallback;
    }

    public void addRequestParam(String key, String value) {
        mRequestParams.put(key, value);
    }

    public void addRequestParams(Map<String, String> params) {
        mRequestParams.putAll(params);
    }

    public String getBaseUrl() {
        return mBaseUrl;
    }

    public Converter.Factory getConvertFactory() {
        return mConvertFactory;
    }

    public int getHttpMethod() {
        return mHttpMethod;
    }

    public Map<String, String> getRequestParams() {
        return mRequestParams;
    }

    public String getCacheTime() {
        return mCacheTime;
    }

    public void setConvertFactory(Converter.Factory convertFactory) {
        this.mConvertFactory = convertFactory;
    }

    public void setmHttpMethod(int httpMethod) {
        this.mHttpMethod = httpMethod;
    }
}
