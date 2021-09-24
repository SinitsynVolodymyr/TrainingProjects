package com;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamInteger {

    public static void main(String[] args) {

        int[] ints = generateIntegerArray();
        IntStream intStream = Arrays.stream(ints);
    }


    public static int[] generateIntegerArray(){
        int[] result = {20,10,-5,6,42,-36,-123,542,22};
        return result;
    }

}