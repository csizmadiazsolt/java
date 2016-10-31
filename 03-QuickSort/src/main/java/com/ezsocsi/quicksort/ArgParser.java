package com.ezsocsi.quicksort;


import com.ezsocsi.utils.ArgUtils;
import com.ezsocsi.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;

public class ArgParser {
    private final ArgUtils argUtils;
    private final ConverterUtils converterUtils;
    private static final int NUMBER_OF_ARGS = 1;
    private List<Integer> inputList;

    ArgParser(ArgUtils argUtils, ConverterUtils converterUtils) {
        this.argUtils = argUtils;
        this.converterUtils = converterUtils;
    }

    boolean parseArgs(String... args) {
        if (argUtils.checkNumberOfArgs(NUMBER_OF_ARGS, args)) {
            Optional<String> inputList = argUtils.getArgument(0, args);

            if (inputList.isPresent()) {
                List<String> elements = argUtils.splitArgToList(inputList.get(), "\\s+");

                if (allElementsAreNumeric(elements)) {
                    this.inputList = converterUtils.stringListToIntegerList(elements);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean allElementsAreNumeric(List<String> inputList) {
        long numberOfNumericElements = inputList.stream()
                .map(converterUtils::stringToInteger)
                .filter(Optional::isPresent)
                .count();

        return inputList.size() == numberOfNumericElements;
    }

    List<Integer> getInputList() {
        return this.inputList;
    }
}
