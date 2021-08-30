package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    public static final int RAND_MAX = 100;

    private int value;
    private List<Integer> historyNumberList = new ArrayList<>();
    private int minValue = 0;
    private int maxValue = RAND_MAX;

    public Model() {
        value = rand();
    }

    public List<Integer> getHistoryNumberList() {
        return historyNumberList;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public static int rand(){
        return rand(0, RAND_MAX);
    }

    public static int rand(int minValueInput, int maxValueInput){
        Random randObj = new Random();
        int randRange = maxValueInput - minValueInput - 1;
        int result = randObj.nextInt(randRange) + minValueInput + 1;
        return result;
    }


    public ComparisonResult checkValueAndRealizeIt(int inputValue){
        historyNumberList.add(inputValue);
        ComparisonResult result = checkValue(inputValue);
        realizeResult(result,inputValue);

        return result;
    }

    public ComparisonResult checkValue(int inputValue){
        if (inputValue<=minValue||inputValue>=maxValue){
            return ComparisonResult.OVER_THE_RANGE;
        }else if(inputValue>value){
            return ComparisonResult.IS_BIGGEST;
        }else if(inputValue<value){
            return ComparisonResult.IS_LOWEST;
        }else{
            return ComparisonResult.RIGHT_NUMBER;
        }
    }

    private void realizeResult(ComparisonResult result,int inputValue){
        if (result.equals(ComparisonResult.IS_BIGGEST)){
            maxValue = inputValue;
        }else if(result.equals(ComparisonResult.IS_LOWEST)){
            minValue = inputValue;
        }
    }


    enum ComparisonResult{
        IS_BIGGEST, IS_LOWEST, OVER_THE_RANGE, RIGHT_NUMBER;
    }

}
