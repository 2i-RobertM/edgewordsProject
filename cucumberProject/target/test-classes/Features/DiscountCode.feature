Feature: Applying Discount Code

  Background: :Successful Login With Valid Credentials
    Given User is on MyAccount Page
    When User Enters "robert.matthew" and "edgewords123456789?"
    Then My Account Should Display Login with "username"


  Scenario: Navigating to MyAccount Page
    Given User is on HomePage
    When User Navigates to My Account
    Then User Can Enter Valid Login Details

  Scenario: Adding Clothing Item to Cart
    Given User am on Shop Page
    When Clothing Item is Added to Cart
    Then Item shows on View-Cart Section

  Scenario: Applying Coupon
    Given Clothing Item is in Cart
    When Discount code "edgewords" is applied
    Then Total Charge After Coupon and Shipping is Correct

  Scenario: Logging Out
    Given Tasks have been completed
    When Logout is clicked
    Then User is logged out




