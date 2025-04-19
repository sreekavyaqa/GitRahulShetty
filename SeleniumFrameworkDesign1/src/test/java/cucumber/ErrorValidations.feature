
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    And Loggedin with Username <name> and Password <password>
    Then "Incorrect email or password." message is displayed

      Examples: 
      | name  								| password	| 
      | kavya.19jan@gmail.com | Test@12  | 