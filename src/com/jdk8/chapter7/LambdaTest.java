package com.jdk8.chapter7;

import com.jdk8.chapter3.Album;
import com.jdk8.chapter3.Artist;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by hzliyong on 2017/7/31 0031.
 */
public class LambdaTest {

    private Album album;

    public static List<String> allToUpperCase(List<String> words) {
        return words.stream()
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<String> elementFirstToUpperCaseLambdas(List<String> words) {
        return words.stream()
                .map(value -> {
                    char firstChar = Character.toUpperCase(value.charAt(0));
                    return firstChar + value.substring(1);
                }).collect(Collectors.toList());
    }

    @Test
    public void multipleWordsToUppercase() {
        List<String> input = Arrays.asList("a", "b", "Hello");
        List<String> result = allToUpperCase(input);
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), result);
    }

    @Test
    public void towLetterStringConvertedToUppercaseLambdas() {
        List<String> input = Arrays.asList("ab");
        List<String> result = elementFirstToUpperCaseLambdas(input);
        Assert.assertEquals(Arrays.asList("Ab"), input);
    }

    @Test
    public void peekTest() {
        album = new Album();
        List<Artist> artistList = new ArrayList<>();
        Artist art = new Artist();
        art.setName("The Beatch");
        art.setNationality("China");
        artistList.add(art);
        album.setMusicians(artistList);
        Set<String> nationalities = album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .peek(nation -> System.out.println("Found nationality: " + nation))
                .collect(Collectors.toSet());
    }
}
