package com.jdk8.chapter5;

/**
 * Created by hzliyong on 2017/7/27 0027.
 */
public class StringCombiner {

    private String prefix;

    private String suffix;

    private String delim;

    private StringBuilder builder;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.delim = delim;
        this.builder = new StringBuilder();
    }

    public StringCombiner add(String element) {
        if (areAtStart()) {
            builder.append(prefix);
        } else {
            builder.append(delim);
        }
        builder.append(element);
        return this;
    }

    public StringCombiner merge(StringCombiner other) {
        builder.append(other.builder);
        return this;
    }

    public String toString() {
        return prefix + builder.toString() + suffix;
    }

    public boolean areAtStart() {
        return builder.length() == 0;
    }
}
