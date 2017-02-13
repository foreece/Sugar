package com.reece.sugar;

import com.reece.network.HttpManagerFactory;
import com.reece.network.IHttpManager;
import com.reece.network.http.HttpError;
import com.reece.network.http.HttpRequest;
import com.reece.network.http.HttpResponse;
import com.reece.network.http.IHttpCallback;

/**
 * Created by foreece@gmail.com on 17-2-10.
 */

public class Test {
    public static void test1() {
        String baseUrl = "https://api.github.com";
        IHttpManager manager = HttpManagerFactory.createRetrofitHttpManager();
        manager.request(new HttpRequest(baseUrl, baseUrl + "/google/repos", new IHttpCallback() {
            @Override
            public void onSuccess(HttpResponse response) {

            }

            @Override
            public void onError(HttpError httpError) {

            }
        }));
    }
}
