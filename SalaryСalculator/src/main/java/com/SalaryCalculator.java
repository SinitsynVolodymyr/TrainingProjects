package com;


import com.controller.Controller;
import com.model.Model;
import com.view.View;

import java.util.ArrayList;

public class SalaryCalculator {

    public static void main(String[] args) {
        Model model = new Model(new ArrayList<>(),new ArrayList<>());
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.userInput();

    }

}
