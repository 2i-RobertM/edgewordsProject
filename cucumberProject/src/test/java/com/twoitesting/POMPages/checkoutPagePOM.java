package com.twoitesting.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPagePOM {

    private WebDriver driver;

    public checkoutPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(css = "#billing_first_name")
    WebElement firstNameInput;

    @FindBy(css = "#billing_last_name")
    WebElement secondNameInput;

    @FindBy(css = "#billing_address_1")
    WebElement addressInput;

    @FindBy(css = "#billing_city")
    WebElement cityInput;

    @FindBy(css = "#billing_postcode")
    WebElement postcodeInput;

    @FindBy(css = "#billing_phone")
    WebElement phoneInput;

    @FindBy(css = "#billing_email")
    WebElement emailInput;

    @FindBy(css = "#place_order")
    WebElement placeOrderButton;

    //Service Methods

    public void enterFirstNameInput() {
        firstNameInput.clear();
        firstNameInput.sendKeys("bob");
    }

    public void enterSecondNameInput () {
        secondNameInput.clear();
        secondNameInput.sendKeys("ARAGON");
    }

    public void enterCityInput () {
        cityInput.clear();
        cityInput.sendKeys("MORDOR");
    }

    public void enterAddressInput(){
        addressInput.clear();
        addressInput.sendKeys("10");
    }
    public void enterPostcode () {
        postcodeInput.clear();
        postcodeInput.sendKeys("g55 8en");
    }

    public void enterPhone (){
        phoneInput.clear();
        phoneInput.sendKeys("07891234567");
    }

    public void enterEmail(){
        emailInput.clear();
        emailInput.sendKeys("robert.matthew@2itesting.com");
    }

    public void placeOrderClick (){
        placeOrderButton.click();
    }





}
