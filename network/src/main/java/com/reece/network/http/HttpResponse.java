package com.reece.network.http;

import java.io.InputStream;

/**
 * Created by foreece@gmail.com on 17-2-17.
 */

public class HttpResponse {
    private static final String TAG = "HttpResponse";
    private InputStream mInputStream;
    private int mResponseCode;
    private long mContentLength;

    public HttpResponse(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    public void setResponseCode(int responseCode) {
        this.mResponseCode = responseCode;
    }

    public void setContentLength(long contentLength) {
        this.mContentLength = contentLength;
    }

    public InputStream getInputStream() {
        return mInputStream;
    }
}
