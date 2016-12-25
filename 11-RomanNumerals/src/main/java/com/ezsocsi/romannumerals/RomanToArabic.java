package com.ezsocsi.romannumerals;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RomanToArabic {
    private RomanToArabicConverter romanToArabicConverter;

    RomanToArabic(RomanToArabicConverter romanToArabicConverter) {
        this.romanToArabicConverter = romanToArabicConverter;
    }

    Integer getArabicValue(String number) {
        List<Character> resolvedRomanNumber = stringToCharList(number);
        List<Integer> arabicValues = romanElementsToArabic(resolvedRomanNumber);
        return calculateArabicValue(arabicValues);
    }

    private List<Character> stringToCharList(String text) {
        return text.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
    }

    private List<Integer> romanElementsToArabic(List<Character> romanNumbers) {
        return romanNumbers.stream().map(x -> romanToArabicConverter.get().get(x.toString())).collect(Collectors.toList());
    }

    private Integer calculateArabicValue(List<Integer> arabicNumbers) {
        List<Integer> signedArabicNumbers = new ArrayList<>();

        IntStream.range(0, arabicNumbers.size() - 1).forEach(n -> {
            if (arabicNumbers.get(n) < arabicNumbers.get(n + 1)) {
                signedArabicNumbers.add(arabicNumbers.get(n) * -1);
            } else {
                signedArabicNumbers.add(arabicNumbers.get(n));
            }
        });

        signedArabicNumbers.add(arabicNumbers.get(arabicNumbers.size() - 1));

        return signedArabicNumbers.stream().mapToInt(Integer::intValue).sum();
    }
}
