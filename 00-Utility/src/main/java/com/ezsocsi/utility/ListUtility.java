package com.ezsocsi.utility;


import java.util.Collections;

public class ListUtility {
    public java.util.List<Character> shuffle(java.util.List<Character> list, int beginPosition, int endPosition) {
        Collections.shuffle(list.subList(beginPosition, endPosition));
        return list;
    }
}
