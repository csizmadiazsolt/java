package com.ezsocsi.romannumerals;


import java.util.Collections;
import java.util.TreeMap;

class RomanToArabicConverter {
    TreeMap<String, Integer> get() {
        TreeMap<String, Integer> converterMap = new TreeMap<>(Collections.reverseOrder());

        converterMap.put("I", 1);
        converterMap.put("IV", 4);
        converterMap.put("V", 5);
        converterMap.put("IX", 9);
        converterMap.put("X", 10);
        converterMap.put("XL", 10);
        converterMap.put("L", 50);
        converterMap.put("XC", 90);
        converterMap.put("C", 100);
        converterMap.put("CD", 400);
        converterMap.put("D", 500);
        converterMap.put("CM", 900);
        converterMap.put("M", 1000);

        return converterMap;
    }
}