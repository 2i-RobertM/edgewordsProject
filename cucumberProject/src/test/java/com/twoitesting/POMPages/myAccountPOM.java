package com.twoitesting.POMPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountPOM {

    private WebDriver driver;

    public myAccountPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(css = "input#username")
    WebElement usernameField;

    @FindBy(css = "input#password")
    WebElement passwordField;

    @FindBy(css = "button[name='login']")
    WebElement loginLink;

    @FindBy(css = "#post-7 > div > div > nav > ul > li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a")
    WebElement logoutLink;

    //Service Methods

    public void enterUsername (String username){
        usernameField.sendKeys(username );
    }

    public void enterPassword (String password) {
        passwordField.sendKeys(password );
    }

    public void clickLoginCredentials() {
        loginLink.click();
    }

    public void logOut() {
        logoutLink.click();
    }

}
