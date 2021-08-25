package com;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void rand() {
        int randResult = Model.rand();
        assertTrue(randResult>=0&&randResult<=Model.RAND_MAX);
    }

    @Test
    void rand_WITH_DIFFERENT_VALUES_TRUE() {
        int minValue = 3;
        int maxValue = 5;
        int amountIteration = 100;

        List<Integer> resultList = new ArrayList<>();
        for (int i=0;i<amountIteration;i++){
            resultList.add(Model.rand(minValue,maxValue));
        }

        assertTrue(resultList.contains(minValue));
        assertTrue(resultList.contains(maxValue));
    }

    @Test
    void rand_WITH_DIFFERENT_VALUES_FALSE() {
        int minValue = 3;
        int maxValue = 5;
        int amountIteration = 100;

        List<Integer> resultList = new ArrayList<>();
        for (int i=0;i<amountIteration;i++){
            resultList.add(Model.rand(minValue,maxValue));
        }

        for (Integer resTmp : resultList){
            assertFalse(resTmp > maxValue);
            assertFalse(resTmp < minValue);
        }

    }
}