package com.reece.network.parser;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/16/17
 * @Description
 */

public class ParserFactory {
    public static Parser<String> getStringParser() {
        return new StringParser();
    }
}
