package com.jdk8.chapter5;

import com.jdk8.chapter3.Album;
import com.jdk8.chapter3.Artist;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.partitioningBy;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by hzliyong on 2017/7/23 0023.
 */
public class MethodInvokeTest {

    public static void main(String[] args) {
        ordered();
    }

    @Test
    private void listSequence() {
        List<Integer> numbers = asList(1, 3, 5, 6);
        List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());
        assertNotEquals(numbers, sameOrder);
    }

    @Test
    private void hashSetSequence() {
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));
        List<Integer> sameOrder = numbers.stream().sorted().collect(Collectors.toList());
        assertEquals(asList(1, 2, 3, 4), sameOrder);
    }

    private static void ordered() {
        List<Integer> numbers = asList(1, 2, 3, 4);
        List<Integer> stillOrdered = numbers.stream().map(x -> x + 1).collect(Collectors.toCollection(ArrayList :: new));
        stillOrdered.forEach(x -> System.out.print(x + " "));
        System.out.println();
        Set<Integer> unordered = new HashSet<>(numbers);
        List<Integer> stillUnordered = unordered.stream().map(x -> x + 1).collect(Collectors.toList());

        stillUnordered.forEach(x -> System.out.print(x + " "));
    }

    private static Optional<Artist> biggestGroup(Stream<Artist> artists) {
//        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
//        return artists.collect(maxBy(comparing(getCount)));
        return null;
    }

    private static double averageNumberOfTracks(List<Album> albums) {
        return albums.stream().collect(averagingInt(album -> album.getTracks().size()));
    }

    private static Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(partitioningBy(Artist::isSolo));
//        return artists.collect(partitioningBy(artist -> artist.isSolo()));
    }
}
