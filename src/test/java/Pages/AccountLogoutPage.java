package Pages;

import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountLogoutPage extends BasePage {

    private final Logger log = LogManager.getLogger(AccountLogoutPage.class);
    WebDriver driver;
    @FindBy(linkText = "Continue")
    WebElement accountLogoutContinueBtn;
    @FindBy(css = "div[id='content'] h1")
    WebElement accountLogoutTxt;
    @FindBy(css = "a.btn.btn-primary") // logoutPage, loginPage, accoutSuccessPage
    private WebElement continueBtn;


    public AccountLogoutPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public IndexPage tapOnAccountLogoutContinueBtn() throws IOException {
        log.info("clicked :: " + accountLogoutContinueBtn.getText());
        continueBtn.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new IndexPage(driver);
    }

    public IndexPage clickAccountLogoutContinueBtn() throws IOException {
        waitElementToAppearFor(0);
        log.info("clicked :: " + continueBtn.getText());
        continueBtn.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        log.info("******************Test Ended******************");
        return new IndexPage(driver);
    }

    public String getAccountLogoutTxt() {
        return new VerificationHelper(driver).getText(accountLogoutTxt);

    }

}
