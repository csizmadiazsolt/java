package com.ezsocsi.projecteuler1;


import com.ezsocsi.utils.ArgUtils;
import com.ezsocsi.utils.ConsoleUtils;
import com.ezsocsi.utils.ConverterUtils;
import com.ezsocsi.utils.ListUtils;

public class Main { // NOSONAR squid:S1118
    public static void main(String... args) {
        ListUtils listUtils = new ListUtils();
        Calculator calculator = new Calculator();
        ConsoleUtils consoleUtils = new ConsoleUtils(listUtils);
        ConverterUtils converterUtils = new ConverterUtils();
        ArgUtils argUtils = new ArgUtils();
        ArgParser argParser = new ArgParser(argUtils, converterUtils);
        ProjectEuler1 projectEuler1 = new ProjectEuler1(calculator, consoleUtils, argParser);

        projectEuler1.calculate(args);
    }
}
