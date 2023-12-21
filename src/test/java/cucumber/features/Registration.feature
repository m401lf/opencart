@Registration
Feature: Verification of Registration functionality

  Background: common steps amoung scenarios
    Given I landed on an e-commerce website "https://tutorialsninja.com/demo/"
    Given I navigate to account register page
    And "Register Account" header is displayed
    And I can see page title "Register Account" and heading text "Register Account"
    And I can see input sections "Your Personal Details", "Your Password" and "Newsletter"

  Scenario: should be able to registration with valid credentials
    And I input firstName "FirstName"
    And I input lastName "LastName"
    And I input unique email address
    And I input telephone "074000000000"
    And I input password "password@123"
    And I input confirm password "password@123"
    And I tick on subscription option Yes
    And I can see Subscribe: "Yes" is ticked
    And I tick on privacy policy radio button
    And I tap on Continue button in account create page
    Then I should see "Your Account Has Been Created!" in Account success page
    And I tap on Continue button in Account success page
    And I click on Logout Link from My Account dropdown list
    And I tap account logout Continue button

  @verifyCompulsoryFields
  Scenario: Registration with blank - verify compulsory fields
    And I tap on Continue button in account create page
    Then I should see red warning error message "Warning: You must agree to the Privacy Policy!"
    And I can see "First Name must be between 1 and 32 characters!"
    And I should see "Last Name must be between 1 and 32 characters!"
    And "E-Mail Address does not appear to be valid!" is displayed
    And "Telephone" must be between "3" and "32" characters!
    And "Password" must be between "4" and "20" characters! is displayed

  @verifyCompulsoryFields
  Scenario: Registration with blank - verify compulsory fields
    And I tick on privacy policy radio button
    When I tap Continue button in account create page
    Then I can see "First Name must be between 1 and 32 characters!"
    And I should see "Last Name must be between 1 and 32 characters!"
    And "E-Mail Address does not appear to be valid!" is displayed
    And "Telephone" must be between "3" and "32" characters!
    And "Password" must be between "4" and "20" characters! is displayed
    And I should see 7 mandatory red icons
