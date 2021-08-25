package com;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private int minRandValue = 3;
    private int maxRandValue = 5;

    @Test
    void rand() {
        int randResult = Model.rand();
        assertTrue(randResult>=0&&randResult<=Model.RAND_MAX);
    }

    List<Integer> initRandIntegerListWithDifferentValues(){
        int amountIteration = 100;

        List<Integer> resultList = new ArrayList<>();
        for (int i=0;i<amountIteration;i++){
            resultList.add(Model.rand(minRandValue,maxRandValue));
        }

        return resultList;
    }

    @Test
    void rand_WITH_DIFFERENT_VALUES_TRUE() {
        List<Integer> resultList = initRandIntegerListWithDifferentValues();

        assertTrue(resultList.contains(minRandValue));
        assertTrue(resultList.contains(maxRandValue));
    }

    @Test
    void rand_WITH_DIFFERENT_VALUES_FALSE() {
        List<Integer> resultList = initRandIntegerListWithDifferentValues();

        for (Integer resTmp : resultList){
            assertFalse(resTmp > maxRandValue);
            assertFalse(resTmp < minRandValue);
        }

    }
}