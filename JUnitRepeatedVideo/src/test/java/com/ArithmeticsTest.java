package com;

import org.junit.*;

public class ArithmeticsTest {

    static Arithmetics a;

    @BeforeClass
   public static void runBefore(){
        a = new Arithmetics();
        System.out.println("Arithmetic create!");
    }

    @Test
    public void add() {
        double res = a.add(3, 7);
        if (res!=10) Assert.fail("Fail 'if'");
        Assert.assertTrue(res==10);
        Assert.assertFalse(res!=10);
        Assert.assertNotNull(a);
        Assert.assertEquals(res,10.0,0.0);
    }

    @Ignore
    @Test
    public void deduct() {
        double res = a.deduct(3, 7);
        Assert.assertEquals(res,-4,0.0);
    }

    @Test
    public void multiply() {
        double res = a.multiply(3, 7);
        Assert.assertEquals(res,21,0.0);
    }

    @Test
    public void div() {
        double res = a.div(3, 6);
        Assert.assertEquals(res,0.5,0.0);

    }

    @Test
    public void testDivException_NOT_RIGHT(){
        try{
            Integer.parseInt("1a");
            Assert.fail();
        }catch (Exception e){ }
    }

    @Test(expected = NumberFormatException.class)
    public void testDivException(){
            Integer.parseInt("1a");
    }



}