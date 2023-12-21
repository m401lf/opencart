package cucumber.stepDefinitions;

import Pages.*;
import TestComponents.TestBase;
import helper.assertion.AssertionHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class RegistrationSteps extends TestBase {
    AccountRegisterPage accountRegisterPage;
    AccountSuccessPage accountSuccessPage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;


    @Given("I landed on an e-commerce website {string}")
    public void iLandedOnAnECommercePageUrl(String url) throws IOException {
        indexPage = launchApplication(url);
    }

    @And("I navigate to account register page")
    public void i_navigate_to_account_register_page() throws IOException {
        accountRegisterPage = indexPage.clickMyAccountAndRegister();

    }

    @And("I input firstName {string}")
    public void i_input_first_name(String firstname) {
        accountRegisterPage.inputFirstName(firstname);

    }

    @And("I input lastName {string}")
    public void i_input_last_name(String lastname) {
        accountRegisterPage.inputLastName(lastname);

    }

    @And("I input unique email address")
    public void i_input_unique_email_address() {
        accountRegisterPage.inputEmailAddress();

    }

    @And("I input telephone {string}")
    public void i_input_telephone(String tel) {
        accountRegisterPage.inputTelephone(tel);

    }

    @And("I input password {string}")
    public void i_input_password(String pass) {
        accountRegisterPage.inputPassword(pass);

    }

    @And("I input confirm password {string}")
    public void i_input_confirm_password(String conPass) {
        accountRegisterPage.inputConfirmPassword(conPass);

    }

    @And("I tick on subscription option Yes")
    public void i_tick_on_subscription_option_yes() {
        accountRegisterPage.tickOnYesSubscribeRadioButton();

    }

    @And("I can see Subscribe: {string} is ticked")
    public void i_can_see_subscribe_is_ticked(String yes) {
        AssertionHelper.updateTestStatus(accountRegisterPage.getSubscribeYesRadioButtonLabel().contains(yes));

    }

    @And("I tick on privacy policy radio button")
    public void i_tick_on_radio_button() {
        accountRegisterPage.clickOnAgreeToPrivacyPolicyButton();

    }

    @And("I tap on Continue button in account create page")
    public void i_tap_on_button_in_account_create_page() throws IOException {
        accountSuccessPage = accountRegisterPage.clickOnAccountRegisterContinueBtn();
    }

    @And("I tap Continue button in account create page")
    public void i_tap_continue_button_in_account_create_page() {
        accountRegisterPage.clickAccountRegisterContinueBtn();
    }

    @Then("I should see {string} in Account success page")
    public void i_should_see_in_account_success_page(String accountSuccesfullyCreatedMsg) {
        AssertionHelper.updateTestStatus(accountSuccessPage.assertPageHeaderIsDisplayed());
        AssertionHelper.updateTestStatus(accountSuccessPage.getYourAccountHasBeenCreatedHeadingTxt().contains(accountSuccesfullyCreatedMsg));

    }

    @And("I tap on Continue button in Account success page")
    public void i_tap_on_continue_button_in_account_success_page() throws IOException {
        accountPage = accountSuccessPage.clickOnAccountSuccessContinueBtn();

    }

    @Then("I can see {string} in account page")
    public void i_can_see_and_in_account_page(String myAccount) {
        AssertionHelper.updateTestStatus(accountPage.getMyAccountTxt().contains(myAccount));
    }

    @And("I can see page title {string} and heading text {string}")
    public void iCanSeePageTitleAndHeadingText(String pageTitle, String header) {
        Assert.assertEquals(pageTitle, accountRegisterPage.getCurrentPageTitle());
        Assert.assertEquals(header, accountRegisterPage.getPageHeaderTxt());
    }

    @And("I can see input sections {string}, {string} and {string}")
    public void iCanSeeInputSectionsAnd(String persDetails, String yourPass, String newsletter) {
        AssertionHelper.updateTestStatus(accountRegisterPage.getYourPersonalDetailsTxt().equals(persDetails));
        AssertionHelper.updateTestStatus(accountRegisterPage.getYourPasswordTxt().equals(yourPass));
        AssertionHelper.updateTestStatus(accountRegisterPage.getYourNewsletterTxt().equals(newsletter));
    }

    @And("I click on Logout Link from My Account dropdown list")
    public void iClickOnLogoutLinkFromMyAccountDropdownList() throws IOException {
        indexPage = new IndexPage(driver);
        accountLogoutPage = accountPage.clickOnLogoutLinkFromMyAccountTopMenuLink();
    }

    @And("I tap account logout Continue button")
    public void iTapAccountLogoutContinueButton() throws IOException, InterruptedException {
        indexPage = accountLogoutPage.clickAccountLogoutContinueBtn();

    }

    @And("{string} header is displayed")
    public void headerIsDisplayed(String registerAccount) {
        AssertionHelper.updateTestStatus(accountRegisterPage.getPageHeaderTxt().contains(registerAccount));
    }


    @Then("I should see red warning error message {string}")
    public void iShouldSeeRedWarningErrorMessage(String ppWarningTxt) {
        Assert.assertTrue(accountRegisterPage.warningYouMustAgreeToPrivacyPolicyTxt().contains(ppWarningTxt), "Privacy Policy error does appear");
    }

    @And("I can see {string}")
    public void iCanSee(String fName) {
        AssertionHelper.updateTestStatus(accountRegisterPage.assertFirstnameRedMessage().contains(fName));

    }

    @And("I should see {string}")
    public void iShouldSee(String lName) {
        AssertionHelper.updateTestStatus(accountRegisterPage.assertLastnameRedMessage().contains(lName));

    }

    @And("{string} is displayed")
    public void emailDoesNotAppearToBeValidIsDisplayed(String email) {
        Assert.assertEquals(accountRegisterPage.assertEmailRedMessage(), email);

    }


    @And("{string} must be between {string} and {string} characters!")
    public void mustBeBetweenAndCharacters(String tel, String mini, String max) {
        AssertionHelper.updateTestStatus(accountRegisterPage.assertTelephoneRedMessage().contains(tel));
        AssertionHelper.updateTestStatus(accountRegisterPage.assertTelephoneRedMessage().contains(mini));
        AssertionHelper.updateTestStatus(accountRegisterPage.assertTelephoneRedMessage().contains(max));

    }


    @And("{string} must be between {string} and {string} characters! is displayed")
    public void mustBeBetweenAndCharactersIsDisplayed(String password, String mini, String max) {
        AssertionHelper.updateTestStatus(accountRegisterPage.assertPasswordRedMessage().contains(password));
        AssertionHelper.updateTestStatus(accountRegisterPage.assertPasswordRedMessage().contains(mini));
        AssertionHelper.updateTestStatus(accountRegisterPage.assertPasswordRedMessage().contains(max));
    }


    @And("I should see {int} mandatory red icons")
    public void iShouldSeeMandatoryRedIcons(int count) {
        Assert.assertEquals(accountRegisterPage.assertRequiredFields(), count);
    }

}
