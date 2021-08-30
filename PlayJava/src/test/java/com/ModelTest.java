package com;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private int minRandValue = 0;
    private int maxRandValue = Model.RAND_MAX;
    private static int amountIteration = 10000;
    private static List<Integer> randomList = new ArrayList<>();


    //If you want to test rand() uncomment the @BeforeAll
    //@BeforeAll
    static void initRandIntegerListWithDifferentValues(){
        for (int i=0;i<amountIteration;i++){
            randomList.add(Model.rand());
        }
    }

    @Test
    void rand_IN_RANGE() {
        for (int resTmp: randomList) {
            assertTrue(resTmp > 0 && resTmp < Model.RAND_MAX);
        }
    }

    @Test
    void rand_OUT_RANGE() {
        for (int resTmp: randomList) {
            assertFalse(resTmp <= 0 || resTmp >= Model.RAND_MAX);
        }
    }

    @Test
    void rand_RANGE() {
        if (randomList.size()>0) {
            assertFalse(randomList.contains(minRandValue));
            assertFalse(randomList.contains(maxRandValue));
            assertTrue(randomList.contains(minRandValue + 1));
            assertTrue(randomList.contains(maxRandValue - 1));
        }
    }

}