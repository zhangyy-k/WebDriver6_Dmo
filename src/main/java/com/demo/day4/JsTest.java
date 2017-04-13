package com.demo.day4;

import com.demo.day3.BaseCase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017-4-12.
 */
public class JsTest extends BaseCase {

    /**
     *@Author zhangyy
     *@Date 2017-4-12 9:06
     * 执行js代码
     */
    @Test
    public void jsTest(){
        webDriver.get("http://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor)webDriver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"selenium\")");
    }
}
