package com.ezsocsi.utils;


import java.util.Collections;
import java.util.List;

public class ListUtils {
    public List<Character> shuffle(java.util.List<Character> list, int beginPosition, int endPosition) {
        Collections.shuffle(list.subList(beginPosition, endPosition));
        return list;
    }

    public void swap(List<?> list, int i, int j) {
        Collections.swap(list, i, j);
    }
}
