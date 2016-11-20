package com.ezsocsi.utils;


import java.util.Random;

public class RandomUtils {
    public int generateRandomInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}