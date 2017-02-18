package com.reece.network.http.parser;

import com.google.gson.Gson;
import java.lang.reflect.Type;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/17/17
 * @Description
 */

public abstract class JsonParser<S> implements IResponseParser<String, S> {
    @Override
    public S parse(String source) {
        Gson gson = new Gson();
        return gson.fromJson(source, getType());
    }

    public abstract Type getType();
}
