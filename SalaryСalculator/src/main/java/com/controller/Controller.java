package com.controller;

import com.entity.Company;
import com.model.Model;
import com.view.View;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void userInput(){
        Scanner scanner = new Scanner(System.in);
        initFund(scanner);
    }

    public void initFund(Scanner sc){

        view.print("Is only company fund?");
    }




}
