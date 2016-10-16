package com.ezsocsi.utility;


import java.util.List;
import java.util.stream.Collectors;

public class ConsoleUtility {
    public void print(String text) {
        System.out.print(text);
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void printList(List<String> list, String separator) {
        System.out.print(concatenateList(list, separator));
    }

    public void printlnList(List<String> list, String separator) {
        System.out.println(concatenateList(list, separator));
    }

    private String concatenateList(List<String> list, String separator) {
        return list.stream().map(String::toString).collect(Collectors.joining(separator));
    }

    public void printError(String errorMessage) {
        System.err.print("ERROR: " + errorMessage);
    }

    public void printlnError(String errorMessage) {
        System.err.println("ERROR: " + errorMessage);
    }
}
