package com.algorithm.leeCode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: CrazyAndOptimize
 * @description: sss
 * @author: ly
 * @create: 2021-05-01 23:27
 **/
public class Reverse {

    public static int reverse(int x) {

        List<Integer> list = new ArrayList<>(32);
        int rest = x % 10;
        x = x / 10;
        while (true) {
            list.add(rest);
            rest = x % 10;
            x = x / 10;
            if (x == 0) {
                break;
            }
        }
        long reverse = 0;
        for (int i = 0, j = list.size() - 1; i <= list.size() - 1 && j >= 0; i++,j--) {
            reverse += (long) list.get(i) * pow(10, j);
        }
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)reverse;
    }

    public static int pow(int basic, int num) {
        if (num == 0) {
            return 1;
        }
        int total = basic;
        for (int i = 0; i < num - 1; i++) {
            total *= basic;
        }
        return total;
    }
}
