package com.reece.network.http;

/**
 * Created by foreece@gmail.com on 17-2-10.
 *
 */

public interface IHttpCallback<T> {
    void onSuccess(HttpResponse<T> response);
    void onError(HttpError httpError);
}
