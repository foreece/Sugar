package com.reece.network.parser;

import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Reece
 * @version V1.0
 * @Date 3/16/17
 * @Description
 */

public class StringParser implements Parser<String> {
    @Override
    public String parse(InputStream inputStream) {
        String result = null;
        if (inputStream != null) {
            try {
                result = CharStreams.toString(new InputStreamReader(inputStream, "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
