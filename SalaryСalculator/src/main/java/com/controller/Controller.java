package com.controller;

import com.entity.ManagerDepartment;
import com.entity.SalariesFund;
import com.model.Model;
import com.model.Payroll;
import com.view.View;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date userCalcDate = getUserCalcDateAnswer(scanner);
        BigDecimal minFund = model.getMinSalary(userCalcDate);
        SalariesFund companyFund = initFund(scanner, View.companyName.toLowerCase(Locale.ROOT), minFund);
        model.setFund(companyFund);
        initDepartmentTypeOfFund(scanner, model.getDepartmentList());
        model.getOthers().setFund(new SalariesFund(initOthersTypeOfFund(scanner)));

        Payroll payroll = model.calculatePayroll(userCalcDate);
        view.printPayroll(payroll);
    }

    public void initDepartmentTypeOfFund(Scanner sc, List<ManagerDepartment> departmentList){
        for (ManagerDepartment depTmp: departmentList) {
            SalariesFund.FundType fundType = initFundType(sc, depTmp.getName().toLowerCase(Locale.ROOT));
            depTmp.setFund(new SalariesFund(fundType));
        }
    }

    public SalariesFund.FundType initOthersTypeOfFund(Scanner sc){
        return initFundType(sc, View.othersName.toLowerCase(Locale.ROOT));
    }

    public SalariesFund initFund(Scanner sc, String fundName, BigDecimal minValue){
        BigDecimal sizeFund = new BigDecimal("0");
        view.print(String.format(View.minSalaryFundMessageFormat, minValue.toString()));
        while ((sizeFund = getUserDoubleValueAnswer(sc)).compareTo(minValue)<0){
            view.print(View.wrongSalaryFundMessage);
            view.print(String.format(View.minSalaryFundMessageFormat, minValue.toString()));
        }
        SalariesFund.FundType type = initFundType(sc, fundName);
        return new SalariesFund(sizeFund, type);
    }

    public SalariesFund.FundType initFundType(Scanner sc, String fundName){
        view.print(String.format(View.inputIsBalancedFundMassageFormat,fundName));
        boolean isBalanced = getUserTrueFalseAnswer(sc);
        SalariesFund.FundType type = SalariesFund.FundType.UNBALANCED;
        if (isBalanced)
            type = SalariesFund.FundType.BALANCED;
        return type;
    }


    public boolean getUserTrueFalseAnswer(Scanner sc){
        view.print(View.yesNoQuestionMessage);
        String input = "";
        while (!(sc.hasNext() && ((input = sc.next()).equalsIgnoreCase("Y")
                || input.equalsIgnoreCase("N")))){
            view.print(View.wrongInputMessage);
            view.print(View.yesNoQuestionMessage);
        }
        if (input.equalsIgnoreCase("Y")) return true;
        else return false;
    }

    public Date getUserCalcDateAnswer(Scanner sc){
        view.print(View.inputCalcDateMessage);
        String input = "";
        Date date = null;
        boolean isNotExceptionParse = false;
        while (!isNotExceptionParse) {
            while (!(sc.hasNext() && ((input = sc.next()).matches(View.inputCalcDateRegex)))) {
                view.print(View.wrongInputMessage);
                view.print(View.inputCalcDateMessage);
            }
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            isNotExceptionParse= true;
            try {
                date = formatter.parse(input);
            } catch (ParseException e) {
                view.print(View.wrongInputMessage);
                view.print(View.inputCalcDateMessage);
            }
        }

        return date;
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
