package Pages;

import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountSuccessPage extends BasePage {

    private static Logger log = LogManager.getLogger(AccountSuccessPage.class);
    WebDriver driver;
    AccountPage accountPage;
    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement accountSuccessPageHeading;
    @FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
    private WebElement congratulationsMsg;
    @FindBy(css = "div[id='content'] h1")
    private WebElement accountSuccessfullCreatedMsg;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement msgConfirmation;

    @FindBy(css = "a.btn.btn-primary") // logoutPage, loginPage, accoutSuccessPage
    private WebElement continueBtn;

    public AccountSuccessPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getYourAccountHasBeenCreatedHeadingTxt() {
        return new VerificationHelper(driver).getText(accountSuccessfullCreatedMsg);
    }

    public boolean assertYourAccountHasBeenCreatedHeadingTxtDisplayed()
            throws InterruptedException {
        Thread.sleep(4000);
        return new VerificationHelper(driver).isDisplayed(accountSuccessfullCreatedMsg);
    }

    public boolean assertCongratulationsAccountSuccessfullyCreatedMsgDisplayed() {
        return new VerificationHelper(driver).isDisplayed(congratulationsMsg);
    }

    public AccountPage clickOnAccountSuccessContinueBtn() throws IOException {
        log.info("clicked :: " + continueBtn.getText());
        continueBtn.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }

    public String getConfirmationMsg() {
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());

        }

    }

    public String retrieveAccountSuccessPageHeading() {
        return getPageHeaderTxt();

    }

}
