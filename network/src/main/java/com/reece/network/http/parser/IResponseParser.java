package com.reece.network.http.parser;

/**
 * @author Reece
 * @version V1.0
 * @Date 2/17/17
 * @Description
 */

public interface IResponseParser<T, S> {
    S parse(T t);
}
