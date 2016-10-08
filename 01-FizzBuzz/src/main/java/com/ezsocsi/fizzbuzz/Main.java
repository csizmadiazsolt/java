package com.ezsocsi.fizzbuzz;

public class Main {

    public static void main(String... args) {
        ArgParser argParser = new ArgParser();
        FizzBuzzGenerator fizzBuzzGenerator = new FizzBuzzGenerator();
        Console console = new Console();
        FizzBuzz fizzBuzz = new FizzBuzz(argParser, fizzBuzzGenerator, console);

        fizzBuzz.fizzBuzz(args);
    }
}
