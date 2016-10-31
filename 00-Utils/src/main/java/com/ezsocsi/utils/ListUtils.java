package com.ezsocsi.utils;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
    public List<Character> shuffle(List<Character> list, int beginPosition, int endPosition) {
        Collections.shuffle(list.subList(beginPosition, endPosition));
        return list;
    }

    public List<Integer> swap(List<Integer> list, int i, int j) {
        Collections.swap(list, i, j);
        return list;
    }

    String concatenateList(List<?> list, String separator) {
        return list.stream().map(Object::toString).collect(Collectors.joining(separator));
    }
}
