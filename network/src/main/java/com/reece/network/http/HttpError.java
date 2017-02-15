package com.reece.network.http;

/**
 * Created by foreece@gmail.com on 17-2-10.
 */

public class HttpError {

    private String mErrorMessage;
    private int mErrorCode;

    public HttpError(String errorMessage, int errorCode) {
        this.mErrorMessage = errorMessage;
        this.mErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    @Override
    public String toString() {
        return "HttpError: mErrorMessage="+mErrorMessage+", mErrorCode"+mErrorCode;
    }
}
