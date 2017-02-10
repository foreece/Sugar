package com.reece.network.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by foreece@gmail.com on 17-2-10.
 * a common retrofit interface of http
 */

public interface RetrofitHttpService<T> {

    @GET()
    Call<T> get(@Url String url, @QueryMap Map<String, String> params, @Header("Cache-Time") String time);

    @FormUrlEncoded
    @POST()
    Call<T> post(@Url String url, @FieldMap Map<String, String> params, @Header("Cache-Time") String time);

}
