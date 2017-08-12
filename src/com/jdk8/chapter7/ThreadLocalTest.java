package com.jdk8.chapter7;

import com.jdk8.chapter3.Album;

import java.util.List;
import java.util.function.ToLongFunction;

/**
 * Created by hzliyong on 2017/7/30 0030.
 */
public class ThreadLocalTest {

    private static List<Album> albums;

    public static void main(String[] args) {
//        ThreadLocal<Album> thisAlbum = ThreadLocal.withInitial(() -> database.lookupCurrentAlbum());
        Object s = null;
        System.out.println(s + "");
        System.out.println(Long.valueOf("null"));
    }

    public long countingRunningTime() {
        return albums.stream().
                mapToLong(album -> album.getTracks().mapToLong(track -> track.getLength()).sum()).sum();
    }

    public long countMusicians() {
        return albums.stream()
                .mapToLong(album -> album.getMusicians().count()).sum();
    }

    public long countTracks() {
        return albums.stream()
                .mapToLong(album -> album.getTracks().count()).sum();
    }

    public long countFeature(ToLongFunction<Album> function) {
        return albums.stream()
                .mapToLong(function)
                .sum();
    }

    public long countTracks2() {
        return countFeature(album -> album.getTracks().count());
    }

    public long countRunningTimes2() {
        return countFeature(album -> album.getTracks().mapToLong(track -> track.getLength()).sum());
    }

    public long countMusicians2() {
        return countFeature(album -> album.getMusicians().count());
    }

}
