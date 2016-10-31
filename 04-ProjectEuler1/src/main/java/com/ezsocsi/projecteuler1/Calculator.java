package com.ezsocsi.projecteuler1;


import java.util.stream.IntStream;

class Calculator {
    int calculateProjectEuler1(int limit) {
        return IntStream.range(0, limit).filter(this::isModulusOf3Or5).sum();
    }

    private boolean isModulusOf3Or5(int i) {
        return i % 5 == 0 || i % 3 == 0;
    }
}
