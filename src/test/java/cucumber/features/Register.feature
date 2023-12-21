@Registration
Feature: (TS_001) Register Functionality

  Scenario: I should be able to Register with valid credentials
    Given I landed on an e-commerce website "https://tutorialsninja.com/demo/"
    Given I navigate to account register page
    And "Register Account" header is displayed
    And I can see page title "Register Account" and heading text "Register Account"
    And I can see input sections "Your Personal Details", "Your Password" and "Newsletter"
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

