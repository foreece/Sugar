package com.reece.network.http;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;

/**
 * Created by foreece@gmail.com on 17-2-17.
 */

public class HttpRequest<T> {
    private String mHttpUrl;
    private Map<String, String> mParams;
    private Map<String, String> mHeaders = new HashMap<String, String>();
    private HttpMethod mHttpMethod = HttpMethod.GET;
    private IHttpListener<T> mHttpListener;
    private RequestBody mRequestBody;

    private HttpRequest(Builder<T> builder) {
        this.mHttpUrl = builder.mHttpUrl;
        this.mHttpListener = builder.mHttpListener;
        this.mParams = builder.mParams;
        this.mHttpMethod = builder.mHttpMethod;
        this.mHeaders = builder.mHeaders;
        this.mRequestBody = builder.mRequestBody;
    }

    public String getHttpUrl() {
        return mHttpUrl;
    }

    public Map<String, String> getParams() {
        return mParams;
    }

    public Map<String, String> getHeaders() {
        return mHeaders;
    }

    public HttpMethod getHttpMethod() {
        return mHttpMethod;
    }

    public IHttpListener<T> getHttpListener() {
        return mHttpListener;
    }

    public RequestBody getRequestBody() {
        return mRequestBody;
    }

    public static class Builder<T> {
        private String mHttpUrl;
        private Map<String, String> mParams = new HashMap<String, String>();
        private Map<String, String> mHeaders = new HashMap<String, String>();
        private HttpMethod mHttpMethod = HttpMethod.GET;
        private IHttpListener<T> mHttpListener;
        private RequestBody mRequestBody;

        public Builder(String httpUrl) {
            this.mHttpUrl = httpUrl;
        }

        public Builder<T> listener(IHttpListener<T> httpListener) {
            this.mHttpListener = httpListener;
            return this;
        }

        public Builder<T> method(HttpMethod httpMethod) {
            this.mHttpMethod = httpMethod;
            return this;
        }

        public Builder<T> addHeader(String key, String value) {
            this.mHeaders.put(key, value);
            return this;
        }

        public Builder<T> addParam(String key, String value) {
            this.mParams.put(key, value);
            return this;
        }

        public Builder<T> requestBody(RequestBody requestBody) {
            this.mRequestBody = requestBody;
            return this;
        }

        public HttpRequest<T> build() {
            return new HttpRequest<T>(this);
        }
    }
}
