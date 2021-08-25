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

    public static int rand(){
        return rand(0, RAND_MAX);
    }

    public static int rand(int minValueInput, int maxValueInput){
        Random randObj = new Random();
        int randRange = maxValueInput - minValueInput + 1;
        int result = randObj.nextInt(randRange) + minValueInput;
        return result;
    }



    enum ComparisonResult{
        IS_BIGGEST, IS_LOWEST, OVER_THE_RANGE, RIGHT_NUMBER;
    }

}