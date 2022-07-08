package com.twoitesting.POMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shopPagePOM {

    private WebDriver driver;

    public shopPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Locators

    @FindBy(css = "#main > ul > li.product.type-product.post-29.status-publish.last.instock.product_cat-accessories.has-post-thumbnail.sale.shipping-taxable.purchasable.product-type-simple > a.button.product_type_simple.add_to_cart_button.ajax_add_to_cart")
    WebElement itemToBeAdded;

    @FindBy(css = "#site-header-cart > li:nth-child(1) > a")
    WebElement popupViewBasket;

    //Service Methods

    public void addItemToBeAddedToBasket (){
        itemToBeAdded.click();
    }

    public void ViewCartPageFromViewBasket(){
        popupViewBasket.click();
    }
}
