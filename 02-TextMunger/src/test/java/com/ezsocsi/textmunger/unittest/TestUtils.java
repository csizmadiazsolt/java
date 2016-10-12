package com.ezsocsi.textmunger.unittest;


import java.util.List;
import java.util.stream.Collectors;

public class TestUtils {
    public static List<Character> stringToCharList(String text) {
        return text.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    }
}
