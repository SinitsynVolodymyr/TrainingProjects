package com;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * The user request handler method
     */
    public void processUser(){
        Scanner sc = new Scanner(System.in);

    }

}
