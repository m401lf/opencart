package Pages;

import helper.assertion.VerificationHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AccountRegisterPage extends BasePage {

    private final Logger log = LogManager.getLogger(AccountRegisterPage.class);
    WebDriver driver;
    AccountSuccessPage accountSuccessPage;
    IndexPage indexPage;
    String email = System.currentTimeMillis() + "Gen";
    // URL, LOGO, TEXTS//
    String accountCreatePageUrl = "http://localhost/opencartdemo/index.php?route=account/register&language=en-gb";
    //====================@FindBy(name = "")===============================//
    By SectionHeaderTxt = By.xpath("//legend[normalize-space()='Newsletter']");
    @FindBy(name = "firstname")
    private WebElement txtFirstname;
    @FindBy(name = "lastname")
    private WebElement txtLasttname;
    @FindBy(name = "email")
    private WebElement txtEmail;
    @FindBy(name = "telephone")
    private WebElement txtTelephone;
    @FindBy(name = "password")
    private WebElement txtPassword;
    @FindBy(name = "confirm")
    private WebElement txtConfirmPassword;
    @FindBy(name = "agree")
    private WebElement chkdPolicy;
    @FindBy(css = "input.btn.btn-primary")
    private WebElement continueBtn;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue;
    @FindBy(xpath = "//li[3]/a[@innertext='Register']")
    private WebElement registerSubMenu;
    @FindBy(css = "div[id='content'] h1")
    private WebElement registerAccountHeader;
    @FindBy(css = "div[id='content'] p")
    private WebElement ifYouAlreadyHaveAnAccountWithUs;
    //===================================================//
    @FindBy(css = "#form-register")
    private WebElement form;

    //**************Your Personal Details**************//
    @FindBy(css = "class='col-sm-2 col-form-label'")
    private List<WebElement> labels;
    @FindBy(xpath = "//legend[normalize-space()='Your Personal Details']")
    private WebElement yourPersonalDetailsSection;
    @FindBy(xpath = "//legend[normalize-space()='Your Password']")
    private WebElement yourPasswordSection;
    @FindBy(xpath = "//legend[normalize-space()='Newsletter']")
    private WebElement newsletterSection;
    @FindBy(id = "input-firstname")
    private WebElement firstName;
    @FindBy(id = "input-lastname")
    private WebElement lastName;
    @FindBy(id = "input-email")
    private WebElement emailAddress;
    @FindBy(id = "input-telephone")
    private WebElement telephone;

    @FindBy(xpath = "fieldset:nth-of-type(2) > legend")
    private WebElement yourPassword;
    @FindBy(id = "input-password")
    private WebElement password;
    //**************Your Password*****************//
    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;

    //**************Newsletter**********************//

    @FindBy(css = "/html/body/div[2]/div/div/form/fieldset[3]/div/div/label/input")
    private List<WebElement> SubscribeRadioButtonList;

    @FindBy(css = "fieldset:nth-of-type(3) > legend")
    private WebElement newsletterHeader;
    @FindBy(xpath = "//label[@innertext='Subscribe']")
    private WebElement SubscribeLabel;
    @FindBy(xpath = "//label[normalize-space()='Yes']")
    private WebElement subscribeYesRadioButtonLabel;

    @FindBy(name = "newsletter")
    private WebElement newsletterSubscribeYesButton;
    @FindBy(css = "[checked='checked']")
    private WebElement newsletterSubscribeNoButton;
    @FindBy(css = "div[class='pull-right']")
    private WebElement agreeToPrivacyPolicy;
    @FindBy(css = "a[class='agree'] b")
    private WebElement privacyPolicy;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement agreeToPrivacyPolicyButton;
    @FindBy(css = "input.btn.btn-primary")
    private WebElement continueButton; //
    @FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    private WebElement firstnameRedMessage;

    //**********ERRORS ********************//
    @FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    private WebElement lastNameRedMessage;
    @FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
    private WebElement emailRedMessage;
    @FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
    private WebElement passwordRedMessage;
    @FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
    private WebElement telephoneRedMessage;
    @FindBy(css = ".alert-dismissible")
    private WebElement privacyPolicyError;
    @FindBy(xpath = "/html/body/div/div/div/form/fieldset/div/label")
    private List<WebElement> labelList;
    @FindBy(css = ".form-group.required")
    private List<WebElement> requiredFieldsList;

    public AccountRegisterPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSubscribeYesRadioButtonLabel() {
        return new VerificationHelper(driver).getText(subscribeYesRadioButtonLabel);

    }

    public void clickOnAgreeToPrivacyPolicyButton() {
        agreeToPrivacyPolicyButton.click();

    }

    public List<WebElement> getLabels() {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                ExpectedConditions.visibilityOfAllElements(labels));
    }

    public List<WebElement> getLabelListText() {
        for (WebElement label : labels) {
            if (label.isDisplayed()) {
                String labelName = label.getText();
                System.out.println(labelName);
            }
        }
        return labels;
    }

    public String getAgreeToPrivacyPolicyText() {
        return new VerificationHelper(driver).getText(agreeToPrivacyPolicy);

    }

    public WebElement getForm() {
        return form;

    }

    public void assertLabels_size_positions(int labelCourt, String firstname, String subscribe) {
        int size = labels.size();
        System.out.println("Size of labels: " + size);
        log.info("Size of labels: " + size);
        for (WebElement label : labels) {
            String labelsText = label.getText();
            log.info(labelsText);
            System.out.println(labelsText);
            if (labels.get(0).getText().trim().contains(firstname) || labels.get(5).getText().trim()
                    .contains(subscribe)) {
                Assert.assertEquals(size, labelCourt);

            }

        }

    }

    public int getLabelResultsCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until((d) -> this.labels.size() > 4);
        return this.labels.size();
    }

    public String getIfYouAlreadyHaveAnAccountWithUs() {
        return new VerificationHelper(driver).getText(ifYouAlreadyHaveAnAccountWithUs);
    }

    public String getYourPersonalDetailsTxt() {
        return new VerificationHelper(driver).getText(yourPersonalDetailsSection);
    }

    public boolean assertYourPersonalDetailsIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(yourPersonalDetailsSection);
    }

    public void inputFirstName(String fname) {
        firstName.clear();
        firstName.sendKeys(fname);
    }

    public void inputLastName(String lName) {
        lastName.clear();
        lastName.sendKeys(lName);
    }

    public void inputTelephone(String tel) {
        telephone.clear();
        telephone.sendKeys(tel);
    }

    public void inputPersonalDetails(String firstName, String lastName, String tel) {
        log.info("Entering personal details....");
        inputFirstName(firstName);
        inputLastName(lastName);
        inputEmailAddress();
        inputTelephone(tel);
        log.info("Finalised entering personal details....");
    }

    public void inputPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void inputConfirmPassword(String conpass) {
        confirmPassword.clear();
        confirmPassword.sendKeys(conpass);
    }


    public void inputPasswordAndConfirmPassword(String pass, String confirmPass) {
        inputPassword(pass);
        inputConfirmPassword(confirmPass);
    }


    public boolean assertNewsletterHeaderTextDisplayed() {
        return new VerificationHelper(driver).isDisplayed(newsletterHeader);
    }

    public boolean assertSubscribeLabelDisplayed() {
        return new VerificationHelper(driver).isDisplayed(SubscribeLabel);

    }

    public boolean assertSubscribeButtonSelected() {
        return new VerificationHelper(driver).isSelected(newsletterSubscribeYesButton);

    }

    public void tickOnYesSubscribeRadioButton() {
        newsletterSubscribeYesButton.click();

    }

    public void tickOnNewsletterSubscribeNoButton() {
        newsletterSubscribeNoButton.click();

    }


    public int getCountOfAllRequiredFields() {
        int size = requiredFieldsList.size();
        System.out.println("Size of labels: " + size);
        log.info("Size of labels: " + size);
        return size;
    }


    public String getPrivacyPolicyText() {
        return new VerificationHelper(driver).getText(privacyPolicy);

    }

    public boolean assertPrivacyPolicyRadioBtnSelected() {
        return new VerificationHelper(driver).isSelected(agreeToPrivacyPolicyButton);

    }

    public String getContinueBtn() {
        return new VerificationHelper(driver).getText(continueBtn);

    }

    public String getYourPasswordTxt() {
        return new VerificationHelper(driver).getText(yourPasswordSection);

    }

    public String getYourNewsletterTxt() {
        return new VerificationHelper(driver).getText(newsletterSection);

    }

    public String assertRegisterAccountHeader() {
        return new VerificationHelper(driver).getText(registerAccountHeader);

    }

    public String warningYouMustAgreeToPrivacyPolicyTxt() {
        return new VerificationHelper(driver).getText(privacyPolicyError);

    }


    public String assertEmailRedMessage() {
        return new VerificationHelper(driver).getText(emailRedMessage);

    }

    public String assertFirstnameRedMessage() {
        return new VerificationHelper(driver).getText(firstnameRedMessage);

    }

    public String assertLastnameRedMessage() {
        return new VerificationHelper(driver).getText(lastNameRedMessage);

    }

    public String assertTelephoneRedMessage() {
        return new VerificationHelper(driver).getText(telephoneRedMessage);

    }

    public String assertPasswordRedMessage() {
        return new VerificationHelper(driver).getText(passwordRedMessage);

    }

    public List<WebElement> getLabelList() {
        return labelList;

    }

    public List<WebElement> getRequiredFieldsList() {
        return requiredFieldsList;

    }

    public void clickAccountRegisterContinueBtn() {
        log.info("clicked :: " + continueButton.getText());
        continueButton.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
    }

    public long assertRequiredFields() {
        return requiredFieldsList.size();

    }

    public String retrievePasswordWarning() {
        return new VerificationHelper(driver).getText(passwordRedMessage);

    }

    public String retrieveTelephoneWarning() {
        return new VerificationHelper(driver).getText(telephoneRedMessage);

    }

    public String retrieveEmailWarning() {
        return new VerificationHelper(driver).getText(emailRedMessage);

    }

    public String retrieveLastNameWarning() {
        return new VerificationHelper(driver).getText(lastNameRedMessage);

    }

    public String retrieveFirstNameWarning() {
        return new VerificationHelper(driver).getText(firstnameRedMessage);

    }

    public String retrievePrivacyPolicyWarning() {
        return new VerificationHelper(driver).getText(privacyPolicyError);

    }

    public AccountSuccessPage registerWithMandatoryFields(
            String firstNameText, String lastNameText,
            String emailText, String telephoneText,
            String passwordText) throws IOException {
        firstName.sendKeys(firstNameText);
        lastName.sendKeys(lastNameText);
        emailAddress.sendKeys(emailText);
        telephone.sendKeys(telephoneText);
        password.sendKeys(passwordText);
        confirmPassword.sendKeys(passwordText);
        agreeToPrivacyPolicy.click();
        continueButton.click();
        return new AccountSuccessPage(driver);

    }

    public AccountSuccessPage registerWithAllFields(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText)
            throws IOException {
        firstName.sendKeys(firstNameText);
        lastName.sendKeys(lastNameText);
        emailAddress.sendKeys(emailText);
        telephone.sendKeys(telephoneText);
        password.sendKeys(passwordText);
        confirmPassword.sendKeys(passwordText);
        newsletterSubscribeYesButton.click();
        privacyPolicy.click();
        continueButton.click();
        return new AccountSuccessPage(driver);

    }

    public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning) {

        boolean privacyPolicyWarningStatus = retrievePrivacyPolicyWarning().contains(expectedPrivacyPolicyWarning);
        boolean firstNameWarningStatus = retrieveFirstNameWarning().equals(expectedFirstNameWarning);
        boolean lastNameWarningStatus = retrieveLastNameWarning().equals(expectedLastNameWarning);
        boolean emailWarningStatus = retrieveEmailWarning().equals(expectedEmailWarning);
        boolean telephoneWarningStatus = retrieveTelephoneWarning().equals(expectedTelephoneWarning);
        boolean passwordWarningStatus = retrievePasswordWarning().equals(expectedPasswordWarning);
        return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
    }

    public AccountSuccessPage clickOnContinueButton() throws IOException {
        log.info("clicked :: " + continueButton.getText());
        continueButton.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
        return new AccountSuccessPage(driver);

    }

    public AccountSuccessPage clickOnAccountRegisterContinueBtn() throws IOException {
        log.info("clicked :: " + continueButton.getText());
        continueButton.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
        return new AccountSuccessPage(driver);
    }

    public void assertContinueButtonIsEnabled() {
        Assert.assertTrue(continueButton.isEnabled(), "Continue Button not enabled");
    }

    public boolean isNewsletterSubscribeNoButtonSelected() {
        return new VerificationHelper(driver).isSelected(newsletterSubscribeNoButton);

    }
}