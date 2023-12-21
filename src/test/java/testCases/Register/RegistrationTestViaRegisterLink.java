package testCases.Register;

import Pages.*;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestComponents.Listeners.class)

public class RegistrationTestViaRegisterLink extends BaseTest {

    IndexPage indexPage;

    AccountLoginPage accountLoginPage;
    AccountRegisterPage accountRegisterPage;
    AccountSuccessPage accountSuccessPage;
    AccountPage accountPage;
    AccountEditPage accountEditPage;
    AccountLogoutPage accountLogoutPage;

    @Test(description = "Registration Test By Register Link")
    public void RegistrationTestByRegisterLink() throws Exception {
        indexPage = new IndexPage(driver);
        accountRegisterPage = indexPage.tapOnItemFromAccountDropDownList("My Account", "Register");
        accountRegisterPage.inputPersonalDetails("Firstname", "Lastname", "07405000000");
        accountRegisterPage.inputPasswordAndConfirmPassword("Password", "Password");
        accountRegisterPage.inputPassword("Password");
        accountRegisterPage.tickOnYesSubscribeRadioButton();
        accountRegisterPage.clickOnAgreeToPrivacyPolicyButton();
        accountSuccessPage = accountRegisterPage.clickOnAccountRegisterContinueBtn();
        accountPage = accountSuccessPage.clickOnAccountSuccessContinueBtn();
        accountEditPage = accountPage.tapOnEditAccountLink();
        accountPage = accountEditPage.clickOnEditAccountContinueButton();
        accountLogoutPage = accountPage.tapOnLogoutLinkFromAsideWidget();
        indexPage = accountLogoutPage.tapOnAccountLogoutContinueBtn();
        Assert.assertTrue(indexPage.assertLogoDisplayed());

    }

}
