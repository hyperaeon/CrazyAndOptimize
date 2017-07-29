package com.jdk8.chapter5;

import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by hzliyong on 2017/7/28 0028.
 */
public class StringCollector implements Collector {

    @Override
    public Supplier supplier() {

        return null;
    }

    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("name");
        joiner.add("sex");
        System.out.println(joiner.toString());
    }

}
