package com;


import com.controller.Controller;
import com.database.DataInit;
import com.exception.SalaryIsTooSmallException;
import com.model.Model;
import com.view.View;

import java.util.ArrayList;

public class SalaryCalculator {

    public static void main(String[] args) throws SalaryIsTooSmallException {
        Model model = new Model(DataInit.initOthers(),DataInit.initDepartments());
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.userInput();

    }

}
