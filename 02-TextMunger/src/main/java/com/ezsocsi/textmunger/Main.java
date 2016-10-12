package com.ezsocsi.textmunger;

public class Main {
    public static void main(String[] args) {
        Utils utils = new Utils();
        Munger munger = new Munger(utils);

        System.out.println(munger.munge("eztkellmungelni"));
    }
}
