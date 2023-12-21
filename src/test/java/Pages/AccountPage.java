package Pages;

import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class AccountPage extends BasePage {

    private final Logger log = LogManager.getLogger(AccountPage.class);
    WebDriver driver;
    AccountEditPage accountEditPage;
    @FindBy(xpath = "//a[normalize-space()='Edit your account information']")
    WebElement editAccountInformationLink;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logoutSideWidgetAccountLink;
    @FindBy(css = "a.list-group-item")
    List<WebElement> aSideWidgetAccountLinks;
    By asideWidget = By.xpath("//aside[#'column-right']/?/?/a[@innertext='My Account']");
    @FindBy(linkText = "Edit your account information")
    private WebElement editYourAccountInformationOption;
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccount;
    @FindBy(css = ".dropdown-toggle > .fa-solid.fa-user")
    private WebElement userProfileIcon;
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccountTopMenuTxt;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successYourAccountSuccessfullyUpdatedTxt;
    @FindBy(linkText = "My Orders")
    private WebElement myOrderTxt;
    @FindBy(xpath = "/html/body/main/div/div/div/ul/li/a")
    private List<WebElement> allSubLinks;

    public AccountPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean assertMyAccountTxtIsDisplayed() {
        try {
            return (myAccount.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

    public boolean assertUserProfileIconDisplayed() {
        return new VerificationHelper(driver).isDisplayed(userProfileIcon);

    }

    public String getSuccessYourAccountSuccessfullyUpdatedTxt() {
        return new VerificationHelper(driver).getText(successYourAccountSuccessfullyUpdatedTxt);

    }

    public boolean assertSuccessYourAccountSuccessfullyUpdatedTxtIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(successYourAccountSuccessfullyUpdatedTxt);

    }

    public String getMyAccountTxt() {
        return new VerificationHelper(driver).getText(myAccount);

    }

    public String getMyOrderTxt() {
        return new VerificationHelper(driver).getText(myOrderTxt);

    }

    public boolean assertMyOrderTxtDisplayed() {
        return new VerificationHelper(driver).isDisplayed(myOrderTxt);

    }

    public AccountLogoutPage clickMatchingItemFromAsideWidget(String item) throws IOException {
        driver.findElement(By.xpath("//aside[#'column-right']/?/?/a[@innertext='" + item + "']"))
                .click();
        return new AccountLogoutPage(driver);
    }


    public boolean assertAllSubHeadingLinksDisplayed() {
        return new VerificationHelper(driver).isDisplayed((WebElement) allSubLinks);

    }

    public boolean getDisplayStatusOfEditYourAccountInformationOption() {
        return editYourAccountInformationOption.isDisplayed();
    }


}