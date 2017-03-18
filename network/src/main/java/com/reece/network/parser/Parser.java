package com.reece.network.parser;

import java.io.InputStream;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/16/17
 * @Description
 */

public interface Parser<T> {
    T parse(InputStream inputStream);
}
