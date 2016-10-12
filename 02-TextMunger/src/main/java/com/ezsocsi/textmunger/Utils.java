package com.ezsocsi.textmunger;


import java.util.Collections;
import java.util.List;

public class Utils {

    public List<Character> shuffle(List<Character> list, int beginPosition, int endPosition) {
        Collections.shuffle(list.subList(beginPosition, endPosition));
        return list;
    }
}
