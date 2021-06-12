package com.test;

import java.util.BitSet;

/**
 * @program: music-livestream-message
 * @description:
 * @author: ly
 * @create: 2021-05-26 14:15
 **/
public class BloomFilter {

    private static final int SIZE = 2 << 24;

    private static final int[] SEEDS = new int[]{7, 13, 46, 79, 131};

    private final BitSet bitSet = new BitSet(SIZE);

    private final SimpleHash[] func = new SimpleHash[SEEDS.length];

    public BloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(SEEDS[i], SIZE);
        }
    }

    public void add(Object value) {
        for (SimpleHash f : func) {
            bitSet.set(f.hash(value), true);
        }
    }

    public boolean contains(Object value) {
        boolean res = true;
        for (SimpleHash f : func) {
            res &= bitSet.get(f.hash(value));
        }
        return res;
    }

    public static class SimpleHash {
        private final int seed;

        private final int cap;

        public SimpleHash(int seed, int cap) {
            this.seed = seed;
            this.cap = cap;
        }

        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) & h >>> 16));
        }
    }

    public static void main(String[] args) {
        String value1 = "abc";
        String value2 = "bcd";

        BloomFilter bloomFilter = new BloomFilter();
        System.out.println(bloomFilter.contains(value1));
        System.out.println(bloomFilter.contains(value2));
        bloomFilter.add(value1);
        bloomFilter.add(value2);
        System.out.println(bloomFilter.contains(value1));
        System.out.println(bloomFilter.contains(value2));

    }
}
