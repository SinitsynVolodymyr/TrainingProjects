package com.entity;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEquals() {
        new Employee("Natasha",new Date(1284237214), new Date(1599856414));


    }

    @Test
    void testHashCode() {
    }
}