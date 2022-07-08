package com.twoitesting.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class staticHelpers {

    public static WebElement staticWaitForElement(WebDriver driver, int timeout, By locator){
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return  mywait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public String baseURL = "https://www.edgewordstraining.co.uk/demo-site/";
}