package testCases.Register;

import Pages.*;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.GlobalVars;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Listeners(TestComponents.Listeners.class)

public class RegistrationTestViaLoginLink extends BaseTest {
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    AccountRegisterPage accountRegisterPage;
    AccountSuccessPage accountSuccessPage;
    AccountPage accountPage;
    AccountEditPage accountEditPage;
    AccountLogoutPage accountLogoutPage;

    @Test(description = "Registration Test Via Login Link via DataProvider", dataProvider = "getData", groups = {"Register"})
    public void RegistrationViaLoginLink(HashMap<String, String> input) throws Exception {
        indexPage = new IndexPage(driver);
        Assert.assertEquals(indexPage.getCurrentPageTitle(), (input.get("pageTitle")));
        Assert.assertTrue(indexPage.assertLogoDisplayed());
        accountLoginPage = indexPage.tapOnAnItemFromTopMenuAndclickItemFromDropdownList("My Account", "Login");
        accountRegisterPage = accountLoginPage.clickContinueButtonInAccountLogin();
        Assert.assertTrue(accountRegisterPage.getCurrentPageTitle().contains(input.get("registerPageTitle")));
        Assert.assertTrue(accountRegisterPage.getCurrentPageUrl().contains(input.get("registerPageUrlPath")));
        Assert.assertTrue(accountRegisterPage.assertPageHeaderIsDisplayed());
        Assert.assertTrue(accountRegisterPage.assertYourPersonalDetailsIsDisplayed());
        accountRegisterPage.inputPersonalDetails(input.get("fName"), input.get("lName"), input.get("tel"));
        accountRegisterPage.inputPassword(input.get("password"));
        accountRegisterPage.inputConfirmPassword(input.get("password"));
        accountRegisterPage.tickOnYesSubscribeRadioButton();
        accountRegisterPage.clickOnAgreeToPrivacyPolicyButton();
        accountSuccessPage = accountRegisterPage.clickOnAccountRegisterContinueBtn();
        Assert.assertTrue(accountSuccessPage.assertPageHeaderIsDisplayed());
        accountPage = accountSuccessPage.clickOnAccountSuccessContinueBtn();
        accountEditPage = accountPage.tapOnEditAccountLink();
        accountPage = accountEditPage.clickOnEditAccountContinueButton();
        accountLogoutPage = accountPage.tapOnLogoutLinkFromAsideWidget();
        indexPage = accountLogoutPage.tapOnAccountLogoutContinueBtn();
        Assert.assertTrue(indexPage.assertLogoDisplayed());

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(GlobalVars.getDataProviderJsonPath());
        return new Object[][]{{data.get(1)}};
        //return new Object[][]  {{data.get(0)}, {data.get(1)}, {data.get(2)}}; //for array multiple data set in the json file
    }

}
