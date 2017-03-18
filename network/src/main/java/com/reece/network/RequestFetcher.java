package com.reece.network;

import com.reece.network.http.HttpError;
import com.reece.network.http.HttpResponse;

/**
 * Created by foreece@gmail.com on 17-2-17.
 * This
 */

public interface RequestFetcher<T> {

    interface Callback {
        void onResponse(HttpResponse response);
        void onFailure(HttpError error);
    }

    void fetch(T context, Callback callback);
}
