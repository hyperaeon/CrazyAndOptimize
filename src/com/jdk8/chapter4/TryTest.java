package com.jdk8.chapter4;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzliyong on 2017/7/20 0020.
 */
public class TryTest {

    public static void main(String[] args) throws Exception {
        PrintStream ps2 = new PrintStream(new FileOutputStream("a.txt"));
        try (
                FileOutputStream f = new FileOutputStream("a.txt");
                PrintStream ps = new PrintStream(f);
        ) {
            ps.print(3);
        }
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        if (list.size() == 2) {
            list.remove(1);
        }
        list.forEach(x -> System.out.println(x));
    }
}
