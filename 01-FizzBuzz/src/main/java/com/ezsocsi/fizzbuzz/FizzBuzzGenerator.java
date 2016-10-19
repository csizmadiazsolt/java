package com.ezsocsi.fizzbuzz;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzzGenerator {
    public List<String> generate(int lowerLimit, int upperLimit) {
        List<String> fizzBuzzList = new ArrayList<>();

        IntStream.range(lowerLimit, upperLimit + 1)
                .mapToObj(i -> getFizzBuzzValue(i))
                .forEach(i -> fizzBuzzList.add(i.toString()));

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
