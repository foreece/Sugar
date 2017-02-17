package com.reece.sugar;

import com.reece.network.HttpManagerFactory;
import com.reece.network.IHttpManager;
import com.reece.network.http.HttpError;
import com.reece.network.http.HttpRequest;
import com.reece.network.http.HttpResponse;
import com.reece.network.http.IHttpListener;

/**
 * Created by foreece@gmail.com on 17-2-10.
 */

public class Test {
    public static void test1() {
//        String baseUrl = "https://api.github.com";
//        IHttpManager manager = HttpManagerFactory.createRetrofitHttpManager();
//        manager.request(new HttpRequest(baseUrl, baseUrl + "/users/foreece/repos", new IHttpCallback<List<Repo>>() {
//            @Override
//            public void onSuccess(HttpResponse<List<Repo>> response) {
//                List<Repo> repos = response.data;
//                Log.d("CHC", String.valueOf(repos.size()));
//            }
//
//            @Override
//            public void onError(HttpError httpError) {
//                Log.d("", httpError.toString());
//            }
//        }));
    }
    public static void test2() {
        String baseUrl = "https://api.github.com/users/foreece/repos";
        IHttpManager manager = HttpManagerFactory.createOkHttpManager();
        HttpRequest<String> request = new HttpRequest.Builder<String>(baseUrl)
                .listener(new IHttpListener<String>() {
                    @Override
                    public void onSuccess(HttpResponse<String> response) {

                    }

                    @Override
                    public void onError(HttpError error) {

                    }
                })
                .build();
        manager.request(request);
    }
}
