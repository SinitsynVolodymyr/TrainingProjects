package com.view;

import com.model.PayForOnePerson;
import com.model.Payroll;
import de.vandermeer.asciitable.AsciiTable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class View {

    public static final String yesNoQuestionMessage = "Input 'Y' or 'N' please:";
    public static final String minSalaryFundMessageFormat = "Min value is %s:";
    public static final String inputSalaryFundMessage = "Input a salary fund company:";
    public static final String inputCalcDateMessage = "Input a calculated date in format [dd/mm/yyyy]:";
    public static final String inputCalcDateRegex = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    public static final String wrongSalaryFundMessage = "Input a salary fund is less than need, please repeat.";
    public static final String inputIsBalancedFundMassageFormat = "Is balanced %s fund?";
    public static final String othersName = "Others";
    public static final String companyName = "Company";
    public static final String wrongInputMessage = "Wrong input message.";

    public void print(String message){
        System.out.println(message);
    }

    public void printPayroll(Payroll payroll){
        AsciiTable at = new AsciiTable();

        at.addRule();
        at.addRow(generateFirstRow(
                new String[]{"Name", "Department","Fund type", "Rate", "Premium", "Premium birthday", "Salary"}));
        at.addRule();

        for (PayForOnePerson person: payroll.personList){
            at.addRow(generateRow(person));
            at.addRule();
        }

        at.addRow(generateFinalRow(payroll));
        at.addRule();

        this.print(at.render());
    }


    private static String[] generateFirstRow(String[] collumName){
        List<String> firstRow = new ArrayList<>();
        for (String collum: collumName) {
            firstRow.add(collum);
        }
        return firstRow.toArray(new String[0]);
    }

    private static String[] generateRow(PayForOnePerson payForOnePerson){
        List<String> row = new ArrayList<>();
        row.add(payForOnePerson.getEmployee().getName());
        row.add(payForOnePerson.getDepartment().getName());
        row.add(payForOnePerson.getDepartment().getFund().getType().getName());
        row.add(payForOnePerson.getEmployee().getRate().toString());
        row.add(payForOnePerson.getPremium().toString());
        row.add(payForOnePerson.getPremiumBirthday().toString());
        row.add(payForOnePerson.getSalary().toString());

        return row.toArray(new String[0]);
    }

    private static String[] generateFinalRow(Payroll payroll){
        List<String> finalRow = new ArrayList<>();

        BigDecimal rate = new BigDecimal("0");
        BigDecimal salary = new BigDecimal("0");
        BigDecimal premium = new BigDecimal("0");
        BigDecimal premiumBirthday = new BigDecimal("0");

        for(PayForOnePerson person: payroll.personList){
            rate = rate.add(person.getEmployee().getRate());
            premium = premium.add(person.getPremium());
            premiumBirthday = premiumBirthday.add(person.getPremiumBirthday());
            salary = salary.add(person.getSalary());
        }

        finalRow.add("-");
        finalRow.add("-");
        finalRow.add("-");
        finalRow.add(rate.toString());
        finalRow.add(premium.toString());
        finalRow.add(premiumBirthday.toString());
        finalRow.add(salary.toString());

        return finalRow.toArray(new String[0]);
    }

}
