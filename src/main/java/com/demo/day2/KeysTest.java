package com.demo.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Administrator on 2017-4-11.
 */
public class KeysTest {
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
     *@Date 2017-4-11 10:48
     * 打开百度页面
     * 按ctrl+s保存
     */
    @Test
    public void saveHtml() throws AWTException, InterruptedException {
        webDriver.get("http://www.baidu.com");
        Robot robot = new Robot();
        //contrle+s,打开保存对话框
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(10000);
        //回车键保存
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-11 13:18
     * 上传文件
     */
    @Test
    public void uploadTest(){
        webDriver.get("file:///E:/2017/selenium_html/index.html");
        webDriver.findElement(By.id("load")).sendKeys("E:\\test0.jpg");
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-11 13:23
     * 下载文件
     */
    @Test
    public void downLoadTest() throws AWTException, InterruptedException {
        //第一种
//        webDriver = new FirefoxDriver();
//        webDriver.get("http://glodonedu.com/rzxt");
//        webDriver.manage().window().maximize();
//        Thread.sleep(3000);
//        //单击下载按钮
//       // webDriver.findElement(By.xpath(".//img[@src='/resources/images/down-btn.png']")).click();
//        webDriver.findElement(By.xpath(".//img[contains(@src,'down-btn.png')]")).click();
//        Thread.sleep(5000);
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);
//        Thread.sleep(5000);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        //第二种
        System.setProperty("webdriver.ie.driver",".\\drivers\\IEDriverServer.exe");
        webDriver = new InternetExplorerDriver();
        webDriver.get("http://glodonedu.com/rzxt");
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath(".//img[contains(@src,'down-btn.png')]")).click();
        Thread.sleep(5000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(5000);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_ALT);

    }

}
