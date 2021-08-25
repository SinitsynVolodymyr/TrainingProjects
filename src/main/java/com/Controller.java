package com;

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
