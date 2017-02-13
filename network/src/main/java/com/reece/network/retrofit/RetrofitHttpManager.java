package com.reece.network.retrofit;

import com.reece.network.IHttpManager;
import com.reece.network.Repo;
import com.reece.network.http.HttpError;
import com.reece.network.http.HttpRequest;
import com.reece.network.http.HttpResponse;
import com.reece.network.http.IHttpCallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        String baseUrl = request.getBaseUrl();
        Retrofit retrofit = RETROFITS.get(baseUrl);
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(request.getConvertFactory())
                    .build();
            RETROFITS.put(baseUrl, retrofit);
        }
        RetrofitHttpService retrofitHttpService = retrofit.create(RetrofitHttpService.class);
        Call<List<Repo>> call;
        switch (request.getHttpMethod()) {
            case HttpRequest.HTTP_GET:
                call = retrofitHttpService.get(request.getUrl(), request.getRequestParams(), request.getCacheTime());
                break;
            case HttpRequest.HTTP_POST:
                call = retrofitHttpService.post(request.getUrl(), request.getRequestParams(), request.getCacheTime());
                break;
            default:
                throw new RuntimeException("not support http method.");
        }
        final IHttpCallback callback = request.getHttpCallback();
        call.enqueue(new Callback() {
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
                    HttpError error = new HttpError();
                    callback.onError(error);
                }
            }
        });
    }
}
