package com.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RepeaterCalculator {

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(5);
        test.add(-6);
        test.add(4);
        test.add(5);
        test.add(3);
        test.add(4);
        test.add(2);
        test.add(4);
        test.add(5);
        test.add(7);

        System.out.println(calc(test));

    }


    public static Map<Integer, Integer> calc(ArrayList<Integer> list){
        Map<Integer, Integer> result = new HashMap<>();
        list.stream().forEach(key -> {
            Integer addValue = result.containsKey(key) ? result.get(key): 0;
            result.put(key,1+addValue);
        });

        return result;
    }

}
