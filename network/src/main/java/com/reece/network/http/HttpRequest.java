package com.reece.network.http;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/15/17
 * @Description
 */

public class HttpRequest {
    private String mRequestUrl;
    private String mMethod = Method.GET;
    private RequestBody mRequestBody;

    public HttpRequest(Builder builder){
        this.mMethod = builder.mMethod;
        this.mRequestBody = builder.mRequestBody;
        this.mRequestUrl = builder.mRequestUrl;
    }

    public String getUrl() {
        return mRequestUrl;
    }
    public String getMethod() {
        return mMethod;
    }

    public RequestBody getRequestBody() {
        return mRequestBody;
    }

    public static class Builder {
        private String mRequestUrl;
        private String mMethod = Method.GET;
        //set default RequestBody
        private RequestBody mRequestBody = new FormBody.Builder().build();

        public Builder(String requestUrl) {
            this.mRequestUrl = requestUrl;
        }

        public Builder setMethod(String method) {
            this.mMethod = method;
            return this;
        }

        public Builder setRequestBody(RequestBody requestBody) {
            this.mRequestBody = requestBody;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }

    public static class Method {
        public static final String GET = "GET";
        public static final String POST = "POST";
    }
}
