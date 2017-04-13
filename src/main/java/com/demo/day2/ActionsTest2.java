package com.demo.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yunyan on 2017/4/8.
 */
public class ActionsTest2 {
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
     *@Date 2017/4/1020:22
     * 右键点击
     */
    @Test
    public void rigthTest(){
        webDriver.get("http://www.baidu.com");
        WebElement baiduButton = webDriver.findElement(By.id("su"));
        //实例化actions类
        Actions actions = new Actions(webDriver);
        //百度一下 右键按钮
        actions.contextClick(baiduButton).perform();
    }

    /**
     *@Author zhangyy
     *@Date 2017/4/1020:23
     * 双击
     */
    @Test
    public void doubleClickTest(){
        webDriver.get("http://www.baidu.com");
        WebElement baiduButton = webDriver.findElement(By.id("su"));
        //实例化actions类
        Actions actions = new Actions(webDriver);
        //百度一下 双击
        actions.doubleClick(baiduButton).perform();
    }

    /**
     *@Author zhangyy
     *@Date 2017/4/1020:23
     * 鼠标移动元素上显示
     */
    @Test
    public void moveShow(){
        webDriver.get("file:///E:/2017/selenium_html/index.html");
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"action\"]/input"));

        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
        String text = webDriver.findElement(By.xpath("//*[@id=\"action\"]/div")).getText();
        Assert.assertEquals(text,"Hello World!");
    }

    /**
     *@Author zhangyy
     *@Date 2017/4/1020:23
     * 拖拽元素
     */
    @Test
    public void dragTest() throws InterruptedException {
        webDriver.get("file:///F:/2017/selenium_html/index.html");
        WebElement element = webDriver.findElement(By.id("drag"));
        Thread.sleep(5000);
        Actions actions = new Actions(webDriver);
        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(5000);

    }

    /**
     *@Author zhangyy
     *@Date 2017/4/1021:27
     * 下拉多选框
     */
    @Test
    public void selectMutilTest(){
        webDriver.get("file:///F:/2017/selenium_html/index.html");
        //定位下拉多选框
        WebElement element = webDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        //查找下拉框中的options
        List<WebElement> options = element.findElements(By.tagName("option"));
        //按键盘shift键+鼠标操作
        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.SHIFT).
                click(options.get(0)).
                click(options.get(2)).
                perform();

    }

    /**
     *@Author zhangyy
     *@Date 2017-4-11 9:29
     * 把元素拖到另一个元素
     */
    @Test
    public void moveToElementTest() throws InterruptedException {
        webDriver.get("file:///E:/2017/selenium_html/dragAndDrop.html");
        WebElement elementOne = webDriver.findElement(By.tagName("h1"));
        WebElement elementTwo = webDriver.findElement(By.id("drag"));
        Actions actions = new Actions(webDriver);
        actions.clickAndHold(elementTwo).
                moveToElement(elementOne).
                release(elementTwo).
                perform();
        Thread.sleep(5000);
    }
}
