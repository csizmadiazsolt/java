package com.ezsocsi.fizzbuzz;


import java.util.List;
import java.util.Optional;

public class FizzBuzz {
    private ArgParser argParser;
    private FizzBuzzGenerator fizzBuzzGenerator;
    private Console console;

    public FizzBuzz(ArgParser argParser, FizzBuzzGenerator fizzBuzzGenerator, Console console) {
        this.argParser = argParser;
        this.fizzBuzzGenerator = fizzBuzzGenerator;
        this.console = console;
    }

    public void fizzBuzz(String... args) {
        if (argParser.parseArgs(args)) {
            Optional<Integer> lowerLimit = argParser.getLowerLimit();
            Optional<Integer> upperLimit = argParser.getUpperLimit();
            List<String> fizzBuzzOutput = fizzBuzzGenerator.generate(lowerLimit.get(), upperLimit.get());

            console.printlnList(fizzBuzzOutput, ", ");
        } else {
            console.printlnError("unable to parse arguments, expected: <int> <int>.");
        }
    }

}
