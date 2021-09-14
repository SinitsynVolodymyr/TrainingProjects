package com.view;

import com.entity.empl.Employee;
import com.model.PayForOnePerson;
import com.model.Payroll;
import de.vandermeer.asciitable.AsciiTable;

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
        at.addRow(generateFirstRow(new String[]{"Name", "Department", "Rate", "Salary","Premium"}));
        at.addRule();

        for (PayForOnePerson person: payroll.personList){
            at.addRow(generateRow(person));
            at.addRule();
        }

        this.print(at.render());
    }


    private static String[] generateFirstRow(String[] collumName){
        List<String> firstRow = new ArrayList<>();
        for (String moveTmp: collumName) {
            firstRow.add(moveTmp);
        }
        return firstRow.toArray(new String[0]);
    }

    private static String[] generateRow(PayForOnePerson payForOnePerson){
        List<String> row = new ArrayList<>();
        row.add(payForOnePerson.getEmployee().getName());
        row.add(payForOnePerson.getDepartmentName());
        row.add(payForOnePerson.getEmployee().getSalary().toString());
        row.add(payForOnePerson.getSalary().toString());
        row.add(payForOnePerson.getPremium().toString());

        return row.toArray(new String[0]);
    }

}
