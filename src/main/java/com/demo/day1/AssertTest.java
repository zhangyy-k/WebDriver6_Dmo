package com.demo.day1;

import org.junit.Test;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Administrator on 2017-4-6.
 */
public class AssertTest {

    @Test
    @Issue("testEquals")
    @TestCaseId("testEquals_id")
    @Title("testEquals_title")
    public  void testEquals(){
        String a = "1234";
        String b = "123";
        Assert.assertEquals(a,b);
    }

    @Test
    @Issue("testNoEquals")
    @TestCaseId("testNoEquals_id")
    @Title("testNoEquals_title")
    public  void testNoEquals(){
        int a = 1;
        int b =2;
        Assert.assertNotEquals(a,b);
    }
}
