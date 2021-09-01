package com;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    static public List<View> viewList = new ArrayList<>();

    @BeforeAll
    static void initView(){
        for (View.Land landTmp : View.Land.values()){
            viewList.add(new View(landTmp));
        }
    }

    /**
     * Visible test
     */
    @Test
    void print() {
        for (View viewTmp : viewList) {
            viewTmp.print("Test message");
        }
    }

    /**
     * Visible test
     */
    @Test
    void printWithLand() {
        for (View viewTmp : viewList) {
            viewTmp.printWithLand(new String[]{
                    "input.data",
                    "input.format",
                    "input.firstname"
            });
            viewTmp.printWithLand(new String[]{
                    "input.data",
                    "input.format",
                    "input.nick"
            });
            viewTmp.printWithLand(new String[]{
                    "input.data",
                    "input.format",
                    "input.secPhone"
            });
        }
    }

    /**
     * Test init Land object in View
     */
    @Test
    void getLand() {
        int index = 0;
        for (View viewTmp : viewList) {
            assertEquals(viewTmp.getLand(),View.Land.values()[index++]);
        }

    }
}