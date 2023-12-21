package testCases.Login;

import Pages.AccountLoginPage;
import Pages.AccountLogoutPage;
import Pages.AccountPage;
import Pages.IndexPage;
import TestComponents.BaseTest;
import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataDrivenTest extends BaseTest {
    private final Logger log = LoggerHelper.getLogger(LoginDataDrivenTest.class);
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;

    @Test(dataProvider = "LoginData", dataProviderClass = DataProvider.class)
    public void test_LoginDDT(String email, String pwd, String exp) {
        log.info("**********Started LoginDataDrivenTest**********");

        try {
            indexPage = new IndexPage(driver);
            accountLoginPage = indexPage.clickMyAccountAndLoginLink();
            accountPage = accountLoginPage.loginInApplication(email, pwd);
            accountLoginPage.clickOnLoginBtn();
            boolean targetpage = accountPage.assertMyAccountTxtIsDisplayed();// this method is created MyAccountPage

            if (exp.equals("Valid")) {
                if (targetpage) {
                    accountLogoutPage = accountPage.clickOnLogoutSideWidgetAccountLink();
                    Assert.assertTrue(true);
                } else {
                    Assert.fail();
                }
            }

            if (exp.equals("Invalid")) {
                if (targetpage) {
                    accountLogoutPage = accountPage.clickOnLogoutSideWidgetAccountLink();
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            Assert.fail();
        }

        log.info("**********Finished LoginDataDrivenTest**********");

    }

}
