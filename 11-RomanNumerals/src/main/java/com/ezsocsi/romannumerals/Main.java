package com.ezsocsi.romannumerals;


import java.util.HashMap;
import java.util.Map;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.round;

public class Main {
    public static void main(String... args) {
        Map map = new HashMap();

        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        //MMCDXXXII
        System.out.println(getDigit(4, 2432));
        System.out.println(getDigit(3, 2432));
        System.out.println(getDigit(2, 2432));
        System.out.println(getDigit(1, 2432));
    }

    private static boolean isLessThan5000(int number) {
        if (number < 5000) {
            return true;
        }
        return false;
    }



    private static Long getDigit(int digit, int number) {
        return (number % round(pow(10, digit))) / round(pow(10, digit - 1)) * round(pow(10, digit - 1));
    }
}
