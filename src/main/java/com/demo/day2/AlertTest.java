package com.demo.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.TreeMap;

/**
 * Created by Administrator on 2017-4-10.
 */
public class AlertTest {

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
     *@Date 2017-4-10 13:30
     * 打开自动化测试界面
     * 点击Alert按钮
     * 在Alert警告框中点击确定按钮
     */
    @Test
    public void alertTest() throws InterruptedException {
        webDriver.get("file:///E:/2017/selenium_html/index.html");
        webDriver.manage().window().maximize();
        //定位alert按钮
        webDriver.findElement(By.xpath(".//*[@id='alert']/input[1]")).click();
        //把控制权转交给alert
        Thread.sleep(3000);
        Alert alert = webDriver.switchTo().alert();
        //获取警告框文本
        String text = alert.getText();
        //点击确定按钮
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 13:37
     * 打开自动化测试界面
     * 点击confirm按钮
     * 在confirm警告框中点击确定按钮
     */
    @Test
    public void confirmTest() throws InterruptedException {
        webDriver.get("file:///E:/2017/selenium_html/index.html");
        webDriver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert alert = webDriver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 13:40
     * 打开自动化测试界面
     * 点击prompt按钮
     * 在prompt弹窗中，输入“这是个prompt”
     * 点击确定按钮
     */
    @Test
    public void promptTest() throws InterruptedException {
        webDriver = new FirefoxDriver();
        webDriver.get("file:///E:/2017/selenium_html/index.html");
        webDriver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("这是个prompt");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
        webDriver.quit();

    }

}
