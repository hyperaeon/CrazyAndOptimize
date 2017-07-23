package com.jdk8.chapter3.exec;

import com.jdk8.chapter3.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hzliyong on 2017/7/18 0018.
 */
public class SumTest {

    public static void main(String[] args) {
        exec1();
        exce2();
    }

    private static void exce2() {
        List<Artist> list = new ArrayList<Artist>();
        Artist a1 = new Artist();
        a1.setName("abc");
        a1.setNationality("China");
        Artist a2 = new Artist();
        a2.setName("def");
        a2.setNationality("American");
        list.add(a1);
        list.add(a2);
        List<String> result = getNameAndNationality(list);
        result.forEach(x -> System.out.println(x));
    }

    private static void exec1() {
        Integer[] arrays = new Integer[]{1, 3, 4, 5, 6};
        int total = addUp(Stream.of(arrays));
        System.out.println(total);
    }

    private static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, element) -> acc + element);
    }

    private static List<String> getNameAndNationality(List<Artist> list) {
        return list.stream()
                .map(artist -> artist.getName() + artist.getNationality())
                .collect(Collectors.toList());
    }
}
