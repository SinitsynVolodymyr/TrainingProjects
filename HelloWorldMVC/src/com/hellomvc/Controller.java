package com.hellomvc;

import java.util.Scanner;

public class Controller {

    // Constructor
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setValue(inputStringValueWithScanner(sc));
        model.addValue(Model.SEPARATOR);
        model.addValue(inputStringValueWithScanner(sc));

        view.printMessageAndInt(View.OUR_STRING, model.getValue());
    }

    // The Utility method
    public String inputStringValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_STRING_DATA);

        String input = sc.nextLine();

        while( !model.checkValueToCorrect(input)) {
            view.printMessage(View.WRONG_INPUT_STRING_DATA +View.SEPARATOR+ View.INPUT_STRING_DATA);
            input = sc.nextLine();
        }
        return input;
    }

}
