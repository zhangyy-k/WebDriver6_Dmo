package com.demo.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by yunyan on 2017/4/10.
 */
public class SelectTest {
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
     *@Date 2017/4/1021:18
     * 下拉框选中
     */
    @Test
    public void selectTest() throws InterruptedException {
        webDriver.get("file:///F:/2017/selenium_html/index.html");
        //定位下拉框
        WebElement element = webDriver.findElement(By.id("moreSelect"));
        //实例化 一个新的 select对象
        Select select = new Select(element);
        //根据索引来选取，从0开始
        select.selectByIndex(0);
        //根据属性value的属性值来选取
        Thread.sleep(3000);
        select.selectByValue("oppe");
        //根据标签之间的Text值，也就是页面显示的
        Thread.sleep(3000);
        select.selectByVisibleText("huawei");
    }
}
