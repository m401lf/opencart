package testCases.Login;

import Pages.AccountLoginPage;
import Pages.IndexPage;
import TestComponents.BaseTest;
import com.github.javafaker.Faker;
import helper.assertion.AssertionHelper;
import org.testng.annotations.Test;
import utils.GlobalVars;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;

// @Listeners(TestComponents.Listeners.class)

public class LoginTestWithInvalidCredentials extends BaseTest {

    AccountLoginPage accountLoginPage;
    Faker faker;

    // @Test(invocationCount = 2)
    @Test(description = "Login Test With Invalid Credentials")
    public void LoginTestInvalidCredentials(Method method) throws IOException {
        faker = new Faker(Locale.UK);
        indexPage = new IndexPage(driver);
        accountLoginPage = indexPage.tapOnAnItemFromTopMenuAndclickItemFromDropdownList("My Account", "Login");
        accountLoginPage.inputLoginApplication(faker.internet().emailAddress(), GlobalVars.getWrongPass());
        accountLoginPage.clickOnLoginBtn();
        AssertionHelper.updateTestStatus(accountLoginPage.assertWarningConfirmationMsg());
        AssertionHelper.updateTestStatus(accountLoginPage.getErrorWarningConfirmationMsg().contains(GlobalVars.getWarningIncorrectLoginPasswordMsg()));
    }
}
