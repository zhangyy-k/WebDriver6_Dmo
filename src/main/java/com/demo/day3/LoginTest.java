package com.demo.day3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Administrator on 2017-4-11.
 */
public class LoginTest extends BaseCase {

    /**
     *@Author zhangyy
     *@Date 2017-4-11 16:04
     * 正确登录
     */
    @Test
    @Issue("登录成功bug_id")
    @TestCaseId("登录成功id")
    @Title("登录成功title")
    public void loginTest() throws InterruptedException {
        webDriver.get("http://mail.163.com/");
        webDriver.manage().window().maximize();
        //把控制权交给注册按钮所在的iframe
        this.login("yuxuan110400","sensy198682");
        Thread.sleep(3000);
        boolean b = webDriver.findElement(By.linkText("退出")).isDisplayed();
        Assert.assertTrue(b);
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-11 16:20
     * 账号正确，密码错误
     */
    @Test
    @Issue("登录失败bug_id")
    @TestCaseId("登录失败id")
    @Title("登录失败title")
    public void loginFailTest(){
        webDriver.get("http://mail.163.com/");
        webDriver.manage().window().maximize();
        //把控制权交给注册按钮所在的iframe
        this.login("yuxuan110400","sfsdfs");
        String text= webDriver.findElement(By.xpath(".//*[@id='nerror']/div[2]")).getText().trim();
        Assert.assertEquals(text,"帐号或密码错误");
    }

    public void login(String email,String password){
        //把控制权交给注册按钮所在的iframe
        webDriver.switchTo().frame("x-URS-iframe");
        webDriver.findElement(By.name("email")).sendKeys(email);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.id("dologin")).click();
    }
}
