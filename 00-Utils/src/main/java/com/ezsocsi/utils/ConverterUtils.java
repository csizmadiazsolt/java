package com.ezsocsi.utils;


import java.util.Optional;

public class ConverterUtils {
    public Optional<Integer> stringToInteger(String input) {
        Optional<Integer> output;

        try {
            output = Optional.of(Integer.valueOf(input));
        } catch (NumberFormatException e) {
            output = Optional.empty();
        }

        return output;
    }
}
