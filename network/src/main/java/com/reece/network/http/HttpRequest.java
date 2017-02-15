package com.reece.network.http;

import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
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
    private long mTimeout; //SECOND
    private Map<String, String> mRequestParams = new HashMap<String, String>();
    private Map<String, String> mHeaderMap = new HashMap<String, String>();
    private Converter.Factory mConvertFactory = GsonConverterFactory.create(
            new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                    .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC, Modifier.PRIVATE)
                    .serializeNulls()
                    .create());

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

    public Map<String, String> getHeaderMap() {
        return mHeaderMap;
    }

    public long getTimeout() {
        return mTimeout;
    }


    public void setConvertFactory(Converter.Factory convertFactory) {
        this.mConvertFactory = convertFactory;
    }

    public void setmHttpMethod(int httpMethod) {
        this.mHttpMethod = httpMethod;
    }

    public void setHeaderMap(Map<String, String> headerMap) {
        this.mHeaderMap.putAll(headerMap);
    }

    public void addHeader(String key, String value) {
        this.mHeaderMap.put(key, value);
    }

    public void setTimeout(long mTimeout) {
        this.mTimeout = mTimeout;
    }
}
