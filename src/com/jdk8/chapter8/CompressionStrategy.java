package com.jdk8.chapter8;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by hzliyong on 2017/8/2 0002.
 */
public interface CompressionStrategy {

    public OutputStream compress(OutputStream data) throws IOException;
}
