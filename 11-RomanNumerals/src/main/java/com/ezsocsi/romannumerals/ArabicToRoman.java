package com.ezsocsi.romannumerals;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.round;

class ArabicToRoman {
    private ArabicToRomanConverter arabicToRomanConverter;

    ArabicToRoman(ArabicToRomanConverter arabicToRomanConverter) {
        this.arabicToRomanConverter = arabicToRomanConverter;
    }

    String getRomanNumber(Integer number) {
        List<Integer> resolvedArabicNumbers = getResolvedArabicNumbers(number);
        List<Integer> resolvedArabicElementsOfRomanNumber = getResolvedArabicElementsOfRomanNumber(resolvedArabicNumbers);
        return assembleRomanNumber(resolvedArabicElementsOfRomanNumber);
    }

    private List<Integer> getResolvedArabicNumbers(Integer number) {
        int numberLength = String.valueOf(number).length() + 1;
        List<Integer> resolvedNumbers = new ArrayList<>();

        IntStream.range(1, numberLength).forEach(d -> resolvedNumbers.add(getDigit(d, number)));
        return resolvedNumbers;
    }

    private Integer getDigit(int digitNumber, int number) {
        Long digit = number % round(pow(10, digitNumber)) /
                round(pow(10, (double) digitNumber - 1)) * round(pow(10, (double) digitNumber - 1));
        return digit.intValue();
    }

    private List<Integer> getResolvedArabicElementsOfRomanNumber(List<Integer> resolvedArabicNumbers) {
        List<Integer> resolvedArabicElementsOfRomanNumbers = new ArrayList<>();

        resolvedArabicNumbers.forEach(n -> resolvedArabicElementsOfRomanNumbers
                .addAll(resolveNumberToRomanComponents(n)));

        return resolvedArabicElementsOfRomanNumbers;
    }

    private List<Integer> resolveNumberToRomanComponents(Integer number) {
        int remnant = number;
        Optional<Integer> biggestDivider;
        List<Integer> resolvedNumbers = new ArrayList<>();

        do {
            biggestDivider = getBiggestDivide(remnant);

            if (biggestDivider.isPresent()) {
                remnant = remnant - biggestDivider.get();
                resolvedNumbers.add(biggestDivider.get());
            } else {
                remnant = 0;
            }
        } while (remnant != 0);

        return resolvedNumbers;
    }

    private Optional<Integer> getBiggestDivide(Integer number) {
        for (Integer key : arabicToRomanConverter.get().keySet()) {
            if ((number / key) >= 1) {
                return Optional.of(key);
            }
        }
        return Optional.empty();
    }

    private String assembleRomanNumber(List<Integer> resolvedArabicElementsOfRomanNumbers) {
        return resolvedArabicElementsOfRomanNumbers.stream()
                .sorted(Collections.reverseOrder())
                .map(this::getRomanValue)
                .collect(Collectors.joining());
    }

    private String getRomanValue(Integer key) {
        return arabicToRomanConverter.get().get(key);
    }
}