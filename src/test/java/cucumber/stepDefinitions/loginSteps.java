package cucumber.stepDefinitions;

import Pages.*;
import TestComponents.BaseTest;
import helper.assertion.AssertionHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class loginSteps extends BaseTest {
    String email = System.currentTimeMillis() + "@aol.com";
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    AccountRegisterPage accountRegisterPage;
    AccountPage accountPage;
    AccountSuccessPage accountSuccessPage;
    AccountEditPage accountEditPage;
    AccountLogoutPage accountLogoutPage;
    BasePage page = PageFactory.initElements(driver, BasePage.class);


    @Given("I landed on an e-commerce page")
    public void iLanded0nAnECommercePage() throws IOException {
        indexPage = launchApplication();
    }

    @And("navigate to Login page")
    public void navigateToLoginPage() throws IOException {
        accountLoginPage = indexPage.clickMyAccountAndLoginLink();
    }

    @And("I can see {string} and {string} sub headings texts")
    public void iCanSeeAndSubHeadingsTexts(String newCustomer, String returnCustomer) {
        boolean statusForNewCustomer = accountLoginPage.getNewCustomer().contains(newCustomer);
        AssertionHelper.updateTestStatus(statusForNewCustomer);
        boolean statusForReturnCustomer =
                accountLoginPage.getReturningCustomer().contains(returnCustomer);
        AssertionHelper.updateTestStatus(statusForReturnCustomer);
    }

    @And("I should see aside widget displayed list contains {string}")
    public void iShouldSeeAsideWidgetDisplayedListContains(String item) throws IOException {
        indexPage = new IndexPage(driver);
        AssertionHelper.updateTestStatus(accountLoginPage.getAsideWidgetList().contains(item));
    }

    @And("I login in login page as a returning customer")
    public void iLoginInLoginPageAsAReturningCustomer(DataTable dataTable) throws IOException {
        accountLoginPage.inputEmail(dataTable.cell(1, 0));
        accountLoginPage.inputPassword(dataTable.cell(1, 1));
    }

    @Given("I login in login page as a returning customer with invalid credential")
    public void i_login_in_login_page_as_a_returning_customer_with_invalid_credential(DataTable dataTable) throws IOException {
        accountLoginPage.inputEmail(dataTable.cell(1, 0));
        accountLoginPage.inputPassword(dataTable.cell(1, 1));

    }

    @And("I login in login page as a returning customer with email {string} and password {string}")
    public void iLoginInLoginPageAsAReturningCustomerWithValidLoginCredentials(String email, String pass)
            throws IOException {
        accountLoginPage.inputEmail(email);
        accountLoginPage.inputPassword(pass);
    }

    @Then("should be presented with the following validation message as {string}")
    public void shouldBePresentedWithTheFollowingValidationMessageAs(String myAccount) {
        AssertionHelper.updateTestStatus(accountPage.getMyAccountTxt().contains(myAccount));
    }

    @And("I tap on Your Edit Account Information link in aside widget")
    public void iTapOnEditAccountLinkInAsideWidget() throws IOException {
        accountPage = new AccountPage(driver);
        accountEditPage = accountPage.clickOnYourEditAccountInformationLink();
    }

    @And("{string} header is displayed in edit account page")
    public void headerIsDisplayedInEditAccountPage(String myAccountInformationHeadingTxt) {
        AssertionHelper.updateTestStatus(accountEditPage.assertMyAccountInformationHeadingTxt());
        AssertionHelper.updateTestStatus(
                accountEditPage
                        .getMyaccountInformationHeadingTxt()
                        .contains(myAccountInformationHeadingTxt));
    }

    @And("Updated account information excluding email with the following details below:")
    public void updatedAccountInfoExcludingEmailWithTheFollowingDetailsBelow(DataTable dataTable) {
        accountEditPage.enterFirstName(dataTable.cell(0, 0));
        accountEditPage.enterLastName(dataTable.cell(0, 1));
        accountEditPage.enterTelephone(dataTable.cell(0, 2));
    }

    @And("Updated Your Personal Details excluding email with the following details below:")
    public void updatedYourPersonalDetailExcludingEmailWithTheFollowingDetailsBelow(
            DataTable dataTable) {
        accountEditPage.enterFirstName(dataTable.cell(0, 0));
        accountEditPage.enterLastName(dataTable.cell(0, 1));
        accountEditPage.enterTelephone(dataTable.cell(0, 2));
    }

    @And("Updated {string} excluding email with the following details below:")
    public void updatedYourPersonalDetailExcludingEmailWithTheFollowingDetails(
            DataTable dataTable, String myPersonalDetails) {
        AssertionHelper.updateTestStatus(
                accountEditPage.getMyPersonalDetailsTxt().contains(myPersonalDetails));
        accountEditPage.enterFirstName(dataTable.cell(0, 0));
        accountEditPage.enterLastName(dataTable.cell(0, 1));
        accountEditPage.enterTelephone(dataTable.cell(0, 2));
    }

    @And("click edit account Continue button")
    public void clicksOnContinueButton() throws IOException {
        accountPage = accountEditPage.clickOnEditAccountContinueButton();
    }

    @And("I should see confirmation message {string}")
    public void iShouldSeeConfirmationMessage(String successMsg) {
        boolean statusForSuccessMsg = accountPage.getSuccessYourAccountSuccessfullyUpdatedTxt().contains(successMsg);
        AssertionHelper.updateTestStatus(statusForSuccessMsg);
    }

    @When("I clicks on Logout link in aside Widget")
    public void i_clicks_on_logout_link_in_aside_widget() throws IOException, InterruptedException {
        accountLogoutPage = accountPage.clickOnLogoutSideWidgetAccountLink();
    }

    @And("{string} text is displayed")
    public void textIsDisplayed(String accountLogout) {
        AssertionHelper.updateTestStatus(
                accountLogoutPage.getAccountLogoutTxt().contains(accountLogout));
    }

    public void backToLandingPageTitleYourStore(String yourStore) {
        AssertionHelper.updateTestStatus(indexPage.getCurrentPageTitle().contains(yourStore));
        tearDown();
    }

    @Then("should be presented with the following Error validation message as {string}")
    public void shouldBePresentedWithTheFollowingErrorValidationMessageAs(
            String loginValidationErrorMessage) {
        AssertionHelper.updateTestStatus(
                accountLoginPage
                        .getErrorWarningConfirmationMsg()
                        .contains(loginValidationErrorMessage));
    }

    @And("I tap on {string} link")
    public void iTapOnLink(String arg0) {
    }

    @And("I tap on edit profile button")
    public void iTapOnEditProfileButton() {
    }

    @And("inputted the following details below:")
    public void inputtedTheFollowingDetailsBelow() {
    }

    @When("I clicks on logoff button")
    public void iClicksOnLogoffButton() {
    }

    @And("I tap logout Continue Button")
    public void iTapLogoutContinueButton() throws IOException, InterruptedException {
        indexPage = accountLogoutPage.clickAccountLogoutContinueBtn();
    }

    @And("I tap logout {string} Button")
    public void iTapLogoutContinueButton(String contBtn) throws IOException {
//        AssertionHelper.updateTestStatus(accountLogoutPage.getContinueButton().contains(contBtn));
//        indexPage = navigationPage.clickOnAccountLogoutContinueBtn();
    }

    @And("back to landing page")
    public void backToLandingPage() {
        AssertionHelper.updateTestStatus(
                indexPage.getCurrentPageTitle().equalsIgnoreCase("Your Store"));
        tearDown();
    }

    @And("back to login page title as {string}")
    public void backToLoginPage(String pageTitle) throws IOException {
        accountLoginPage = new AccountLoginPage(driver);
        AssertionHelper.updateTestStatus(accountLoginPage.getCurrentPageTitle().equalsIgnoreCase(pageTitle));
        //tearDown();
        driver.quit();
    }

    @And("{string} sub header is displayed")
    public void subHeaderIsDisplayed(String registerAccount) {
        AssertionHelper.updateTestStatus(accountLoginPage.assertRegisterAccount());
        AssertionHelper.updateTestStatus(
                accountLoginPage.getRegisterAccount().equalsIgnoreCase(registerAccount));
    }

    @And("back to index page title as {string}")
    public void backToLandingPageTitleAs(String yourStore) {
        AssertionHelper.updateTestStatus(indexPage.getCurrentPageTitle().equalsIgnoreCase(yourStore));
        //tearDown();
        driver.quit();
    }

    @And("I can see aside widget labels count as {string} first label {string} and last {string}")
    public void iCanSeeLabelsAsAsFirstLabelAsAndLastAs(
            String labels_Count, String login, String newsletter) throws IOException {
        /*NavigationPage navigationPage = new NavigationPage(driver);
        AssertionHelper.updateTestStatus(
                navigationPage.assertAsideWidgetAndLabelPosition(labels_Count, login, newsletter));*/
    }


    @And("I click on Login button")
    public void iClickOnLoginButton() throws IOException {
        accountPage = accountLoginPage.clickOnLoginBtnInAccountLoginPage();
    }

    @And("I tap Login button")
    public void iTapLoginButton() throws IOException {
        accountLoginPage.clickLoginBtnInAccountLoginPage();
    }

    @And("I login in login page as a returning customer with unique email and password {string}")
    public void iLoginInLoginPageAsAReturningCustomerWithUniqueEmailAndPassword(String pass) {
        accountLoginPage.inputEmail(email);
        accountLoginPage.inputPassword(pass);

    }
}
