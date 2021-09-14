package com.entity;

import com.entity.empl.Employee;
import com.entity.empl.Manager;
import com.entity.empl.OthersEmployee;
import com.exception.SalaryIsTooSmallException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee natasha1;
    Employee misha1;

    Employee natasha2;
    Employee misha2;

    @BeforeEach
    void init() throws SalaryIsTooSmallException {
         natasha1 = new OthersEmployee("Natasha","Director", new Date(1284237214), new Date(1599856414));
         misha1 = new Manager("Misha", new Date(1315773214), new Date(1442003614));

         natasha2 = new OthersEmployee("Natasha","Director", new Date(1284237214), new Date(1599856414));
         misha2 = new Manager("Misha", new Date(1315773214), new Date(1442003614));
    }

    @Test
    void testEquals() {

        assertTrue(natasha1.equals(natasha1));
        assertTrue(natasha1.equals(natasha2));
        assertTrue(natasha2.equals(natasha1));

        assertTrue(misha1.equals(misha1));
        assertTrue(misha1.equals(misha2));
        assertTrue(misha2.equals(misha1));

        assertFalse(misha1.equals(natasha1));
        assertFalse(natasha1.equals(misha1));
    }

    @Test
    void testHashCode() {

        assertEquals(natasha1.hashCode(),natasha1.hashCode());
        assertEquals(natasha1.hashCode(),natasha2.hashCode());
        assertEquals(natasha2.hashCode(),natasha1.hashCode());

        assertEquals(misha1.hashCode(),misha1.hashCode());
        assertEquals(misha1.hashCode(),misha2.hashCode());
        assertEquals(misha2.hashCode(),misha1.hashCode());

        assertNotEquals(misha1.hashCode(),natasha1.hashCode());
        assertNotEquals(natasha1.hashCode(),misha1.hashCode());


    }
}