package com.twoitesting.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPagePOM {

    private WebDriver driver;

    public cartPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(css = "#post-5 > div > div > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-name > a")
    WebElement firstProductInBasket;

    @FindBy(css = "input#coupon_code")
    WebElement couponCodeInput;

    @FindBy(css = "#post-5 > div > div > form > table > tbody > tr:nth-child(2) > td > div > button")
    WebElement couponButton;

    @FindBy(css = ".woocommerce-remove-coupon")
    WebElement removeLinkCoupon;

    @FindBy(css = "#post-5 > div > div > div.cart-collaterals > div > div > a")
    WebElement checkoutButton;

    // Service Methods

    public void addCustomCouponCode(String couponCode) {
        couponCodeInput.sendKeys(couponCode);
    }

    public void applyCouponCode () {
        couponButton.click();
    }

    public void clickCheckoutButton () {
        checkoutButton.click();
    }


}
