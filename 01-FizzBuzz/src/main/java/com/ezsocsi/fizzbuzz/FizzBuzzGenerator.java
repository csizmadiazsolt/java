package com.ezsocsi.fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzzGenerator {
    public List<String> generate(int lowerLimit, int upperLimit) {
        List<String> fizzBuzzList = new ArrayList<>();

        IntStream.range(lowerLimit, upperLimit + 1)
                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
                .forEach(i -> fizzBuzzList.add(i.toString()));

        return fizzBuzzList;
    }
}
