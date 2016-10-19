package com.ezsocsi.utils;


import java.util.Collections;

public class ListUtils {
    public java.util.List<Character> shuffle(java.util.List<Character> list, int beginPosition, int endPosition) {
        Collections.shuffle(list.subList(beginPosition, endPosition));
        return list;
    }
}
