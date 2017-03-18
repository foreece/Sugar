package com.reece.network.http.fetcher;

import com.reece.network.http.HttpRequest;
import com.reece.network.parser.Parser;

import java.io.InputStream;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/15/17
 * @Description
 */

public class SimpleFetchContext<T> implements FetchContext {
    private HttpRequest mHttpRequest;
    private Parser<T> mResponseParser;
    private SimpleFetchContext(HttpRequest request, Parser<T> responseParser) {
        this.mHttpRequest = request;
        this.mResponseParser = responseParser;
    }
    @Override
    public HttpRequest getRequest() {
        return mHttpRequest;
    }

    @Override
    public String getUrl() {
        return mHttpRequest.getUrl();
    }

    public T parseData(InputStream inputStream) {
        return mResponseParser.parse(inputStream);
    }

    public static SimpleFetchContext<String> create(HttpRequest request, Parser<String> parser) {
        return new SimpleFetchContext(request, parser);
    }
}
