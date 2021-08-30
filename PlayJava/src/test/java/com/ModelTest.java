package com;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private static Map<Integer, Model.ComparisonResult> results = new HashMap<>();
    private static int minCheckValue = -100;
    private static int maxCheckValue = 200;
    private static Model model ;
    private static int amountIteration = 10000;
    private static List<Integer> randomList = new ArrayList<>();


    private int minRandValue = 0;
    private int maxRandValue = Model.RAND_MAX;

    @BeforeAll
    static void initResults(){
        model = new Model();
        for (int i = minCheckValue; i<=maxCheckValue; i++){
            results.put(i, model.checkValue(i));
        }
    }

    //If you want to test rand() uncomment the @BeforeAll
    //@BeforeAll
    static void initRandIntegerListWithDifferentValues(){
        for (int i=0;i<amountIteration;i++){
            randomList.add(Model.rand());
        }
    }

    @Test
    void rand() {
        int randResult = Model.rand();
        assertTrue(randResult>=0&&randResult<=Model.RAND_MAX);
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

    @Test
    void checkValue_NOTNULL() {
        assertFalse(results.values().contains(null));
    }

    @Test
    void checkValue_OUT_OF_RANGE() {
        assertTrue(results.values().contains(
                Model.ComparisonResult.OVER_THE_RANGE));

        for (Map.Entry<Integer,
                Model.ComparisonResult> entry : results.entrySet()) {
            if (entry.getKey()<=0||entry.getKey()>=Model.RAND_MAX){
                assertEquals(entry.getValue(), Model.ComparisonResult.OVER_THE_RANGE);
            }
        }
    }

    @Test
    void checkValue_IN_RANGE() {
        assertTrue(results.values().contains(
                Model.ComparisonResult.IS_BIGGEST));
        assertTrue(results.values().contains(
                Model.ComparisonResult.IS_LOWEST));

        boolean isFoundRightValue = false;
        for (Map.Entry<Integer,
                Model.ComparisonResult> entry : results.entrySet()) {

            if (entry.getKey()>0&&entry.getKey()<Model.RAND_MAX){
                boolean isBiggest = entry.getValue().equals(Model.ComparisonResult.IS_BIGGEST);
                boolean isLowest = entry.getValue().equals(Model.ComparisonResult.IS_LOWEST);

                if (entry.getValue().equals(Model.ComparisonResult.RIGHT_NUMBER)){
                    isFoundRightValue = true;
                    continue;
                }

                if (isFoundRightValue){
                    assertTrue(isBiggest);
                    assertFalse(isLowest);
                }else{
                    assertTrue(isLowest);
                    assertFalse(isBiggest);
                }
            }
        }
    }

    @Test
    void checkValue_RIGHT_VALUE() {
        assertTrue(results.values().contains(
                Model.ComparisonResult.RIGHT_NUMBER));

        boolean isFoundRightValue = false;
        for (Map.Entry<Integer,
                Model.ComparisonResult> entry : results.entrySet()) {
            if (entry.getValue().equals(
                    Model.ComparisonResult.RIGHT_NUMBER)) {
                assertTrue(entry.getKey() > 0 && entry.getKey() < Model.RAND_MAX);
                assertFalse(isFoundRightValue);
                isFoundRightValue = true;
            }
        }
    }

    @Test
    void checkValueAndRealizeIt_CHANGE_LOW_RANGE() {
        int minValue = 1;
        Model model = null;
        int amountIt = 100;
        for (int i = 0; i< amountIt; i++)
        model = new Model();
        Model.ComparisonResult resultLowValue = model.checkValueAndRealizeIt(minValue);
        if (!resultLowValue.equals(
                Model.ComparisonResult.RIGHT_NUMBER)){
            assertEquals(model.checkValueAndRealizeIt(minValue),
                    Model.ComparisonResult.OVER_THE_RANGE);
        }
    }

    @Test
    void checkValueAndRealizeIt_CHANGE_BIG_RANGE() {
        int maxValue = Model.RAND_MAX-1;
        Model model = null;
        int amountIt = 100;
        for (int i = 0; i< amountIt; i++)
        model = new Model();
        Model.ComparisonResult resultLowValue = model.checkValueAndRealizeIt(maxValue);
        if (!resultLowValue.equals(
                Model.ComparisonResult.RIGHT_NUMBER)){
            assertEquals(model.checkValueAndRealizeIt(maxValue),
                    Model.ComparisonResult.OVER_THE_RANGE);
        }
    }
}