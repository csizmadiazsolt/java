package com.ezsocsi.projecteuler1;


import com.ezsocsi.utils.ConsoleUtils;

class ProjectEuler1 {
    private final Calculator calculator;
    private final ConsoleUtils consoleUtils;
    private final ArgParser argParser;

    ProjectEuler1(Calculator calculator, ConsoleUtils consoleUtils, ArgParser argParser) {
        this.calculator = calculator;
        this.consoleUtils = consoleUtils;
        this.argParser = argParser;
    }

    void calculate(String... args) {
        if (argParser.parseArgs(args)) {
            Integer calculatedValue = calculator.calculateProjectEuler1(argParser.getInput());

            consoleUtils.println(calculatedValue.toString());
        } else {
            consoleUtils.printlnError("unable to parse arguments, expected: <number>.");
        }
    }
}
