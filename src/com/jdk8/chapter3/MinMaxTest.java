package com.jdk8.chapter3;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by hzliyong on 2017/7/17 0017.
 */
public class MinMaxTest {

    public static void main(String[] args) {
        List<Track> tracks = asList(new Track("Babai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
        System.out.println(shortestTrack.getLength());
    }
}
