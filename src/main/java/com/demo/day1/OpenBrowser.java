package com.demo.day1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017-4-6.
 */
public class OpenBrowser {

    private WebDriver webDriver ;

    @Test
    public void openFireFox(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        webDriver = new FirefoxDriver();
    }

    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void openIE(){
        System.setProperty("webdriver.ie.driver",".\\drivers\\IEDriverServer.exe");
        webDriver = new InternetExplorerDriver();
    }

//    @Test
//    public void openEdge(){
//        System.setProperty("webdriver.edge.driver",".\\drivers\\IEDriverServer.exe");
//        webDriver = new EdgeDriver();
//    }


    @Test
    public void openAuther() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        //设置专用浏览器exe路径
        String browser_url = "C:\\Program Files (x86)\\GrandSoft\\GCS_RZ\\3.1\\NWjs\\ksxt.exe";
        ChromeOptions options = new ChromeOptions();
        options.setBinary(browser_url);
        webDriver = new ChromeDriver(options);

        //线程等待5秒
        Thread.sleep(3000);
        //隐示等待20秒
//        webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        //显示等待20秒
//        WebDriverWait wait = new WebDriverWait(webDriver,20);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='administratorAlertModal']/div/div/div[3]/button[2]")));

        //查找模态对话框的确定按钮
        WebElement acceptButton = webDriver.findElement(By.xpath(".//*[@id='administratorAlertModal']/div/div/div[3]/button[2]"));
        acceptButton.click();

        //拖动模态对话框，不遮挡登录按钮
        Actions actions = new Actions(webDriver);
        WebElement modalDialog = webDriver.findElement(By.xpath(".//*[@id='administratorAlertModal']"));
        actions.dragAndDropBy(modalDialog,1000,300).perform();

        //输入用户名和密码
        webDriver.findElement(By.id("username")).sendKeys("20000000108");
        webDriver.findElement(By.id("password")).sendKeys("123456");
        webDriver.findElement(By.id("loginBind")).click();
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }

}
