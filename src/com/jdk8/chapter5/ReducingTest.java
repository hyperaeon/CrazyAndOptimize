package com.jdk8.chapter5;

import com.jdk8.chapter3.Album;
import com.jdk8.chapter3.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by hzliyong on 2017/7/29 0029.
 */
public class ReducingTest {

    private static Map<String, Artist> artistCache = new HashMap<>();

    public static void main(String[] args) {

    }

    private static String reducingTest(List<Artist> artists) {
        String result = artists.stream()
                .map(Artist::getName)
                .collect(Collectors.reducing(
                        new StringCombiner(",", "[", "]"),
                        name -> new StringCombiner(",", "[", "]").add(name),
                        StringCombiner::merge)).toString();
        return result;
    }

    private Artist getArtist(String name) {
        Artist artist = artistCache.get(name);
        if (artist == null) {
            artist = readArtistFromDB(name);
            artistCache.put(name, artist);
        }
        return artist;
    }

    private Artist getArtist2(String name) {
        return artistCache.computeIfAbsent(name, this::readArtistFromDB);
    }

    private void mapIterator(Map<Artist, List<Album>> albumsByArtist) {
        Map<Artist, Integer> countOfAlbums = new HashMap<>();
        albumsByArtist.forEach((artist, albums) -> {
            countOfAlbums.put(artist, albums.size());
        });

    }

    private Artist readArtistFromDB(String name) {
        return null;
    }


}
