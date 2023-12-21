package testCases.Register;

import Pages.*;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

//@Listeners(TestComponents.Listeners.class)

public class RegistrationTest_Using_Json_Input extends BaseTest {

    IndexPage indexPage;
    AccountRegisterPage accountRegisterPage;
    AccountSuccessPage accountSuccessPage;
    AccountPage accountPage;
    AccountEditPage accountEditPage;
    AccountLogoutPage accountLogoutPage;

    @Test(dataProvider = "getData", groups = {"Register"}, description = "Registration Test Using Json Inputs")
    public void RegistrationTestUsingJsonInput(HashMap<String, String> input) throws Exception {
        indexPage = new IndexPage(driver);
        Assert.assertEquals(indexPage.getCurrentPageTitle(), (input.get("pageTitle")));
        Assert.assertEquals(indexPage.getCurrentPageUrl(), (input.get("pageUrl")));
        Assert.assertTrue(indexPage.assertLogoDisplayed());
        accountRegisterPage = indexPage.clickMyAccountAndRegisterLink();
        Assert.assertTrue(accountRegisterPage.getCurrentPageTitle().contains(input.get("registerPageTitle")));
        Assert.assertTrue(accountRegisterPage.getCurrentPageUrl().contains(input.get("registerPageUrlPath")));
        Assert.assertTrue(accountRegisterPage.assertLogoDisplayed());
        Assert.assertTrue(accountRegisterPage.assertPageHeaderIsDisplayed());
        Assert.assertTrue(accountRegisterPage.assertYourPersonalDetailsIsDisplayed());
        accountRegisterPage.inputPersonalDetails(input.get("fName"), input.get("lName"), input.get("tel"));
        accountRegisterPage.inputPassword(input.get("password"));
        accountRegisterPage.inputConfirmPassword(input.get("password"));
        accountRegisterPage.inputTelephone(input.get("tel"));
        accountRegisterPage.tickOnYesSubscribeRadioButton();
        accountRegisterPage.clickOnAgreeToPrivacyPolicyButton();
        accountSuccessPage = accountRegisterPage.clickOnAccountRegisterContinueBtn();
        Assert.assertTrue(accountSuccessPage.assertPageHeaderIsDisplayed());
        accountPage = accountSuccessPage.clickOnAccountSuccessContinueBtn();
        accountEditPage = accountPage.tapOnEditAccountLink();
        accountPage = accountEditPage.clickOnEditAccountContinueButton();
        accountLogoutPage = accountPage.tapOnLogoutLinkFromAsideWidget();
        indexPage = accountLogoutPage.clickAccountLogoutContinueBtn();
        Assert.assertTrue(indexPage.assertLogoDisplayed());
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//data//Register.json");
        return new Object[][]{{data.get(0)}};
        //return new Object[][]  {{data.get(0)}, {data.get(0)}}; //for array multiple data set in the json file
    }

}
