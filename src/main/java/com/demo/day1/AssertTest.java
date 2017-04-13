package com.demo.day1;

import org.junit.Test;
import org.testng.Assert;

/**
 * Created by Administrator on 2017-4-6.
 */
public class AssertTest {

    @Test
    public  void testEquals(){
        String a = "1234";
        String b = "1234";
        Assert.assertEquals(a,b);
    }

    @Test
    public  void testNoEquals(){
        int a = 1;
        int b =2;
        Assert.assertNotEquals(a,b);
    }
}
