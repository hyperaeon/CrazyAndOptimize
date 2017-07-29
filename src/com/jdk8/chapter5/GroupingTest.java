package com.jdk8.chapter5;

import com.jdk8.chapter3.Album;
import com.jdk8.chapter3.Artist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by hzliyong on 2017/7/25 0025.
 */
public class GroupingTest {

    public static void main(String[] args) {
        System.out.println(builderAppend());
    }

    private static Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMainMusician()));
    }

    private static String builderAppend() {
        List<Artist> artists = new ArrayList<Artist>();
        Artist a1 = new Artist();
        a1.setName("Georgge Harrison");
        Artist a2 = new Artist();
        a2.setName("John Lennon");
        Artist a3 = new Artist();
        a3.setName("The Beatles");
        artists.add(a1);
        artists.add(a2);
        artists.add(a3);
        return grouping2(artists);
    }
    private static String grouping(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist : artists) {
            if (builder.length() > 1) {
                builder.append(", ");
            }
            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        return builder.toString();
    }


    private static String grouping2(List<Artist> artists) {
        return artists.stream().map(Artist::getName)
                .collect(Collectors.joining(",", "[", "]"));
    }

    private Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMainMusician(), counting()));
    }

    private Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(album -> album.getMainMusician()));
        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(), entry.getValue().stream().map(Album::getName).collect(toList()));
        }
        return nameOfAlbums;
    }

    private Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician,
                mapping(Album::getName, toList())));
    }

    private String appending(List<Artist> artists) {
        StringBuilder builder = new StringBuilder("[");
        artists.stream().map(Artist::getName)
                .forEach(name -> {
                    if (builder.length() > 1) {
                        builder.append(", ");
                    }
                    builder.append(name);
                });
        builder.append("]");
        return builder.toString();
    }

    private String reducedTest(List<Artist> artists) {
        StringBuilder reduced = artists.stream().map(Artist::getName)
                .reduce(new StringBuilder(), (builder, name) -> {
                    if (builder.length() > 0) {
                        builder.append(", ");
                    }
                    builder.append(name);
                    return builder;
                }, (left, right) -> left.append(right));
        reduced.insert(0, "[");
        reduced.append("]");
        return reduced.toString();
    }

    private String stringCombinerTest(List<Artist> artists) {
        StringCombiner combiner =
                artists.stream().map(Artist::getName)
                .reduce(new StringCombiner(",", "[", "]"),
                        StringCombiner::add,
                        StringCombiner::merge);
        return combiner.toString();
    }
}
