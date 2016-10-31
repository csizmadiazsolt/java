package com.ezsocsi.fizzbuzz;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class FizzBuzzGenerator {
    List<String> generate(int lowerLimit, int upperLimit) {
        List<String> fizzBuzzList = new ArrayList<>();

        IntStream.range(lowerLimit, upperLimit + 1)
                .mapToObj(this::getFizzBuzzValue)
                .forEach(fizzBuzzList::add);

        return fizzBuzzList;
    }

    private String getFizzBuzzValue(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        }
        return Integer.toString(i);
    }
}
