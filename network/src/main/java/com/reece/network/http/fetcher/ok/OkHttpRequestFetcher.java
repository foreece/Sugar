package com.reece.network.http.fetcher.ok;

import com.reece.network.http.HttpError;
import com.reece.network.http.HttpResponse;
import com.reece.network.http.fetcher.BaseRequestFetcher;
import com.reece.network.http.fetcher.FetchContext;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/15/17
 * @Description
 */

public class OkHttpRequestFetcher extends BaseRequestFetcher {
    private static final String TAG = "OkHttpRequestFetcher";
    private final OkHttpClient mOkHttpClient;
    public OkHttpRequestFetcher(OkHttpClient okHttpClient) {
        mOkHttpClient = okHttpClient;
    }
    @Override
    public void fetch(final FetchContext context, final Callback callback) {
        Request request = new Request.Builder()
                .url(context.getUrl())
                .method(context.getRequest().getMethod(), context.getRequest().getRequestBody())
                .build();
        final Call call = mOkHttpClient.newCall(request);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(HttpError.createSimpleNetError());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    HttpResponse httpResponse = new HttpResponse(response.body().byteStream());
                    httpResponse.setContentLength(response.body().contentLength());
                    httpResponse.setResponseCode(response.code());
                    callback.onResponse(httpResponse);
                } else {
                    callback.onFailure(HttpError.createSimpleNetError());
                }
            }
        });
    }
}
