package com.reece.network.exception;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/16/17
 * @Description
 */
//TODO how to implement an exception?
public class NoParserException extends Exception {
    public NoParserException() {
        super("you should designate a parser.");
    }
}
