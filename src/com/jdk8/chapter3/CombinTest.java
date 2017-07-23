package com.jdk8.chapter3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by hzliyong on 2017/7/17 0017.
 */
public class CombinTest {

    public static void main(String[] args) {
        Album album = new Album();
        Artist a1 = new Artist();
        a1.setName("The bank");
        a1.setNationality("France");
        Artist a2 = new Artist();
        a2.setName("Beyond");
        a2.setNationality("China");
        List<Artist> list = new ArrayList<>(2);
        list.add(a1);
        list.add(a2);
        album.setMusicians(list);
        Set<String> origins = album.getMusicians().stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .collect(Collectors.toSet());
        origins.forEach(x -> System.out.println(x));
    }

    public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> {
                    album.getTracks()
                            .forEach(track -> {
                                if (track.getLength() > 60) {
                                    String name = track.getName();
                                    trackNames.add(name);
                                }
                            });
                });
        return trackNames;
    }

    public Set<String> refactorLongTrack(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> {
                    album.getTracks().stream()
                            .filter(track -> track.getLength() > 60)
                            .map(track -> track.getName())
                            .forEach(name -> trackNames.add(name));
                });
        return trackNames;
    }

    public Set<String> refactorLongTrack2(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .forEach(name -> trackNames.add(name));
        return trackNames;
    }

    public Set<String> refactorLongTrack3(List<Album> albums) {
        return albums.stream()
                .flatMap(album -> album.getTracks().stream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(Collectors.toSet());
    }
}
