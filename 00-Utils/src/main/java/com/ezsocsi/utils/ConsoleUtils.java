package com.ezsocsi.utils;


import java.util.List;

public class ConsoleUtils {
    private ListUtils listUtils = new ListUtils();

    public ConsoleUtils(ListUtils listUtils) {
        this.listUtils = listUtils;
    }

    void print(String text) {
        System.out.print(text); // NOSONAR squid:S106
    }

    public void println(String text) {
        System.out.println(text); // NOSONAR squid:S106
    }

    void printList(List<String> list, String separator) {
        print(listUtils.concatenateList(list, separator));
    }

    public void printlnList(List<?> list, String separator) {
        println(listUtils.concatenateList(list, separator));
    }

    void printError(String errorMessage) {
        System.err.print("ERROR: " + errorMessage); // NOSONAR squid:S106
    }

    public void printlnError(String errorMessage) {
        System.err.println("ERROR: " + errorMessage); // NOSONAR squid:S106
    }
}
