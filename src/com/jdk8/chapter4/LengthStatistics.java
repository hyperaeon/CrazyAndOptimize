package com.jdk8.chapter4;

import com.jdk8.chapter3.Album;
import com.jdk8.chapter3.Track;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by hzliyong on 2017/7/19 0019.
 */
public class LengthStatistics {

    public static void main(String[] args) {
        staticTest();
    }

    public static void staticTest() {
        Album album = new Album();
        Track t1 = new Track();
        t1.setLength(50);
        Track t2 = new Track();
        t2.setLength(100);
        Track t3 = new Track();
        t3.setLength(300);
        List<Track> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        album.setTracks(list);
        printTrackLengthStatistics(album);
    }
    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats = album.getTracks().stream().mapToInt(track -> track.getLength())
                .summaryStatistics();
        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }
}
