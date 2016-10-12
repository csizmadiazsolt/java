package com.ezsocsi.fizzbuzz;


import java.util.List;
import java.util.stream.Collectors;

public class Console {
    public void printlnList(List<String> list, String separator) {
        String concatenatedList = list.stream().map(i -> i.toString()).collect(Collectors.joining(separator));

        System.out.println(concatenatedList);
    }

    public void printlnError(String errorMessage) {
        System.err.println("ERROR: " + errorMessage);
    }
}