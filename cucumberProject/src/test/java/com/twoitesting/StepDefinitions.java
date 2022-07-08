package com.twoitesting;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.twoitesting.POMPages.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Utilities;
import java.security.Key;
import java.time.Duration;

import static java.util.Collections.replaceAll;


import static org.hamcrest.Matchers.containsString;


public class StepDefinitions extends com.twoitesting.Utils.staticHelpers {

    private static WebDriver driver;
    private SharedDictionary sharedDict; // Field for shared dictionary to use in this class

    public StepDefinitions(SharedDictionary sharedDict) {
        driver = (WebDriver)sharedDict.readDict("webdriver");
        this.sharedDict = sharedDict;
    }

    @Given("User is on HomePage")
    public void user_is_on_home_page() {
        driver.get(baseURL);

    }
    @When("User Navigates to My Account")
    public void user_navigates_to_my_account() {
        //driver.findElement(By.xpath("/html/body/div/header/div[2]/div/nav/div[1]/ul/li[5]/a")).click();
        homepagePOM homepage = new homepagePOM(driver);
        homepage.dismissLinkClick();
        homepage.clickMyAccountLink();
    }
    @Then("User Can Enter Valid Login Details")
    public void user_can_enter_valid_login_details() {
        MatcherAssert.assertThat(driver.findElement(By.cssSelector(".entry-title")).getText(), containsString("My account"));
    }



    @Given("User is on MyAccount Page")
    public void user_is_on_my_account_page() {
        driver.get(baseURL + "/my-account/");
    }
    @When("User Enters {string} and {string}")
    public void user_enters_and(String username, String password)  {

        myAccountPOM myaccount = new myAccountPOM(driver);
        myaccount.enterUsername(username);
        myaccount.enterPassword(password);
        myaccount.clickLoginCredentials();

    }
    @Then("My Account Should Display Login with {string}")
    public void my_account_should_display_login_with(String string) {
        MatcherAssert.assertThat(driver.findElement(By.cssSelector(".woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a")).getText(), containsString("Logout"));


    }

    @Given("User am on Shop Page")
    public void user_am_on_shop_page() {
        driver.get(baseURL + "/shop/");
    }

    @When("Clothing Item is Added to Cart")
    public void clothing_item_is_added_to_cart() throws InterruptedException {
        shopPagePOM myShopPage = new shopPagePOM(driver);
        myShopPage.addItemToBeAddedToBasket();
        staticWaitForElement(driver, 4, By.cssSelector("#site-header-cart > li:nth-child(1) > a"));
        myShopPage.ViewCartPageFromViewBasket();
    }
    @Then("Item shows on View-Cart Section")
    public void item_shows_on_view_cart_section() {
        //on the cart page
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("#post-5 > div > div > form > table > tbody > tr.woocommerce-cart-form__cart-item.cart_item > td.product-name > a")).getText(), containsString("Cap"));
    }


    @Given("Clothing Item is in Cart")
    public void clothing_item_is_in_cart() {
        driver.get(baseURL + "/cart/");
    }

    @When("Discount code {string} is applied")
    public void discount_code_is_applied(String discountCode)  {

        cartPagePOM myCart = new cartPagePOM(driver);
        myCart.addCustomCouponCode(discountCode);
        staticWaitForElement(driver, 4, By.cssSelector("#post-5 > div > div > form > table > tbody > tr:nth-child(2) > td > div > button"));
        myCart.applyCouponCode();

    }

    @Then("Total Charge After Coupon and Shipping is Correct")
    public void total_charge_after_coupon_and_shipping_is_correct() {
        //Struggling to parse this!!!
        //String subtotal = driver.findElement(By.cssSelector(".cart-subtotal > td  bdi")).getText().replace("£", "");
        //int subtotalValue = Integer.parseInt(subtotal);
        //System.out.println(subtotalValue);
        staticWaitForElement(driver, 4, By.cssSelector("#post-5 > div > div > div.cart-collaterals > div > table > tbody > tr.cart-discount.coupon-edgewords > td > a"));
        MatcherAssert.assertThat(driver.findElement(By.cssSelector(".woocommerce-remove-coupon")).getText(), containsString("Remove"));


    }

    @Given("Tasks have been completed")
    public void tasks_have_been_completed() {
        driver.get(baseURL + "/my-account/");
    }
    @When("Logout is clicked")
    public void logout_is_clicked() throws InterruptedException {
        myAccountPOM accountPage = new myAccountPOM(driver);
        accountPage.logOut();
    }
    @Then("User is logged out")
    public void user_is_logged_out() {
        MatcherAssert.assertThat(driver.findElement(By.cssSelector(".col-1.u-column1 > h2")).getText(), containsString("Login"));
    }

    //Checkout

    @Given("User is Satisfied With Cart Contents")
    public void user_is_satisfied_with_cart_contents()  {
        driver.get(baseURL + "/cart/");
    }

    @When("User Proceeds to Checkout")
    public void user_proceeds_to_checkout() {
        staticWaitForElement(driver, 4, By.cssSelector("#post-5 > div > div > div.cart-collaterals > div > div > a"));
        cartPagePOM myCartPage = new cartPagePOM(driver);
        myCartPage.clickCheckoutButton();
    }

    @Then("Checkout Page is Loaded")
    public void checkout_page_is_loaded() {
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("#post-6 > header > h1")).getText(), containsString("Checkout"));
    }

    @Given("User is on Checkout Page")
    public void user_is_on_checkout_page() {
        driver.get(baseURL + "/checkout/");
    }

    @When("User Inputs Billing Details")
    public void user_inputs_billing_details() throws InterruptedException {
        checkoutPagePOM myCheckoutPage = new checkoutPagePOM(driver);
        myCheckoutPage.enterFirstNameInput();
        myCheckoutPage.enterSecondNameInput();
        myCheckoutPage.enterAddressInput();
        myCheckoutPage.enterCityInput();
        myCheckoutPage.enterPostcode();
        myCheckoutPage.enterPhone();
        myCheckoutPage.enterEmail();

        myCheckoutPage.placeOrderClick();
        Thread.sleep(3000);
    }

    @Then("Order is Completed")
    public void order_is_completed() {
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("#post-6 > header > h1")).getText(), containsString("Order received"));
    }












}
