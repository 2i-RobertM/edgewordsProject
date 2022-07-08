package com.twoitesting;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private WebDriver driver; //Field to share driver between methods in this class
    private final SharedDictionary sharedDict; //field to use sharedDict in this class

    public Hooks(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict;
    }

    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sharedDict.addDict("webdriver", driver);
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}
