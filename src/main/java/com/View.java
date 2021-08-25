package com;

public class View {
    // Text's constants
    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String WRONG_INT_RANGE = "Wrong input! Repeat please!";
    public static final String SEPARATOR = "\n";
    public static final String WRONG_INT_DATA = "The number isn't included in the range";
    public static final String SUCCESS_INT_DATA = "You guessed the number!";
    public static final String NUMBER_IS_LESS = "Your number is less than needed";
    public static final String NUMBER_IS_BIGGER = "Your number is more than needed";
    public static final String CORRECT_RANGE_FORMAT = "The right number included between %s and %s";
    public static final String SHOW_ATTEMPTED_FORMAT = "Your attempted: %s";

    public void printMessage(String message) {
        System.out.println(message);
    }

}
