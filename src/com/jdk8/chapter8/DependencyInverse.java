package com.jdk8.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by hzliyong on 2017/8/5 0005.
 */
public class DependencyInverse {

    public static void main(String[] args) {

    }

    private static List<String> findHeadings(Reader input) throws Exception {
        try(BufferedReader reader = new BufferedReader(input)) {
            return reader.lines()
                    .filter(line -> line.endsWith(":"))
                    .map(line -> line.substring(0, line.length() - 1))
                    .collect(toList());
        } catch (IOException exception) {
            throw new Exception();
        }
    }

    private <T> T withLinesOf(Reader input,
                            Function<Stream<String>, T>  handler,
                            Function<IOException, RuntimeException> error) {
        try(BufferedReader reader = new BufferedReader(input)) {
            return handler.apply(reader.lines());
        } catch(IOException e) {
            throw error.apply(e);
        }
    }
}
