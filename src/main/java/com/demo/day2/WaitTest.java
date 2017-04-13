package com.demo.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by yunyan on 2017/4/8.
 */
public class WaitTest {

    private WebDriver webDriver ;

    @BeforeMethod
    public void open(){
        System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
        webDriver = new ChromeDriver();

        //全局等待
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }

    /**
     *@Author zhangyy
     *@Date 2017/4/1020:25
     * 元素等待处理
     */
    @Test
    public void waitE(){
        webDriver.get("file:///F:/2017/selenium_html/index.html");
        WebElement waitButton = webDriver.findElement(By.xpath("//*[@id=\"wait\"]/input"));
        waitButton.click();

//        显示等待
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div[1]")));

        String text = webDriver.findElement(By.xpath("//*[@id=\"display\"]/div[1]")).getText();
        Assert.assertEquals(text,"wait for display");

    }
}
