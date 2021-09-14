package com.controller;

import com.entity.Department;
import com.entity.SalariesFund;
import com.model.Model;
import com.view.View;

import java.math.BigDecimal;
import java.util.List;
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
        SalariesFund companyFund = initFundWithSize(scanner, View.companyName.toLowerCase(Locale.ROOT));
        model.setFund(companyFund);
        initDepartmentTypeOfFund(scanner, model.getDepartmentList());
        initOthersTypeOfFund(scanner);
    }

    public void initDepartmentTypeOfFund(Scanner sc, List<Department> departmentList){
        for (Department depTmp: departmentList) {
            SalariesFund fund = initFundWithoutSize(sc, depTmp.getName().toLowerCase(Locale.ROOT));
            depTmp.setFund(fund);
        }
    }

    public void initOthersTypeOfFund(Scanner sc){
            SalariesFund fund = initFundWithoutSize(sc, View.othersName.toLowerCase(Locale.ROOT));
    }


    public SalariesFund initFundWithSize(Scanner sc, String fundName){
        BigDecimal sizeFund = getUserDoubleValueAnswer(sc);
        view.print(String.format(View.inputIsBalancedFundMassageFormat,fundName));
        boolean isBalanced = getUserTrueFalseAnswer(sc);
        SalariesFund.FundType type = SalariesFund.FundType.UNBALANCED;
        if (isBalanced)
            type = SalariesFund.FundType.BALANCED;
        return new SalariesFund(sizeFund, type);
    }

    public SalariesFund initFundWithoutSize(Scanner sc, String fundName){
        view.print(String.format(View.inputIsBalancedFundMassageFormat,fundName));
        boolean isBalanced = getUserTrueFalseAnswer(sc);
        SalariesFund.FundType type = SalariesFund.FundType.UNBALANCED;
        if (isBalanced)
            type = SalariesFund.FundType.BALANCED;
        return new SalariesFund(type);
    }


    public boolean getUserTrueFalseAnswer(Scanner sc){
        view.print(View.yesNoQuestionMessage);
        String input = "";
        while (!(sc.hasNext() && ((input = sc.next()).equalsIgnoreCase("Y")
                || input.equalsIgnoreCase("N")))){
            view.print(View.wrongInputMessage);
            view.print(View.yesNoQuestionMessage);
        }
        return false;
    }

    public BigDecimal getUserDoubleValueAnswer(Scanner sc){
        view.print(View.inputSalaryFundMessage);
        while (!sc.hasNextDouble()){
            view.print(View.wrongInputMessage);
            view.print(View.inputSalaryFundMessage);
            sc.next();
        }

        return new BigDecimal(sc.nextDouble());
    }


}
