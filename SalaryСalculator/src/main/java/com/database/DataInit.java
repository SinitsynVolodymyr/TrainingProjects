package com.database;

import com.entity.ManagerDepartment;
import com.entity.OthersDepartment;
import com.entity.empl.Employee;
import com.entity.empl.Manager;
import com.entity.empl.OthersEmployee;
import com.exception.SalaryIsTooSmallException;
import com.view.View;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataInit {


    public static List<ManagerDepartment> initDepartments() throws SalaryIsTooSmallException {
        List<ManagerDepartment> result = new ArrayList<>();

        Manager manager1 = new Manager("КОВАЛЕНКО", new Date(811081984000L), new Date(1536928415000L),new BigDecimal("8000"));
        manager1.addEmployee(new Employee("БОНДАР", new Date(937312384000L), new Date(1630499615000L),new BigDecimal("2000")));
        manager1.addEmployee(new Employee("САВЧЕНКО", new Date(916317184000L), new Date(1630499615000L),new BigDecimal("2500")));
        manager1.addEmployee(new Employee("ГАВРИЛЮК", new Date(918995584000L), new Date(1630499615000L),new BigDecimal("1500")));
        manager1.addEmployee(new Employee("БОНДАР", new Date(921414784000L), new Date(1630499615000L),new BigDecimal("1100")));
        manager1.addEmployee(new Employee("КУШНІР", new Date(924093184000L), new Date(1630499615000L),new BigDecimal("2600")));
        manager1.addEmployee(new Employee("КОЛОМІЄЦЬ", new Date(926685184000L), new Date(1630499615000L),new BigDecimal("3200")));
        manager1.addEmployee(new Employee("ПАНЧЕНКО", new Date(929363584000L), new Date(1630499615000L),new BigDecimal("2500")));
        manager1.addEmployee(new Employee("ГУМЕНЮК", new Date(931955584000L), new Date(1630499615000L),new BigDecimal("1300")));
        manager1.addEmployee(new Employee("НАЗАРЕНКО", new Date(934633984000L), new Date(1630499615000L),new BigDecimal("1800")));
        manager1.addEmployee(new Employee("МАКАРЕНКО", new Date(939904384000L), new Date(1630499615000L),new BigDecimal("4200")));
        result.add(new ManagerDepartment("Payout", manager1));

        Manager manager2 = new Manager("КОВАЛЕНКО", new Date(811081984000L), new Date(1536928415000L),new BigDecimal("12000"));
        manager2.addEmployee(new Employee("БОНДАР", new Date(937312384000L), new Date(1630499615000L),new BigDecimal("2000")));
        manager2.addEmployee(new Employee("САВЧЕНКО", new Date(916317184000L), new Date(1630499615000L),new BigDecimal("2500")));
        manager2.addEmployee(new Employee("ГАВРИЛЮК", new Date(918995584000L), new Date(1630499615000L),new BigDecimal("1500")));
        manager2.addEmployee(new Employee("БОНДАР", new Date(921414784000L), new Date(1630499615000L),new BigDecimal("1100")));
        manager2.addEmployee(new Employee("КУШНІР", new Date(924093184000L), new Date(1630499615000L),new BigDecimal("2600")));
        manager2.addEmployee(new Employee("КОЛОМІЄЦЬ", new Date(926685184000L), new Date(1630499615000L),new BigDecimal("3200")));
        manager2.addEmployee(new Employee("ПАНЧЕНКО", new Date(929363584000L), new Date(1630499615000L),new BigDecimal("2500")));
        manager2.addEmployee(new Employee("ГУМЕНЮК", new Date(931955584000L), new Date(1630499615000L),new BigDecimal("1300")));
        manager2.addEmployee(new Employee("НАЗАРЕНКО", new Date(934633984000L), new Date(1630499615000L),new BigDecimal("1800")));
        result.add(new ManagerDepartment("Economy", manager2));

        Manager manager3 = new Manager("КОВАЛЕНКО", new Date(811081984000L), new Date(1536928415000L),new BigDecimal("22000"));
        manager3.addEmployee(new Employee("БОНДАР", new Date(937312384000L), new Date(1630499615000L),new BigDecimal("4200")));
        manager3.addEmployee(new Employee("САВЧЕНКО", new Date(916317184000L), new Date(1630499615000L),new BigDecimal("5300")));
        manager3.addEmployee(new Employee("ГАВРИЛЮК", new Date(918995584000L), new Date(1630499615000L),new BigDecimal("8000")));
        manager3.addEmployee(new Employee("БОНДАР", new Date(921414784000L), new Date(1630499615000L),new BigDecimal("1500")));
        manager3.addEmployee(new Employee("ПАНЧЕНКО", new Date(929363584000L), new Date(1630499615000L),new BigDecimal("3620")));
        manager3.addEmployee(new Employee("ГУМЕНЮК", new Date(931955584000L), new Date(1630499615000L),new BigDecimal("4500")));
        manager3.addEmployee(new Employee("НАЗАРЕНКО", new Date(934633984000L), new Date(1630499615000L),new BigDecimal("2500")));
        manager3.addEmployee(new Employee("МАКАРЕНКО", new Date(939904384000L), new Date(1630499615000L),new BigDecimal("3500")));
        result.add(new ManagerDepartment("Development", manager3));

        return result;
    }

    public static OthersDepartment initOthers() throws SalaryIsTooSmallException {

        OthersDepartment result = new OthersDepartment(View.othersName);

        result.addEmployee(new OthersEmployee("БОНДАРЧУК",new Date(500819584), new Date(1472733215),new BigDecimal("45000"),"Director"));
        result.addEmployee(new OthersEmployee("ДЕРКАЧ",new Date(503411584), new Date(1472733215),new BigDecimal("3500"),"Consultant"));
        result.addEmployee(new OthersEmployee("СЕРГІЄНКО",new Date(495549184), new Date(1472733215),new BigDecimal("2300"),"Secretary"));
        result.addEmployee(new OthersEmployee("БОДНАР",new Date(832077184), new Date(1472733215),new BigDecimal("8600"),"HR"));

        return result;
    }

}
