package com;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

class ArithmeticsTest {

    Arithmetics a;

    void runBefore(){
        a = new Arithmetics();
        System.out.println("Arithmetic create!");
    }

    @Test
    void add() {
        double res = a.add(3, 7);
        if (res!=10) Assert.fail("Fail 'if'");
        Assert.assertTrue(res==10);
        Assert.assertFalse(res!=10);
        Assert.assertNotNull(a);
        Assert.assertEquals(res,10.0);
    }

    @Ignore
    @Test
    void deduct() {
        double res = a.deduct(3, 7);
        Assert.assertEquals(res,-4);
    }

    @Test
    void multiply() {
        double res = a.multiply(3, 7);
        Assert.assertEquals(res,21);
    }

    @Test
    void div() {
        double res = a.div(3, 6);
        Assert.assertEquals(res,0.5);

    }



}