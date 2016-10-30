package com.ezsocsi.utils;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Integer> stringListToIntegerList(List<String> input) {
        return input.stream()
                .map(this::stringToInteger)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
