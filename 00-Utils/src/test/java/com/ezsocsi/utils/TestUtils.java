package com.ezsocsi.utils;

import java.util.List;
import java.util.stream.Collectors;

public class TestUtils {
    public static List<Character> stringToCharList(String text) {
        return text.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    }

    public static long countOccurrences(String input, Character matching)
    {
        List<Character> inputAsCharList = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        return inputAsCharList.stream().filter(c -> c.equals(matching)).count();
    }
}
