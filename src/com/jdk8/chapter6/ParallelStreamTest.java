package com.jdk8.chapter6;

import com.jdk8.chapter3.Album;
import com.jdk8.chapter3.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzliyong on 2017/7/29 0029.
 */
public class ParallelStreamTest {

    private static final int MOCK_COUNT = 3000;

    public static void main(String[] args) {
        parallelTest();
        serialTest();
    }

    private static void serialTest() {
        List<Album> albums = buildAlbums(MOCK_COUNT);
        System.out.println("serial begin");
        long start = System.currentTimeMillis();
        int total = serialArraySum(albums);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("total: " + total);
        System.out.println("serial end");
    }

    private static void parallelTest() {
        List<Album> albums = buildAlbums(MOCK_COUNT);
        System.out.println("parallel begin");
        long start = System.currentTimeMillis();
        int total = parallelArraySum(albums);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("total: " + total);
        System.out.println("parallel end");
    }



    private static List<Album> buildAlbums(int total) {
        List<Album> albums = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            Album album = new Album();
            album.setName("album name");
            List<Track> tracks = buildTracks(i, i + 10);
            album.setTracks(tracks);
            albums.add(album);
        }
       return albums;
    }


    private static List<Track> buildTracks(int index, int total) {
        List<Track> tracks = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            Track track = new Track();
            track.setLength(index + i + 10);
            track.setName(index + " name " + i);
            tracks.add(track);
        }
        return tracks;
    }

    public static int serialArraySum(List<Album> albums) {
        return albums.stream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }

    public static int parallelArraySum(List<Album> albums) {
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }
}
