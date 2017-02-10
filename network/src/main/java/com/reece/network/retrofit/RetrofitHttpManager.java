package com.reece.network.retrofit;

import com.reece.network.IHttpManager;
import com.reece.network.http.HttpError;
import com.reece.network.http.HttpResponse;
import com.reece.network.http.IHttpCallback;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by foreece@gmail.com on 17-2-10.
 * The Retrofit implement of HttpManager.
 *
 */

public class RetrofitHttpManager implements IHttpManager {

    private static final String TAG = "RetrofitHttpManager";
    private static final RetrofitHttpManager INSTANCE = new RetrofitHttpManager();
    private Retrofit mRetrofit;

    private RetrofitHttpManager() {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public static RetrofitHttpManager getInstance() {
        return INSTANCE;
    }

    @Override
    public void get(String url, Map<String, String> params, String time, final IHttpCallback callback) {
        RetrofitHttpService service = mRetrofit.create(RetrofitHttpService.class);
        Call call = service.get(url, params, time);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                HttpResponse response1 = new HttpResponse();
                response1.data = response.body();
                callback.onSuccess(response1);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                callback.onError(new HttpError());
            }
        });
    }

    @Override
    public void post(String url, Map<String, String> params, String time, IHttpCallback callback) {

    }
}
