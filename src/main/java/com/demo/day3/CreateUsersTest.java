package com.demo.day3;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017-4-11.
 */

public class CreateUsersTest extends BaseCase {

    //毫秒级的时间戳
    Long time = System.currentTimeMillis();


    /**
     *@Author zhangyy
     *@Date 2017-4-11 14:37
     * 打开163邮箱
     *
     */
    @Test
    public void creatEmail() throws InterruptedException {
        webDriver.get("http://mail.163.com/");
        webDriver.manage().window().maximize();
        //把控制权交给注册按钮所在的iframe
        webDriver.switchTo().frame("x-URS-iframe");
        //定位注册按钮，打开注册页面
        webDriver.findElement(By.id("changepage")).click();
        //把控制权交给注册页面
        String handle1= webDriver.getWindowHandle();
        for(String handles : webDriver.getWindowHandles()){
            if(handles.equals(handle1))
                continue;
            webDriver.switchTo().window(handles);
        }

        //输入邮箱地址
        webDriver.findElement(By.id("nameIpt")).sendKeys("E"+String.valueOf(time));
        //密码
        webDriver.findElement(By.id("mainPwdIpt")).sendKeys("sensy1988");
        //确认密码
        webDriver.findElement(By.id("mainCfmPwdIpt")).sendKeys("sensy1988");
        //手机号码
        webDriver.findElement(By.id("mainMobileIpt")).sendKeys(String.valueOf(time/100));
        //验证码
        webDriver.findElement(By.id("vcodeIpt")).sendKeys("error");
        //短信验证码
        webDriver.findElement(By.id("mainAcodeIpt")).sendKeys("234569");
        Thread.sleep(5000);
        //立即注册
        webDriver.findElement(By.id("mainRegA")).click();

        //校验
        String text = webDriver.findElement(By.xpath(".//*[@id='m_mainAcode']/span")).getText();
        Assert.assertEquals(text,"  手机验证码不正确，请重新填写");
    }
}
