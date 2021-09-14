package com.controller;

import com.entity.Company;
import com.entity.Department;
import com.entity.SalariesFund;
import com.model.Model;
import com.view.View;

import java.math.BigDecimal;
import java.util.Locale;
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
        SalariesFund companyFund = initFund(scanner, " company");
        model.setFund(companyFund);

        for (Department depTmp: model.getDepartmentList()){
            SalariesFund fund = initFund(scanner, depTmp.getName().toLowerCase(Locale.ROOT));
            depTmp.setFund(fund);
        }

    }

    public SalariesFund initFund(Scanner sc, String fundName){
        BigDecimal sizeFund = getUserDoubleValueAnswer(sc);
        view.print("Is balanced "+fundName+" fund?");
        boolean isBalanced = getUserTrueFalseAnswer(sc);
        SalariesFund.FundType type = SalariesFund.FundType.UNBALANCED;
        if (isBalanced)
            type = SalariesFund.FundType.BALANCED;
        return new SalariesFund(sizeFund, type);
    }


    public boolean getUserTrueFalseAnswer(Scanner sc){
        view.print(View.yesNoQuestionMessage);
        String input = "";
        while (!(sc.hasNext()
                && ((input = sc.nextLine()).equalsIgnoreCase("Y")
                || input.equalsIgnoreCase("N")))){
            view.print(View.wrongInputMessage);
            view.print(View.yesNoQuestionMessage);
        }
        if (input.equalsIgnoreCase("Y")) return true;
        else return false;
    }

    public BigDecimal getUserDoubleValueAnswer(Scanner sc){
        view.print(View.inputSalaryFundMessage);
        String input = "";
        while (!sc.hasNextDouble()){
            view.print(View.wrongInputMessage);
            view.print(View.inputSalaryFundMessage);
        }

        return new BigDecimal(sc.nextDouble());
    }


}
