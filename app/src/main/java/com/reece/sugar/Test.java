package com.reece.sugar;

import com.google.gson.reflect.TypeToken;
import com.reece.network.HttpManagerFactory;
import com.reece.network.IHttpManager;
import com.reece.network.Repo;
import com.reece.network.http.HttpError;
import com.reece.network.http.HttpMethod;
import com.reece.network.http.HttpRequest;
import com.reece.network.http.HttpResponse;
import com.reece.network.http.IHttpListener;
import com.reece.network.http.parser.JsonParser;
import com.reece.sugar.common.CLog;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by foreece@gmail.com on 17-2-10.
 */

public class Test {
    private static final String TAG = "Test";
    public static void test2() {
        String baseUrl = "https://api.github.com/users/foreece/repos";
        IHttpManager manager = HttpManagerFactory.createOkHttpManager();
        HttpRequest<List<Repo>> request = new HttpRequest.Builder<List<Repo>>(baseUrl)
                .method(HttpMethod.GET)
                .parse(new JsonParser<List<Repo>>(){

                    @Override
                    public Type getType() {
                        return new TypeToken<List<Repo>>(){}.getType();
                    }
                })
                .listener(new IHttpListener<List<Repo>>() {
                    @Override
                    public void onSuccess(HttpResponse<List<Repo>> response) {
                        CLog.d(TAG, "onSuccess() response data size:"+response.data.size());
                        for (Repo repo : response.data) {
                            CLog.d(TAG, "onSuccess() repo name:"+repo.name);
                        }
                    }

                    @Override
                    public void onError(HttpError error) {

                    }
                })
                .build();
        manager.request(request);
    }
}
