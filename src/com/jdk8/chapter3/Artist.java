package com.jdk8.chapter3;

import java.util.List;

/**
 * Created by hzliyong on 2017/7/16 0016.
 */
public class Artist {

    private String name;

    private String origin;

    private List<String> members;

    private String nationality;

    public Artist() {

    }

    public Artist(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public boolean isFrom(String origin) {
        return this.origin.equals(origin) ? true : false;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
