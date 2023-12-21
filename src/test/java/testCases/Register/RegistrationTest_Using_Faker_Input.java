package testCases.Register;

import Pages.*;
import TestComponents.BaseTest;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;

@Listeners(TestComponents.Listeners.class)

public class RegistrationTest_Using_Faker_Input extends BaseTest {
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    AccountRegisterPage accountRegisterPage;
    AccountSuccessPage accountSuccessPage;
    AccountPage accountPage;
    AccountEditPage accountEditPage;
    AccountLogoutPage accountLogoutPage;
    Faker faker;

    @Test()
    public void RegistrationTestUsingFakerInput() throws IOException, InterruptedException {
        faker = new Faker(Locale.UK);
        indexPage = new IndexPage(driver);
        accountLoginPage = indexPage.clickMyAccountAndLoginLink();
        accountRegisterPage = accountLoginPage.clickContinueButtonInAccountLogin();
        accountRegisterPage.inputFirstName(faker.name().firstName());
        accountRegisterPage.inputLastName(faker.name().lastName());
        accountRegisterPage.inputEmailAddress();
        accountRegisterPage.inputTelephone(faker.phoneNumber().cellPhone());
        accountRegisterPage.inputPassword("Password");
        accountRegisterPage.inputConfirmPassword("Password");
        Assert.assertTrue(accountRegisterPage.isNewsletterSubscribeNoButtonSelected());
        accountRegisterPage.tickOnYesSubscribeRadioButton();
        accountRegisterPage.clickOnAgreeToPrivacyPolicyButton();
        accountSuccessPage = accountRegisterPage.clickOnAccountRegisterContinueBtn();
        Assert.assertTrue(accountSuccessPage.assertPageHeaderIsDisplayed());
        accountPage = accountSuccessPage.clickOnAccountSuccessContinueBtn();
        accountEditPage = accountPage.clickOnYourEditAccountInformationLink();
        Assert.assertTrue(accountEditPage.assertPageHeaderIsDisplayed());
        accountPage = accountEditPage.clickOnEditAccountContinueButton();
        accountLogoutPage = accountPage.clickOnLogoutSideWidgetAccountLink();
        indexPage = accountLogoutPage.clickAccountLogoutContinueBtn();


    }

}
