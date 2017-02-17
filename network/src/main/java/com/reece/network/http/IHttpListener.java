package com.reece.network.http;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/17/17
 * @Description
 */

public interface IHttpListener<T> {
    void onSuccess(HttpResponse<T> response);
    void onError(HttpError error);
}
