package com.demo.day1;

import org.testng.annotations.*;

/**
 * Created by Administrator on 2017-4-6.
 */
public class TestngTest {

    @BeforeTest
    public void test3(){
        System.out.println("this is BeforeTest");
    }

    @BeforeMethod
    public void test4(){
        System.out.println("this is BeforeMethod");
    }

    @Test
    public void test1(){
        System.out.println("this is test1");
    }

    @Test
    public void test2(){
        System.out.println("this is test2");
    }

    @AfterMethod
    public void test5(){
        System.out.println("this is AfterMethod");
    }

    @AfterTest
    public void test6(){
        System.out.println("this is AfterTest");
    }

}
