
@tag
Feature: Purchase the order from ecommerce website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce page
  @Regression
  Scenario Outline: Title of your scenario outline
    Given Loggedin with Username <name> and Password <password>
    When I add the product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page

    Examples: 
      | name  								| password	| productName |
      | kavya.19jan@gmail.com | Test@123 	| ZARA COAT 3 |
    
