package com.ezsocsi.utility;

import java.util.List;
import java.util.stream.Collectors;

public class TestUtility {
    public static List<Character> stringToCharList(String text) {
        return text.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    }
}
