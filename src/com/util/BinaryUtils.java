package com.util;

/**
 * @author hzliyong
 * @description
 * @date 2019/7/23 0023
 * @time 09:49
 */
public class BinaryUtils {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 判断n是否为奇数，true表示奇数
     * @param n
     * @return
     */
    public static boolean oddEven(int n) {
        return (n & 1) == 1;
    }

    /**
     * 交换两个数
     */
    public static void swap() {
        int x = 3;
        int y = 4;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x:" + x + ",y:" + y);
    }

    /**
     * numbers中只有一个数不存在重复，找出这个数
     * @param numbers
     * @return
     */
    public static int findNoDuplicateNumber(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result ^= number;
        }
        return result;
    }

    /**
     * m的n次方
     * @param m
     * @param n
     * @return
     */
    public static int pow(int m, int n) {
        int sum = 1;
        int tmp = m;
        while(n != 0){
            if((n & 1) == 1){
                sum *= tmp;
            }
            tmp *= tmp;
            n = n >> 1;
        }
        return sum;
    }

    /**
     * 找出比n小的最大的2的幂指数
     * @param n
     * @return
     */
    public static int findN(int n) {
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return (n + 1) >> 1;
    }

    /**
     * 找出比n大的最小的2的幂指数
     * @param cap
     * @return
     */
    public static int findN2(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    public static void main(String[] args) {
        System.out.println(oddEven(3));
        swap();
        int[] numbers = {1, 1, 2, 2, 3, 3, 4};
        System.out.println(findNoDuplicateNumber(numbers));
        System.out.println(pow(3, 4));
        int cap = 31;
        System.out.println(findN(cap));
        System.out.println(findN2(cap));
    }
}
