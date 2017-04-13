package com.demo.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017-4-11.
 */
public class BaseCase {
    public WebDriver webDriver ;

    @BeforeMethod
    public void open(){
        System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }

}
