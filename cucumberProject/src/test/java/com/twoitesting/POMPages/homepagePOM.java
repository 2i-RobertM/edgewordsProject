package com.twoitesting.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepagePOM {

    private WebDriver driver;

    public homepagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Locators

    @FindBy(xpath = "/html/body/div/header/div[2]/div/nav/div[1]/ul/li[5]/a")
    WebElement myAccountLink;

    @FindBy(css = ".demo_store.woocommerce-store-notice > .woocommerce-store-notice__dismiss-link")
    WebElement dismissLink;


    //Service Methods

    public void clickMyAccountLink(){
        myAccountLink.click();
    }

    public void dismissLinkClick(){
        dismissLink.click();

    }




}
