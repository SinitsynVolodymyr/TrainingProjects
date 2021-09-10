package com;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

/**
 * My immutable object
 */
public class ImmutableObject {
    private final int i;

    private ImmutableObject(int i) {
        this.i = i;
    }

    public static ImmutableObject getInstance(int i){
        return new ImmutableObject(i);
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) {
        Date date;
        LocalDate localDate;
    }

}
