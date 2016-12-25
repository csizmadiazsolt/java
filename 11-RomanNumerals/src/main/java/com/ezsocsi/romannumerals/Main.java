package com.ezsocsi.romannumerals;


public class Main { // NOSONAR squid:S1118
    public static void main(String... args) {
        ArabicToRomanConverter arabicToRomanConverter = new ArabicToRomanConverter();
        RomanToArabicConverter romanToArabicConverter = new RomanToArabicConverter();
        ArabicToRoman arabicToRoman = new ArabicToRoman(arabicToRomanConverter);
        RomanToArabic romanToArabic = new RomanToArabic(romanToArabicConverter);

        System.out.println(arabicToRoman.getRomanNumber(978)); // NOSONAR squid:S106
        System.out.println(romanToArabic.getArabicValue("CMLXXVIII")); // NOSONAR squid:S106
    }
}