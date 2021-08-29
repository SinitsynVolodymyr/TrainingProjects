package com;

import java.util.Scanner;
import com.Model.ComparisonResult;

public class Controller {

    // Constructor
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // Test commit
    // Test commit2
    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        ComparisonResult result = ComparisonResult.OVER_THE_RANGE;
        while (!result.equals(ComparisonResult.RIGHT_NUMBER)) {
            view.printMessage(String.format(View.SHOW_ATTEMPTED_FORMAT, model.getHistoryNumberList()));
            view.printMessage(String.format(View.CORRECT_RANGE_FORMAT,model.getMinValue(),model.getMaxValue()));

            int inputValue = inputIntValueWithScanner(sc);
            result = model.checkValueAndRealizeIt(inputValue);

            if (result.equals(ComparisonResult.OVER_THE_RANGE)) {
                view.printMessage(View.WRONG_INT_RANGE);
            }else if (result.equals(ComparisonResult.IS_BIGGEST)) {
                view.printMessage(View.NUMBER_IS_BIGGER);
            }else if (result.equals(ComparisonResult.IS_LOWEST)) {
                view.printMessage(View.NUMBER_IS_LESS);
            }
        }

        view.printMessage(View.SUCCESS_INT_DATA);
        view.printMessage(String.format(View.SHOW_ATTEMPTED_FORMAT, model.getHistoryNumberList()));

    }

    // The Utility method
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_INT_DATA);

        while( ! sc.hasNextInt()) {
            view.printMessage(View.WRONG_INT_DATA + View.SEPARATOR + View.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }


}
