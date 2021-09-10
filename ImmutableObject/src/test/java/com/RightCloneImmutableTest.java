package com;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class RightCloneImmutableTest {


    @Test
    public void useImmutableObjectTest(){
        Date dateStart = new Date(100);
        dateStart.setTime(1000);
        Date dateEnd = new Date(2000);
        RightCloneImmutable im = new RightCloneImmutable(dateStart, dateEnd);
        dateStart.setTime(5000);
        dateEnd.setTime(8000);

        Assert.assertEquals(im.getStart().getTime(),1000);
        Assert.assertEquals(im.getEnd().getTime(),2000);

    }


    @Test
    public void hackImmutableObjectTest_FAIL(){
        Date dateStart = new MyDate(100);
        dateStart.setTime(1000);
        Date dateEnd = new MyDate(2000);
        RightCloneImmutable im = new RightCloneImmutable(dateStart, dateEnd);
        dateStart.setTime(5000);
        dateEnd.setTime(8000);

        Assert.assertEquals(im.getStart().getTime(),1000);
        Assert.assertEquals(im.getEnd().getTime(),2000);

    }

    class MyDate extends Date{

        public MyDate(long date) {
            super(date);
        }

        @Override
        public Object clone() {
            return this;
        }
    }

}