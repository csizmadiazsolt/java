package com.ezsocsi.romannumerals;


import java.util.Collections;
import java.util.TreeMap;

class ArabicToRomanConverter {
    TreeMap<Integer, String> get() {
        TreeMap<Integer, String> converterMap = new TreeMap<>(Collections.reverseOrder());

        converterMap.put(1, "I");
        converterMap.put(4, "IV");
        converterMap.put(5, "V");
        converterMap.put(9, "IX");
        converterMap.put(10, "X");
        converterMap.put(40, "XL");
        converterMap.put(50, "L");
        converterMap.put(90, "XC");
        converterMap.put(100, "C");
        converterMap.put(400, "CD");
        converterMap.put(500, "D");
        converterMap.put(900, "CM");
        converterMap.put(1000, "M");

        return converterMap;
    }
}