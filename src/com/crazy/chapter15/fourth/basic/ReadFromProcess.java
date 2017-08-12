package com.crazy.chapter15.fourth.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hzliyong on 2017/8/8 0008.
 */
public class ReadFromProcess {

    public static void main(String[] args) throws IOException {
        Process process = Runtime.getRuntime().exec("javac");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String buff = null;
            while ((buff = br.readLine()) != null) {
                System.out.println(buff);
            }
        }
    }
}
