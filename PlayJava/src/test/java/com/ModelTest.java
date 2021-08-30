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


    private int minRandValue = 3;
    private int maxRandValue = 5;

    @BeforeAll
    static void initResults(){
        model = new Model();
        for (int i = minCheckValue; i<=maxCheckValue; i++){
            results.put(i, model.checkValue(i));
        }
    }

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


}