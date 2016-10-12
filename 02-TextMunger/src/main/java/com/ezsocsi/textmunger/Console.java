package com.ezsocsi.textmunger;


public class Console {
    public void println(String text) {
        System.out.println(text);
    }

    public void printlnError(String errorMessage) {
        System.err.println("ERROR: " + errorMessage);
    }
}
