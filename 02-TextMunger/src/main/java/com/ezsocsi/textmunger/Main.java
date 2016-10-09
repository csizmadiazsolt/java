package com.ezsocsi.textmunger;

public class Main {
    public static void main(String[] args) {
        String text = "This is a complex sentence, isn't it?";
        Munger munger = new Munger();

        System.out.println(munger.munge(text));
    }
}
