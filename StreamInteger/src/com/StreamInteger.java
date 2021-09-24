package com;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class StreamInteger {

    public static void main(String[] args) {

        int[] ints = generateIntegerArray();
        Supplier<IntStream> intStream
                = () -> IntStream.of(ints);

        int mulNumber = 5;

        System.out.println(intStream.get().average().getAsDouble());
        System.out.println(String.valueOf(intStream.get().min().getAsInt()));
        System.out.println(String.valueOf(intStream.get().filter(value -> value == 0).count()));
        System.out.println(String.valueOf(intStream.get().filter(value -> value > 0).count()));
        intStream.get().map(value -> value*mulNumber).forEach(value -> System.out.print(value+" "));
    }


    public static int[] generateIntegerArray(){
        int[] result = {20,10,-5,6,0,42,-36,0,-123,542,22};
        return result;
    }

}