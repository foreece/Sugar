package com.reece.sugar;

import android.util.Log;

import com.reece.network.RequestFetcher;
import com.reece.network.config.NetConfigFactory;
import com.reece.network.config.NetworkConfig;
import com.reece.network.http.HttpError;
import com.reece.network.http.HttpRequest;
import com.reece.network.http.HttpResponse;
import com.reece.network.http.fetcher.SimpleFetchContext;
import com.reece.network.parser.ParserFactory;

import okhttp3.FormBody;

/**
 * Created by foreece@gmail.com on 17-2-10.
 */

public class Test {
    private static final String TAG = "Test";
    public static void testGet() {
        String baseUrl = "https://api.github.com/users/foreece/repos";
        NetworkConfig config = new NetworkConfig.Builder()
                .build();
        final HttpRequest request = new HttpRequest.Builder(baseUrl)
                .setMethod(HttpRequest.Method.GET)
                .build();
        final SimpleFetchContext<String> fetchContext = SimpleFetchContext.create(request, ParserFactory.getStringParser());
        config.getRequestFetcher().fetch(fetchContext, new RequestFetcher.Callback() {
            @Override
            public void onResponse(HttpResponse response) {
                String data = fetchContext.parseData(response.getInputStream());
                Log.i(TAG, "onResponse() "+data);
            }

            @Override
            public void onFailure(HttpError error) {
                Log.i(TAG, "onFailure() ");
            }
        });
    }

    public static void testPost() {
        String baseUrl = "http://192.168.99.239:8282/vars/list";
        final HttpRequest request = new HttpRequest.Builder(baseUrl)
                .setMethod(HttpRequest.Method.POST)
                .setRequestBody(new FormBody.Builder()
                        //.add("username", "foreece@gmail.com")
                        .add("username", "就这样")
                        .build())
                .build();
        SimpleFetchContext<String> context = SimpleFetchContext.create(request, ParserFactory.getStringParser());
        NetConfigFactory.getDefault().getRequestFetcher().fetch(context, new RequestFetcher.Callback() {
            @Override
            public void onResponse(HttpResponse response) {
                String data = context.parseData(response.getInputStream());
                Log.i(TAG, "onResponse() "+data);
            }

            @Override
            public void onFailure(HttpError error) {

            }
        });
    }
}
