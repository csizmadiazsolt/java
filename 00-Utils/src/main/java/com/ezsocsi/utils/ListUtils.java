package com.ezsocsi.utils;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
    public void shuffle(List<?> list, int beginPosition, int endPosition) {
        Collections.shuffle(list.subList(beginPosition, endPosition));
    }

    public void swap(List<?> list, int i, int j) {
        Collections.swap(list, i, j);
    }

    String concatenateList(List<?> list, String separator) {
        return list.stream().map(Object::toString).collect(Collectors.joining(separator));
    }
}
