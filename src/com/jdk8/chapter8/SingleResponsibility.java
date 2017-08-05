package com.jdk8.chapter8;

import java.util.stream.IntStream;

/**
 * Created by hzliyong on 2017/8/4 0004.
 */
public class SingleResponsibility {

    public long countPrimes(int upTo) {
        long tally = 0;
        for (int i = 0; i < upTo; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                tally++;
            }
        }
        return tally;
    }


    public long countPrimes2(int upTo) {
        long tally = 0;
        for (int i = 1; i < upTo; i++) {
            if(isPrime(i)) {
                tally++;
            }
        }
        return tally;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public long countPrimes3(int upTo) {
        return IntStream.range(1, upTo)
                .parallel()
                .filter(this::isPrime2)
                .count();
    }

    private boolean isPrime2(int number) {
        return IntStream.range(2, number)
                .allMatch(x -> (number % x) != 0);
    }
}
