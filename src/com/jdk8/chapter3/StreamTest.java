package com.jdk8.chapter3;



import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hzliyong on 2017/7/16 0016.
 */
public class StreamTest {

    public static void main(String[] args) {
//        streamTest();
        collectTest();
    }

    private static void collectTest() {
        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        System.out.println(Arrays.asList("a", "b", "c").equals(collected));
    }

    private static void streamTest() {
        List<Artist> allArtists = new ArrayList<>();
        Artist a = new Artist("John Lennon", "London");
        allArtists.add(a);
        allArtists.stream().filter(artist -> {
            System.out.println("name: " + artist.getName());
            return artist.isFrom("London");
        });
        long count = allArtists.stream().filter(artist -> {
            System.out.println(artist.getName());
            return artist.isFrom("London");
        }).count();
        System.out.println("count: " + count);
    }
}
