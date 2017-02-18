package com.reece.network.ok;

import android.os.Handler;
import android.os.Looper;

import com.reece.network.IHttpManager;
import com.reece.network.http.HttpError;
import com.reece.network.http.HttpRequest;
import com.reece.network.http.HttpResponse;
import com.reece.network.http.IHttpListener;
import com.reece.network.http.parser.IResponseParser;
import com.reece.network.http.parser.JsonParser;
import com.reece.network.thread.ThreadExecutor;
import com.reece.network.util.DebugHelper;
import com.reece.network.util.NLog;

import java.io.IOException;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * Created by foreece@gmail.com on 17-2-17.
 */

public class OkHttpManager implements IHttpManager {
    private static final String TAG = "OkHttpManager";
    private static OkHttpManager INSTANCE;
    private OkHttpClient mHttpClient;
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    private OkHttpManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (DebugHelper.isDebugBuild()) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(interceptor);
        }
        mHttpClient = builder.build();
    }

    public static OkHttpManager get() {
        if (INSTANCE == null) {
            synchronized (OkHttpManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OkHttpManager();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void request(final HttpRequest request) {
        ThreadExecutor.get().submit(new Runnable() {
            @Override
            public void run() {
                requestInternal(request);
            }
        });
    }

    private void requestInternal(final HttpRequest request) {
        Response response;
        try {
            response = mHttpClient.newCall(getRequest(request)).execute();
            final HttpResponse httpResponse = new HttpResponse();
            IResponseParser parser = request.getParser();
            if (parser instanceof JsonParser) {
                httpResponse.data = parser.parse(response.body().string());
            } else {
                httpResponse.data = parser.parse(response.body());
            }
            final IHttpListener httpListener = request.getHttpListener();
            if (httpListener == null) {
                return;
            }
            if (response.isSuccessful()) {
                inMainThread(new Runnable() {
                    @Override
                    public void run() {
                        httpListener.onSuccess(httpResponse);
                    }
                });
            } else {
                inMainThread(new Runnable() {
                    @Override
                    public void run() {
                        HttpError error = new HttpError();
                        httpListener.onError(error);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
            NLog.e(TAG, "request exception.");
        }
    }

    private void inMainThread(Runnable runnable) {
        mMainHandler.post(runnable);
    }

    protected Request getRequest(HttpRequest request) {
        Request.Builder builder = new Request.Builder();
        switch (request.getHttpMethod()) {
            case GET:
                builder.url(getGetUrl(request.getParams(), request.getHttpUrl())).get();
                break;
            case POST:
                builder.url(request.getHttpUrl()).post(request.getRequestBody());
                break;
            /*case PATCH:
                builder.url(request.getHttpUrl()).patch(request.getRequestBody());
                break;
            case HEAD:
                builder.url(request.getHttpUrl()).head();
                break;
            case DELETE:
                builder.url(request.getHttpUrl()).delete();
                break;
            case PUT:
                builder.url(request.getHttpUrl()).put(request.getRequestBody());
                break;*/
            default:
                throw new RuntimeException("invalid http method " + request.getHttpMethod().name());
        }
        addHeader(request.getHeaders(), builder);
        return builder.build();
    }

    private String getGetUrl(Map<String, String> params, String url) {
        if (params.size() <= 0) {
            return url;
        }
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append("?");
        for (String key : params.keySet()) {
            stringBuilder.append(key).append("=").append(params.get(key)).append("&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private void addHeader(Map<String, String> headers, Request.Builder builder) {
        for (String key : headers.keySet()) {
            builder.addHeader(key, headers.get(key));
        }
    }
}
