package cucumber.stepDefinitions;

import Pages.*;
import TestComponents.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommonSteps extends TestBase {

    BasePage page = PageFactory.initElements(driver, BasePage.class);
    IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
    AccountLoginPage loginPage = PageFactory.initElements(driver, AccountLoginPage.class);
    AccountPage accountPage = PageFactory.initElements(driver, AccountPage.class);
    AccountSuccessPage successPage = PageFactory.initElements(driver, AccountSuccessPage.class);
    AccountRegisterPage registerPage = PageFactory.initElements(driver, AccountRegisterPage.class);
    AccountEditPage editPage = PageFactory.initElements(driver, AccountEditPage.class);
    AccountLogoutPage logoutPage = PageFactory.initElements(driver, AccountLogoutPage.class);


    @Then("^the page correct heading should be \"([^\"]*)\"$")
    public void the_page_correct_heading_should_be(String heading) throws Throwable {
        //checkHeading(heading);
    }

    @Then("^the page sub-heading displayed should be \"([^\"]*)\"$")
    public void the_page_heading_displayed_should_be(String subHeading) {
        page.assertOnSubHeadingTextt(subHeading);
    }

    @Then("^I am on the \"([^\"]*)\" page$")
    public void checkHeadingOnThePage(String heading) {
        // checkHeading(heading);
    }

    // ********* Back Buttons *****************//
    @Then("^I tap on the back button$")
    public void clickOnBackButton() {
        page.clickOnGoBackLink();

    }

    @Then("I navigate to previous page")
    @When("^I click on the Go back$")
    public void i_click_on_the_Go_back() {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.clickOnGoBackLink();
    }

    @Then("^I click on the View link$")
    public void clickOnViewLink() {
        //page.clickOnViewLink();

    }

    // ********* Browser Back *****************//
    @Then("^I click the browser back button$")
    public void clickOnBrowserBackButton() {
        page.clickOnBrowserBackButton();

    }

    // ************ Continue Button ********** //
    @And("^I navigate to next page$")
    @Then("^I tap on the Continue button$")
    public void clickOnContinueButton() throws InterruptedException, IOException {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        //page.clickOnContinueButton();
    }

    @And("^I continue without entering my email address$")
    @Then("^I click Continue button$")
    public void clickContinueButton() {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        page.clickContinueButton();
    }

    // ************ Submit Button ********** //
    @And("^I click on the Continue button$")
    public void i_click_on_the_continue_button() throws Throwable {
        //page.clickOnContinueBtn();
    }

    // ************ Save and Continue Button ********** //
    @And("^I Save details and Continue to next page$")
    @Then("^I tap on save and continue button$")
    public void clickOnSaveAndContinueButton() throws InterruptedException {
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        //page.clickOnSaveAndContinueButton();
    }

    // *********** Sign in and Sign out *********** //
    @And("^I Sign out from my account$")
    @Then("^I tapped on the Sign out link$")
    public void clickOnSignoutLink() {
        //page.clickOnSignoutLink();

    }

    @Then("^I should be taken to the \"([^\"]*)\" Scorer Pages$")
    public void checkPublishedJobUpdateWarningMessagePageIsDisplayed(String subHeading) {
        //publishedWarningMessagePage.assertPublishedWarningMessagePageIsDisplayedWithSubHeading(subHeading);
    }

    @Then("^I am currently signed in$")
    public void checkSignOutLinkIsDisplayed() {
        page.assertIfSignOutButtonExists();
    }


    // ********** Error Messages ************ //
    @Then("^I should get an Error Message$")
    public void i_should_get_an_Error_Message(DataTable data) throws Throwable {
        List<Map<String, String>> errorSummary = data.asMaps(String.class, String.class);
        BasePage page = PageFactory.initElements(driver, BasePage.class);
        //page.assertHeadingErrorIdIsDisplayed();
        // page.assertOnErrorMessage(errorSummary.get(0).get("ErrorMessage"));

    }

    @Then("^I should get an Error Message as below$")
    public void i_should_get_an_Error_Message_as_below(DataTable data) throws Throwable {
        List<Map<String, String>> errorSummary = data.asMaps(String.class, String.class);

        BasePage page = PageFactory.initElements(driver, BasePage.class);
        //page.assertHeadingErrorIdIsDisplayed();
        page.assertOnPageErrorMessage(errorSummary.get(0).get("ErrorMessage"));


    }

    @Then("^I should get an Error Message \"([^\"]*)\"$")
    public void i_should_get_an_Error_Message(String errorMessage) throws Throwable {
        //page.assertHeadingErrorIdIsDisplayed();
    }

    // ************* Radio buttons  ********************** //
    @Then("^I should have the following mutually exclusive radio buttons$")
    public void i_should_have_the_following_mutually_exclusive_radio_buttons(List<String> radioButtons)
            throws Throwable {
        for (int i = 0; i < radioButtons.size(); i++) {
            page.assertRadioButtonsLabel(i, radioButtons.get(i));
        }
    }

    @And("^The Radio button selections should be unticked by default$")
    public void the_radio_button_selections_should_be_unticked_by_default() throws Throwable {
        page.assertRadioButtonsUnchecked();
    }

    @And("^I have selected the \"([^\"]*)\" option$")
    public void i_have_selected_the_something_option(String radioBtnOption) throws Throwable {
        switch (radioBtnOption) {
            case "Yes":
                page.clickRadioBtnOption(0);
                break;

            case "No":
                page.clickRadioBtnOption(1);
                break;

            default:
                System.out.println("No matching option");
        }
    }

    @And("^I changed from Yes to No option$")
    public void i_changed_from_yes_to_no_option() throws Throwable {
        page.clickRadioBtnOption(1);
    }

    @And("^I changed from No to Yes option$")
    public void i_changed_from_no_to_yes_option() throws Throwable {
        page.clickRadioBtnOption(0);
    }

    // ******** Input fields ***************** //
    @Then("^I should have the following input fields$")
    public void i_should_have_the_following_input_fields(List<String> inputLabels) throws Throwable {
        for (int i = 0; i < inputLabels.size(); i++) {
            page.assertInputLabel(i, inputLabels.get(i));
        }
    }

    @When("^I have not completed the mandatory fields$")
    public void i_have_not_completed_the_mandatory_fields() throws Throwable {
        // No implementation required, as it says -- not completed the (mandatory)
        // fields
    }

    // ******** Pages is Displayed ******* //
    @When("^the Pages is displayed$")
    public void the_Page_is_displayed() throws Throwable {
        //CheckPageIsLoaded.checkPageIsReady(5);

        // checks for the page is loaded completely and displayed, 5 times with 2seconds wait in between
    }

    // ********* Help Links ************ //
    @When("^I click on the Help Link$")
    public void i_click_on_help_link() {
        //page.clickOnHowToCreateandPublishJobs();
    }

    @When("^I click on the Help Text")
    public void i_click_on_help_text() {
        //page.clickOnHowToApplyForJobs();
    }


    @When("^I have accepted analytics cookies$")
    public void i_have_accepted_analytics_cookies() {
        //page.clickAcceptAnalytics();
    }


    @When("^I click hide cookie message$")
    public void i_click_hide_cookie_message() {
        //page.clickHideCookieMessage();

    }

    @Then("^I should not see the rejected cookies message$")
    public void i_should_not_see_the_rejected_cookies_message() {
        page.assertRejectedCookiesMessageIsNotVisible();

    }

    @And("^I click on the return to dashboard button")
    public void click_on_the_return_to_dashboard_button() {
        //page.clickOnReturnToDashBoardButton();
    }

    @And("^I click on the employer signout link$")
    public void click_on_the_employer_signout() {
        driver.findElement(By.id("employer_sign_out")).click();

    }

    @Then("^Link with text \"([^\"]*)\" does not exist$")
    public void check_link_with_text_does_not_exist(String text) {
        String locator = "//a[contains(text()," + "'" + text + "')]";
        List<WebElement> links = driver.findElements(By.xpath(locator));
        Assert.assertEquals(0, links.size(), "The link was found on the page");
    }

    @Then("^Link with text \"([^\"]*)\" exists$")
    public void check_link_with_text_does_exists(String text) {
        String locator = "//a[contains(text()," + "'" + text + "')]";
        List<WebElement> links = driver.findElements(By.xpath(locator));
        Assert.assertTrue(links.size() != 0, "The link was not found on the page");
    }


}

