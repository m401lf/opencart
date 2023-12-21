package testCases.Register;

import Pages.*;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.GlobalVars;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

//@Listeners(TestComponents.Listeners.class)
public class RegistrationTest_Using_Global_Variables extends BaseTest {

    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    AccountRegisterPage accountRegisterPage;
    AccountSuccessPage accountSuccessPage;
    AccountPage accountPage;
    AccountEditPage accountEditPage;
    AccountLogoutPage accountLogoutPage;

    @Test(dataProvider = "getData", groups = {
            "Register"}, description = "Registration Test Using Global Input")
    public void RegistrationTestUsingGlobalVariables(HashMap<String, String> input) throws Exception {
        indexPage = new IndexPage(driver);
        Assert.assertEquals(indexPage.getCurrentPageTitle(), (GlobalVars.getHomePageTitle()));
        Assert.assertEquals(indexPage.getCurrentPageUrl(), (GlobalVars.getHomePageUrl()));
        Assert.assertTrue(indexPage.assertLogoDisplayed());
        accountRegisterPage = indexPage.clickMyAccountAndRegisterLink();
        Assert.assertTrue(indexPage.getCurrentPageTitle().contains(GlobalVars.getAccountCreatePageTitle()));
        Assert.assertTrue(indexPage.getCurrentPageUrl().contains(GlobalVars.getAccountCreatePageUrl()));
        Assert.assertTrue(indexPage.assertLogoDisplayed());
        Assert.assertTrue(indexPage.assertPageHeaderIsDisplayed());
        Assert.assertTrue(accountRegisterPage.assertYourPersonalDetailsIsDisplayed());
        accountRegisterPage.inputPersonalDetails(input.get("fName"), input.get("lName"), input.get("tel"));
        accountRegisterPage.inputPassword(input.get("password"));
        accountRegisterPage.inputConfirmPassword(input.get("password"));
        accountRegisterPage.tickOnYesSubscribeRadioButton();
        accountRegisterPage.clickOnAgreeToPrivacyPolicyButton();
        accountSuccessPage = accountRegisterPage.clickOnAccountRegisterContinueBtn();
        accountPage = accountSuccessPage.clickOnAccountSuccessContinueBtn();
        accountEditPage = accountPage.tapOnEditAccountLink();
        accountPage = accountEditPage.clickOnEditAccountContinueButton();
        accountLogoutPage = accountPage.clickOnLogoutSideWidgetAccountLink();
        indexPage = accountLogoutPage.clickAccountLogoutContinueBtn();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//data//Register.json");
        return new Object[][]{{data.get(0)}};
        //return new Object[][]  {{data.get(0)}, {data.get(0)}}; //for array multiple data set in the json file
    }

}
    


