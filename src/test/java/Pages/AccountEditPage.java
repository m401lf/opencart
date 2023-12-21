package Pages;

import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountEditPage extends BasePage {
    private final Logger log = LogManager.getLogger(AccountEditPage.class);
    WebDriver driver;
    @FindBy(xpath = "div[id='content'] h1")
    private WebElement myAccountInformationHeadingtext;
    @FindBy(xpath = "//?/legend[@innertext='Your Personal Details']")
    private WebElement yourPersonalDetails;
    @FindBy(id = "input-firstname")
    private WebElement firstNameBox;
    @FindBy(id = "input-lastname")
    private WebElement lastNameBox;
    @FindBy(id = "input-email")
    private WebElement emailBox;
    @FindBy(id = "input-telephone")
    private WebElement telephone;
    @FindBy(css = "input[value='Continue']")
    private WebElement continueButton;

    public AccountEditPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean assertMyAccountInformationHeadingTxt() {
        return new VerificationHelper(driver).isDisplayed(myAccountInformationHeadingtext);

    }

    public String getMyaccountInformationHeadingTxt() {
        return new VerificationHelper(driver).getText(myAccountInformationHeadingtext);

    }

    public void enterFirstName(String firstname) {
        firstNameBox.clear();
        firstNameBox.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        lastNameBox.clear();
        lastNameBox.sendKeys(lastname);
    }

    public void enterFreshEmail() {
        String email = System.currentTimeMillis() + "@gmail.com";
        emailBox.clear();
        emailBox.sendKeys(email);

    }

    public void enterTelephone(String tel) {
        telephone.clear();
        telephone.sendKeys(tel);

    }

    public void updatingProfileDetails(String firstname, String lastname) {
        log.info("editing Profile Details....");
        enterFirstName(firstname);
        enterLastName(lastname);
        enterFreshEmail();
        log.info("editing Profile Details....");
    }

    public AccountPage clickOnEditAccountContinueButton() throws IOException {
        log.info("clicked :: " + continueButton.getText());
        continueButton.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }

    public String getMyPersonalDetailsTxt() {
        return new VerificationHelper(driver).getText(yourPersonalDetails);

    }

}
