package ru.gbuac.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagUtil {
    private TagUtil() {
    }

    public static String getTableTag(String tag) {
        if (tag == null) {
            return null;
        }
        final String regex = "\\[[^\\[]*\\]";
        final Pattern pattern;
        pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(tag);
        return matcher.find() ? matcher.group().substring(1, matcher.group().length()-1) : null;
    }


    public static String getSimpleTag(String tag) {
        if (tag == null) {
            return null;
        }
        final String regex = "].*";
        final Pattern pattern;
        pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(tag);
        matcher.find();
        return matcher.find() ? matcher.group().substring(1) : tag;
    }
}
