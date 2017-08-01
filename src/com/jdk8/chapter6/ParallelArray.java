package com.jdk8.chapter6;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by hzliyong on 2017/7/30 0030.
 */
public class ParallelArray {

    public static void main(String[] args) {
        double[] values = new double[]{0, 1, 2, 3, 4, 3.5};
        int n = 3;
        double[] sums = simpleMovingAverage(values, n);
        for (double sum : sums) {
            System.out.println(sum);
        }
    }

    private static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    public static double[] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);
        int start = n -1;
        return IntStream.range(start, sums.length)
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i - n];
                    return (sums[i] - prefix) /n;
                }).toArray();
    }
}
