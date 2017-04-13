package com.demo.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by yunyan on 2017/4/10.
 */
public class WindowTest {

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
     *@Date 2017/4/1020:37
     * 打开自动化测试页面
     * 点击 open new window
     * 返回初始页面点击baidu
     */
    @Test
    public void windowTest() throws InterruptedException {
        webDriver.get("file:///E:/2017/selenium_html/demo1.html");
        //打开新window窗口
        webDriver.findElement(By.linkText("Open new window")).click();
        //获取webdriver所在窗口的句柄
        String handle1 = webDriver.getWindowHandle();

        //第一种方式：把控制权转交给初始window句柄
//        webDriver.switchTo().window(handleOne);
//        webDriver.findElement(By.linkText("baidu")).click();

        //第二种方式：
        //获取浏览器中所有windows窗口句柄
        for(String handles : webDriver.getWindowHandles()){
            if(!handles.equals(handle1))
                continue;
            webDriver.switchTo().window(handles);
        }
        webDriver.findElement(By.linkText("baidu")).click();
    }
}
