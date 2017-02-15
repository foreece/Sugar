package com.reece.network.retrofit;

import com.reece.network.DebugHelper;
import com.reece.network.IHttpManager;
import com.reece.network.NLog;
import com.reece.network.http.HttpError;
import com.reece.network.http.HttpRequest;
import com.reece.network.http.HttpResponse;
import com.reece.network.http.IHttpCallback;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by foreece@gmail.com on 17-2-10.
 * The Retrofit implement of HttpManager.
 *
 */

public class RetrofitHttpManager implements IHttpManager {

    private static final String TAG = "RetrofitHttpManager";
    private Map<String, Retrofit> RETROFITS = new HashMap<String, Retrofit>();
    private static IHttpManager INSTANCE = new RetrofitHttpManager();

    private RetrofitHttpManager() {

    }

    public static IHttpManager get() {
        return INSTANCE;
    }

    @Override
    public void request(HttpRequest request) {
        NLog.i(TAG, "request() " + request.toString());
        Retrofit retrofit = getRetrofit(request);
        RetrofitHttpService retrofitHttpService = retrofit.create(RetrofitHttpService.class);
        final IHttpCallback callback = request.getHttpCallback();
        requestInternal(request, retrofitHttpService).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (callback != null) {
                    HttpResponse response1 = new HttpResponse();
                    response1.data = response.body();
                    callback.onSuccess(response1);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                if (callback != null) {
                    HttpError error = new HttpError(t.getMessage(),  0);
                    callback.onError(error);
                }
            }
        });
    }

    protected Retrofit getRetrofit(HttpRequest request) {
        String baseUrl = request.getBaseUrl();
        Retrofit retrofit = RETROFITS.get(baseUrl);
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(request.getTimeout(), TimeUnit.SECONDS);
            if (DebugHelper.isDebugBuild()) {
                builder.addInterceptor(getHttpLogInterceptor());
            }
            OkHttpClient client = builder.build();
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(request.getConvertFactory())
                    .build();
            RETROFITS.put(baseUrl, retrofit);
        }
        return retrofit;
    }

    protected HttpLoggingInterceptor getHttpLogInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    protected Call requestInternal(HttpRequest request, RetrofitHttpService retrofitHttpService) {
        Call call;
        switch (request.getHttpMethod()) {
            case HttpRequest.HTTP_GET:
                call = retrofitHttpService.get(request.getUrl(), request.getRequestParams(), request.getHeaderMap());
                break;
            case HttpRequest.HTTP_POST:
                call = retrofitHttpService.post(request.getUrl(), request.getRequestParams(), request.getHeaderMap());
                break;
            default:
                throw new RuntimeException("not support http method.");
        }
        return call;
    }
}
