package com.demo.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.BatchUpdateException;

/**
 * Created by Administrator on 2017-4-10.
 */
public class ActionsTest {

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
     *@Date 2017-4-10 9:04
     * 我要点击百度首页的新闻连接
     * 那么我打开了新闻页面
     */
    @Test
    public void baiduClick(){
        webDriver.get("http://www.baidu.com");
        //定位新闻链接,点击
        webDriver.findElement(By.name("tj_trnews")).click();

        //获取新闻页面URL
        String currentURL = webDriver.getCurrentUrl();
        //判断是否打开新闻页面
        Assert.assertEquals(currentURL,"http://news.baidu.com/");
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 9:11
     * 打开百度首页
     * 输入关键字selenium
     * 点击搜索
     * 校验搜索页面的title是否为“selenium_百度搜索”
     */
    @Test
    public void baiduSelect(){
        webDriver.get("http://www.baidu.com");
        //定位输入框，输入“selenium”
        webDriver.findElement(By.id("kw")).sendKeys("selenium");
        //定位搜索按钮，点击
        webDriver.findElement(By.id("su")).click();
        //校验
        Assert.assertEquals(webDriver.getTitle(),"selenium_百度搜索");
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 9:23
     * 打开百度首页
     * 输入关键字selenium
     * 清空关键字
     */
    @Test
    public void clearTest() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        WebElement element =  webDriver.findElement(By.id("kw"));
        element.sendKeys("selenium");
        Thread.sleep(3000);
        element.clear();
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 9:28
     *打开百度首页
     * 输入关键字selenium
     * 获取文本框attribute
     * 校验是否为“selenium”
     */
    @Test
    public void attributeTest(){
        webDriver.get("http://www.baidu.com");
        WebElement element = webDriver.findElement(By.id("kw"));
        element.sendKeys("selenium");
        String value = element.getAttribute("value");
        Assert.assertEquals(value,"selenium");
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 9:35
     * 打开百度首页
     * 定位新闻链接
     * 获取链接text
     * 校验是否为“新闻”
     */
    @Test
    public void textTest(){
        webDriver.get("http://www.baidu.com");
        WebElement element = webDriver.findElement(By.name("tj_trnews"));
        String text = element.getText();
        Assert.assertEquals(text,"新闻");
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 10:03
     * 打开百度页面
     * 获取文本框的tagName
     * 校验文本框是否为“input”
     */
    @Test
    public void tagNameTest(){
        webDriver.get("http://www.baidu.com");
        String tagName = webDriver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 10:11
     * 打开百度页面
     * 校验百度一下已经展示
     */
    @Test
    public void displayTest(){
        webDriver.get("http://www.baidu.com");
        boolean disPlay = webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(disPlay);
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 10:20
     * 打开自动化测试页面
     * 校验单选框Volvo选中
     */
    @Test
    public void isSelectedTest(){
        webDriver.get("file:///E:/2017/selenium_html/index.html");
        //定位单选按钮
        WebElement element = webDriver.findElement(By.xpath(".//*[@id='radio']/input[1]"));
        //先选中
        element.click();
        boolean selected = element.isSelected();
        Assert.assertTrue(selected);
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 10:28
     * 打开自动化测试页面
     * 校验按钮是否可用
     */
    @Test
    public void isEnabledTest(){
        webDriver.get("file:///E:/2017/selenium_html/index.html");
        boolean enable = webDriver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(enable);
    }

    /**
     *@Author zhangyy
     *@Date 2017-4-10 13:16
     * 截图百度首页
     */
    @Test
    public void screenShotTest() throws IOException {
        webDriver.get("http://www.baidu.com");
        File screenShotFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile,new File("e:/test0.jpg"));
    }

}
