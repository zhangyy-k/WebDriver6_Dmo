package com.demo.day2;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017-4-10.
 */
public class IframeTest {

    private WebDriver webDriver ;

    @BeforeMethod
    public void open(){
        System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 14:00
     * 打开自动化测试界面
     * 点击百度链接
     */
    @Test
    public void iframeTest(){
        webDriver.get("file:///E:/2017/selenium_html/index.html");
        //把控制权交给iframe
        webDriver.switchTo().frame("aa");
        webDriver.findElement(By.xpath(".//*[@id='link']/a[1]")).click();

        //控制权转交初始界面
        webDriver.switchTo().defaultContent();
        webDriver.findElement(By.linkText("登陆界面")).click();
    }
}
