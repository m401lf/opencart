package testCases.Login;

import Pages.*;
import TestComponents.BaseTest;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GlobalVars;

@Listeners(TestComponents.Listeners.class)

public class LoginTestWithValidCredentials extends BaseTest {

    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;
    AccountEditPage accountEditPage;


    @Test(description = "Login test with valid credentials")
    public void loginTestValidCredentials() throws Exception {
        indexPage = new IndexPage(driver);
        accountLoginPage = indexPage.clickMyAccountAndLoginLink();
        accountPage = accountLoginPage.loginInApplication(GlobalVars.getEmailAddress(), GlobalVars.getPass());
        AssertionHelper.updateTestStatus(accountPage.getMyAccountTxt().contains(GlobalVars.getMyAccount()));
        accountEditPage = accountPage.tapOnEditAccountLink();
        accountPage = accountEditPage.clickOnEditAccountContinueButton();
        accountLogoutPage = accountPage.tapLogoutLinkFromSideWidgetLinks();
        indexPage = accountLogoutPage.clickAccountLogoutContinueBtn();
    }

}