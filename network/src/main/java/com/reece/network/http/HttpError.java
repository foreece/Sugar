package com.reece.network.http;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/17/17
 * @Description
 */

public class HttpError {
    private String mErrorMessage;
    private int mErrorCode;

    public HttpError(int mErrorCode) {
        this.mErrorCode = mErrorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.mErrorMessage = errorMessage;
    }

    public static HttpError createSimpleNetError() {
        HttpError error = new HttpError(0);
        error.setErrorMessage("network error");
        return error;
    }
}
