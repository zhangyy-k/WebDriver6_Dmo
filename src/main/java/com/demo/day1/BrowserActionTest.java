package com.demo.day1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017-4-6.
 */
public class BrowserActionTest {

    private WebDriver webDriver;

    @BeforeMethod
    public void open(){
        System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public  void test1(){
        //窗口最大化
        webDriver.manage().window().maximize();
        webDriver.get("http://www.baidu.com");
        String currentURL = webDriver.getCurrentUrl();
        String title = webDriver.getTitle();
        System.out.println(title);
        Assert.assertEquals("https://www.baidu.com/",currentURL);
    }

    @Test
    public  void test2() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        webDriver.get("http://www.glodonedu.com");
        webDriver.navigate().back();
        webDriver.navigate().forward();
        Thread.sleep(3000);
        webDriver.navigate().refresh();
    }

    @Test
    public void screenShotFile(){
        webDriver.get("http://www.baidu.com");
        //截图
        //指定了OutputType.FILE做为参数传递给getScreenshotAs()方法，其含义是将截取的屏幕以文件形式返回。
        File screemShotFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try{
            //利用FileUtils工具类的copyFile()方法保存getScreenshotAs()返回的文件对象。
            FileUtils.copyFile(screemShotFile,new File("e:/test.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }
}
