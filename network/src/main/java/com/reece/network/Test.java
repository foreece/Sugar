package com.reece.network;

import com.reece.network.http.HttpError;
import com.reece.network.http.IHttpCallback;
import com.reece.network.http.HttpResponse;

/**
 * Created by foreece@gmail.com on 17-2-10.
 */

public class Test {
    public static void test() {
        HttpManagerFactory.createRetrofitHttpManager().get(null, null, null, new IHttpCallback<String>(){

            @Override
            public void onSuccess(HttpResponse<String> response) {

            }

            @Override
            public void onError(HttpError httpError) {

            }
        });
    }
}
