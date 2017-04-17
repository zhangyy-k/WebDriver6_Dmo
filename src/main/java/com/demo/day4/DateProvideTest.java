package com.demo.day4;

import com.demo.day3.BaseCase;
import com.demo.day3.LoginTest;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Administrator on 2017-4-12.
 */
public class DateProvideTest extends BaseCase {

    /**
     *@Author zhangyy
     *@Date 2017-4-12 15:16
     * 数据驱动
     */
    @DataProvider(name = "USERINFO")
    public Object[][] userInfo(){
        return new Object[][]{{"yuxuan110400","sensy198682"},{"yuxuan110400","wrongPassword"},{"wrongUserName","wrongPassword"}};
    }

    @Test(dataProvider = "USERINFO")
    @Issue("登录bug_id")
    @TestCaseId("测试用例id")
    @Title("登录title")
    public void loginTest(String userName,String passWord){
        webDriver.get("http://mail.163.com");
        webDriver.manage().window().maximize();
        login(userName,passWord);
    }

    public void login(String email,String password){
        //把控制权交给注册按钮所在的iframe
        webDriver.switchTo().frame("x-URS-iframe");
        webDriver.findElement(By.name("email")).sendKeys(email);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.id("dologin")).click();
    }

}
