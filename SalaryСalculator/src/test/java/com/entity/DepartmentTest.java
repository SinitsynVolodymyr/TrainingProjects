package com.entity;

import com.entity.empl.Employee;
import com.entity.empl.Manager;
import com.entity.empl.OthersEmployee;
import com.exception.SalaryIsTooSmallException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DepartmentTest {

    ManagerDepartment department1;
    ManagerDepartment department2;

    @BeforeEach
    void init() throws SalaryIsTooSmallException {
        Employee natasha1 = new OthersEmployee("Natasha","Director", new Date(1284237214), new Date(1599856414));
        Employee misha1 = new OthersEmployee("Misha","Developer", new Date(1315773214), new Date(1442003614));
        Employee natasha2 = new OthersEmployee("Natasha","Director", new Date(1284237214), new Date(1599856414));
        Employee misha2 = new OthersEmployee("Misha","Developer", new Date(1315773214), new Date(1442003614));

        department1 = new ManagerDepartment("dep"
                , new Manager("jj",new Date(1000), new Date(2000)));
        department1.setFund(new SalariesFund(SalariesFund.FundType.BALANCED));
        department1.addEmployee(natasha1);
        department1.addEmployee(misha1);

        department2 = new ManagerDepartment("dep"
                , new Manager("jj",new Date(1000), new Date(2000)));
        department2.setFund(new SalariesFund(SalariesFund.FundType.BALANCED));
        department2.addEmployee(natasha2);
        department2.addEmployee(misha2);

    }

    @Test
    void testEquals() {
        assertTrue(department1.equals(department1));
        assertTrue(department1.equals(department2));
        assertTrue(department2.equals(department1));
    }

    @Test
    void testHashCode() {
        assertEquals(department1.hashCode(),department1.hashCode());
        assertEquals(department1.hashCode(),department2.hashCode());
        assertEquals(department2.hashCode(),department1.hashCode());
    }
}