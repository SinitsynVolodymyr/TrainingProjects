package com.hellomvc;

/**
 * Created by User on 17.03.2016.
 */
public class Model {
    public static final String FIRST_WORD = "Hello";
    public static final String SECOND_WORD = "world!";
    public static final String SEPARATOR = " ";

    private String value;
    private int countWords = 0;

    // The Program logic

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        countWords = 1;
    }

    public void addValue(String value) {
        this.value += value;
        countWords++;
    }

    // The Checker business logic
    public boolean checkValueToCorrect(String input) {
        if (countWords==0){
            if (input.equals(Model.FIRST_WORD)){
                return true;
            }
        }else if(countWords==1){
            if (input.equals(Model.SECOND_WORD)){
                return true;
            }
        }
        return false;
    }
}
