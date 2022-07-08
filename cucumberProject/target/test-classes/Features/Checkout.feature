Feature: Checking Out To Obtain Valid Order Number

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

  Scenario: Proceeding to Checkout
    Given User is Satisfied With Cart Contents
    When User Proceeds to Checkout
    Then Checkout Page is Loaded

  Scenario: Placing an Order
    Given User is on Checkout Page
    When User Inputs Billing Details
    Then Order is Completed
