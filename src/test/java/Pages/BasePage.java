package Pages;

import Pages.components.*;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.Uninterruptibles;
import helper.action.ScrollPage;
import helper.action.WebElementOrderChecker;
import helper.action.WebElementOrderCheckerImpl;
import helper.assertion.VerificationHelper;
import helper.javaScript.JavaScriptHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.function.Consumer;

public class BasePage {
    private final Logger log = LogManager.getLogger(BasePage.class);
    WebDriver driver;
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    AccountRegisterPage accountRegisterPage;
    AccountPage accountPage;
    AccountEditPage accountEditPage;
    AccountSuccessPage accountSuccessPage;
    AccountLogoutPage accountLogoutPage;
    @FindBy(css = ".fas.fa-home")
    WebElement homeIcon;
    @FindBy(css = "input[value='Continue']")
    WebElement continueAccountSuccessBtn;
    By asideWidget = By.xpath("//aside[#'column-right']/?/?/a[@innertext='My Account']");
    @FindBy(xpath = "/html/body/nav/div/div/ul/li")
    List<WebElement> topMenuList;
    @FindBy(css = ".dropdown-menu a")
    List<WebElement> topMenuDropdownItemList;
    @FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[2]/ul//a")
    List<WebElement> topMenuMyAccountDropdownItemList;
    @FindBy(xpath = "/html/body/nav/div/div[1]/ul/li[1]/form/div/ul/li/a")
    List<WebElement> currencyDropdown;
    @FindBy(xpath = "/html/body/nav/div/div[2]/ul/li/a/i")
    List<WebElement> topMenuListIcons;
    @FindBy(xpath = ".//*")
    List<WebElement> allPageElements;
    @FindBy(css = ".swiper-pagination-bullet")
    List<WebElement> swiperSliderpaginationBulletList;
    @FindBy(xpath = "/html/body/div[1]/nav/div[2]/ul/li/a")
    List<WebElement> subcategories;
    @FindBy(xpath = "/html/body/div/nav/div/ul/li/div/div/ul/li/a")
    List<WebElement> subCategoriesDropdownList;
    @FindBy(xpath = "/html/body/div[2]/div/aside/div/a")
    List<WebElement> sideWidgetLinks;
    @FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
    WebElement regionStateDropdownBtn;
    @FindBy(id = "logo")
    WebElement logo;
    @FindBy(css = "div[id='content'] h1")
    WebElement pageHeader;
    @FindBy(css = ".btn.btn-lg.btn-inverse.btn-block.dropdown-toggle")
    WebElement header_cart;
    @FindBy(css = "a")
    WebElement aTag;
    @FindBy(xpath = "/html/body/main/div/div/aside/div/a")
    List<WebElement> asideWidgetLinks;
    @FindBy(css = "img[title='Your Store']")
    WebElement logoImage;
    @FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/div/div")
    List<WebElement> allProductsList;
    @FindBy(id = "input-email")
    WebElement emailAddress;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logoutSideWidgetAccountLink;
    @FindBy(xpath = "//span[@innertext='Currency']")
    private WebElement currency;
    @FindBy(xpath = "//strong[normalize-space()='$']")
    private WebElement currencySign;
    @FindBy(css = "input[placeholder='Search']")
    private WebElement search;
    @FindBy(css = ".fa.fa-search")
    private WebElement searchBtn;
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    private WebElement myAccountTxt;
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement lnkMyaccount;
    @FindBy(linkText = "Logout")
    private WebElement lnkLogout;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement lnkRegister;
    @FindBy(xpath = "//a[contains(text(),'Login')]") // Login link added in step6
    private WebElement lnkLogin;
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccount;
    @FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
    private WebElement shoppingCart;
    @FindBy(xpath = "//span[normalize-space()='Checkout']")
    private WebElement checkout;
    @FindBy(xpath = "//*[@id='top-links']/ul/li[1]/span")
    private WebElement telephone;
    @FindBy(css = ".fa.fa-phone")
    private WebElement telephoneIcon;
    @FindBy(xpath = "//*[@id='wishlist-total']/span")
    private WebElement wishlist;
    @FindBy(css = "a[id='wishlist-total'] i[class='fa fa-heart']")
    private WebElement wishlistIcon;
    @FindBy(css = ".btn.btn-lg.btn-inverse.btn-block.dropdown-toggle")
    private WebElement cartItemsBlackIcon;
    @FindBy(css = "div > a:nth-of-type(2)")
    private WebElement editAccountsideWidgetAccountLink;
    @FindBy(xpath = "//a[normalize-space()='Edit your account information']")
    private WebElement editYourAccountInformation;
    @FindBy(linkText = "Continue")
    private WebElement ContinueBtn;
    @FindBy(css = "input[class='btn btn-primary']")
    private WebElement loginButton;
    @FindBy(css = "input[value='Login']")
    private WebElement loginBtn;
    @FindBy(css = "a[class='btn btn-default']")
    private WebElement backButton;
    @FindBy(css = "input[value='Continue']")
    private WebElement continueButton; // editPage, registrationPage
    @FindBy(css = "a.btn.btn-primary") // logoutPage, loginPage, accoutSuccessPage
    private WebElement continueBtn;
    @FindBy(xpath = "/html/body/main/div[2]/ul/li[2]")
    private List<WebElement> breadCrumbList;
    @FindBy(css = ".fa.fa-times")
    private WebElement removeItemIcon;
    @FindBy(css = "p.text-center")
    private WebElement yourshoppingCartIsEmpty;
    @FindBy(xpath = "//strong[normalize-space()='View Cart']")
    private WebElement viewCartLink;
    @FindBy(xpath = "//strong[normalize-space()='Checkout']")
    private WebElement checkoutLink;
    @FindBy(css = "td[class='text-left'] a")
    private WebElement productName;
    @FindBy(css = "img[class='img-thumbnail']")
    private WebElement productImage;
    @FindBy(css = "tr > td:nth-of-type(4)")
    private WebElement productPrice;
    @FindBy(css = "tr:nth-of-type(4) > td:nth-of-type(2)")
    private WebElement totalPrice;
    @FindBy(css = "ul.dropdown-menu.pull-right")
    private WebElement cartItemsBlackIconDropdown;
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountDropMenu;
    @FindBy(linkText = "Login")
    private WebElement loginOption;
    @FindBy(linkText = "Register")
    private WebElement registerOption;
    @FindBy(name = "search")
    private WebElement searchBoxField;
    @FindBy(xpath = "//div[@id='search']/descendant::button")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logoutAsideWidget;
    //==========================================================================================//

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement signout;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btn_Continue;
    @FindBy(how = How.LINK_TEXT, using = "Back")
    private WebElement lnk_back;
    @FindBy(how = How.XPATH, using = "//a[text() = 'feedback']")
    private WebElement feedbackLink;


    // *************** Radio Buttons ************ //
    @FindBy(css = "input[placeholder='Search']")
    private WebElement searchBox;
    @FindBy(how = How.CSS, using = "input.nhsuk-radios__input")
    private List<WebElement> radioBtns;
    @FindBy(how = How.CSS, using = "label.nhsuk-radios__label")
    private List<WebElement> radioBtnsLabels;
    // *************** Input labels ************ //
    @FindBy(how = How.CSS, using = "label.nhsuk-label")
    private List<WebElement> inputLabels;


    // ********* Footer links **************
    @FindBy(how = How.ID, using = "employer_sign_out")
    private WebElement lnk_employer_signOut;
    @FindBy(how = How.ID, using = "privacy-policy")
    private WebElement privacyPolicyLink;
    @FindBy(how = How.ID, using = "privacy")
    private WebElement candidatePrivacyPolicyLink;
    // @FindBy(how = How.XPATH, using = "//a[text()='Terms and conditions']")
    @FindBy(how = How.ID, using = "terms-conditions")
    private WebElement termsandconditionsLink;
    @FindBy(how = How.ID, using = "acceptableUse")
    private WebElement canTermsAndConditionsLink;
    @FindBy(how = How.XPATH, using = "//a[text()='Cookies']")
    private WebElement cookiesLink;
    @FindBy(how = How.CLASS_NAME, using = "nhsuk-details__summary-text")
    private WebElement googleAnalyticsLink;
    @FindBy(how = How.ID, using = "essential-cookies")
    private WebElement essentialCookiesLink;
    @FindBy(how = How.LINK_TEXT, using = "Find out how to manage cookies.")
    private WebElement manageCookiesLink;
    @FindBy(how = How.LINK_TEXT, using = "privacy policy")
    private WebElement policyPrivacyLink;
    @FindBy(how = How.CLASS_NAME, using = "nhsuk-radios__item")
    private WebElement useGoogleAnalyticsRadioBtn;
    @FindBy(how = How.ID, using = "google-analytics-false")
    private WebElement doNotUseGoogleAnalyticsRadioBtn;
    @FindBy(how = How.CLASS_NAME, using = "nhsuk-radios__item")
    private List<WebElement> selectCookiePreference;
    @FindBy(how = How.ID, using = "save")
    private WebElement saveBtn;
    @FindBy(how = How.ID, using = "google-analytics-true")
    private WebElement useGoogleAnalyticsBtn;
    @FindBy(how = How.ID, using = "analytics_enabled-true")
    private WebElement candidateUseGoogleAnalyticsBtn;
    @FindBy(how = How.ID, using = "google-analytics-false")
    private WebElement doNotUseGoogleAnalyticsBtn;
    @FindBy(how = How.ID, using = "analytics_enabled-false")
    private WebElement candidateDoNotUseGoogleAnalyticsBtn;
    @FindBy(how = How.CLASS_NAME, using = "nhsuk-details__summary-text")
    private WebElement findMoreAboutGoogleAnalyticsCookiesLink;
    @FindBy(how = How.ID, using = "details-content-0")
    private WebElement detailsGoogleAnalytics;
    @FindBy(how = How.ID, using = "details-content-1")
    private WebElement detailsEssentialCookies;
    //	==============cookies banner==================
    @FindBy(how = How.ID, using = "cookie-banner")
    private WebElement cookieBanner;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void highlightMe(WebDriver driver, WebElement element) throws InterruptedException {
        // Creating JavaScriptExecuter Interface
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Execute javascript
        js.executeScript("arguments[0].style.border='4px solid yellow'", element);
        Thread.sleep(3000);
        js.executeScript("arguments[0].style.border=''", element);
    }

    //==========================================================================================//

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public static String generateEmailWithTimeStamp() {
        Date date = new Date();
        String timestamp = date.toString().replace(" ", "_").replace(":", "_");
        return "amotoori" + timestamp + "@gmail.com";

    }

    public static Object[][] getTestDataFromExcel(String sheetName) {
        File excelFile = new File(
                System.getProperty("user.dir") + "\\src\\test\\java\\userTestData\\data.xlsx");
        XSSFWorkbook workbook = null;
        try {
            FileInputStream fisExcel = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fisExcel);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for (int i = 0; i < rows; i++) {

            XSSFRow row = sheet.getRow(i + 1);

            for (int j = 0; j < cols; j++) {

                XSSFCell cell = row.getCell(j);
                CellType cellType = cell.getCellType();

                switch (cellType) {

                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i][j] = Integer.toString((int) cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;

                }

            }


        }

        return data;

    }

    public static String captureScreenshot(WebDriver driver, String testName) {
        File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationScreenshotPath =
                System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";

        try {
            FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destinationScreenshotPath;
    }

    public List<WebElement> getBreadCrumbList() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(breadCrumbList));
        return breadCrumbList;
    }

    public void inputEmailAddress() {
        String email = System.currentTimeMillis() + "@aol.com";
        emailAddress.clear();
        emailAddress.sendKeys(email);
    }

    public boolean assertItemDisplayedFromList(List<WebElement> listElements, String item) {
        boolean match = listElements.stream().parallel()
                .anyMatch(s -> s.getText().equalsIgnoreCase(item));
        return match;
    }

    public WebElement getPageHeader() {
        return pageHeader;

    }

    public String getCurrentPageUrl() {
        return new VerificationHelper(driver).getCurrentPageUrl();

    }

    public String getCurrentPageTitle() {
        return new VerificationHelper(driver).getCurrentPageTitle();

    }

    public List<WebElement> getAllElements() {
        return allPageElements;

    }

    public List<String> assertHeaderAndLabelsTxt(String headerOrtext) {
        List<String> list = allPageElements.stream()
                .filter(e -> e.getText().equalsIgnoreCase(headerOrtext)).map(WebElement::getText).toList();
        //System.out.println(list);
        return list;
    }

    public WebElement getaTag() {
        return aTag;

    }

    public String getPageHeaderTxt() {
        return new VerificationHelper(driver).getText(pageHeader);

    }

    public boolean assertPageHeaderIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(pageHeader);
    }

    public void waitAndSendKeys(WebElement findBy, String keysToSend) {
        findBy.clear();
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(findBy)).sendKeys(keysToSend);
    }

    public void waitAndClick(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(15));
        System.out.println("Clicked on :: " + findBy.getText());
        log.info("Clicked on :: " + findBy.getText());
        wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();

    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("Waited for the element :: " + element.getText());
        log.info("Waited for element visibility :: " + element.getText());
    }


    public void clickOnTextFromDropdownList(WebElement list, String textToSearchFor) {
        Wait<WebDriver> tempWait = new WebDriverWait(driver,
                Duration.ofSeconds(15));
        try {
            tempWait.until(ExpectedConditions.elementToBeClickable(list)).click();
            list.sendKeys(textToSearchFor);
            list.sendKeys(Keys.ENTER);
            System.out.println("Successfully sent the following keys: " + textToSearchFor
                    + ", to the following WebElement: " + "<" + list.toString() + ">");
        } catch (Exception e) {
            System.out.println("Unable to send the following keys: " + textToSearchFor
                    + ", to the following WebElement: " + "<" + list.toString() + ">");
            Assert.fail("Unable to select the required text from the dropdown menu, Exception: "
                    + e.getMessage());
        }
    }

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public void waitElementToAppearFor(int timeout) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(timeout));

    }

    public void assertTextShouldNotBeDisplayedInHeadingText(String headingText) {
        WebElement newHeading = driver.findElement(By.id("heading"));
        Assert.assertNotEquals(headingText, newHeading.getText());
    }

    public void waitForAlert_And_ValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = driver.switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, text);
    }

    public void clickMatchingElementByText(List<WebElement> elements, String productName) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(s -> s.getText().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text" + productName + "not present"));
        element.click();

    }

    public void clickAMatchingElementByText(List<WebElement> elements, String ItemName) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(s -> s.getText().equalsIgnoreCase(ItemName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text" + ItemName + "not present"));
        element.click();

    }

    public void navigateToApplicationUrlAndVerifyUrlPath(String homePageUrl, String urlPath) {
        driver.get(homePageUrl);
        driver.getCurrentUrl().contains(urlPath);
    }

    public List<String> getAccountsSectionsList(List<WebElement> products) {
        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements((By) products);
        for (WebElement e : accountsHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountsList.add(text);
        }
        return accountsList;
    }

    public void setImplicitWait(long timeout) {
        System.out.println("Implicit Wait has been set to: " + timeout);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    //================================Verify=====================================

    public boolean verifyTextContains(String actualText, String expText) {
        if (actualText.toLowerCase().contains(expText.toLowerCase())) {
            System.out.println("Actual Text From Web Application UI   --> : " + actualText);
            System.out.println("Expected Text From Web Application UI --> : " + expText);
            System.out.println("### Verification Contains !!!");
            return true;
        } else {
            System.out.println("Actual Text From Web Application UI   --> : " + actualText);
            System.out.println("Expected Text From Web Application UI --> : " + expText);
            System.out.println("### Verification DOES NOT Contains !!!");
            return false;
        }

    }

    public boolean verifyTextMatch(String actualText, String expText) {
        if (actualText.equals(expText)) {
            System.out.println("Actual Text From Web Application UI   --> : " + actualText);
            System.out.println("Expected Text From Web Application UI --> : " + expText);
            System.out.println("### Verification MATCHED !!!");
            return true;
        } else {
            System.out.println("Actual Text From Web Application UI   --> : " + actualText);
            System.out.println("Expected Text From Web Application UI --> : " + expText);
            System.out.println("### Verification DOES NOT MATCH !!!");
            return false;
        }
    }

    public Boolean verifyListContains(List<String> actList, List<String> expList) {
        int expListSize = expList.size();
        for (int i = 0; i < expListSize; i++) {
            if (!actList.contains(expList.get(i))) {
                return false;
            }
        }
        System.out.println("Actual List Contains Expected List !!!");
        return true;
    }

    public Boolean verifyListMatch(List<String> actList, List<String> expList) {
        boolean found = false;
        int actListSize = actList.size();
        int expListSize = expList.size();
        if (actListSize != expListSize) {
            return false;
        }

        for (int i = 0; i < actListSize; i++) {
            found = false;
            for (int j = 0; j < expListSize; j++) {
                if (verifyTextMatch(actList.get(i), expList.get(j))) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            System.out.println("Actual List Matches Expected List !!!");
            return true;
        } else {
            System.out.println("Actual List DOES NOT Match Expected List !!!");
            return false;
        }
    }

    public Boolean verifyItemPresentInList(List<String> actList, String item) {
        int actListSize = actList.size();
        for (int i = 0; i < actListSize; i++) {
            if (!actList.contains(item)) {
                System.out.println("Item is NOT present in List !!!");
                return false;
            }
        }
        System.out.println("Item is present in List !!!");
        return true;
    }

    public boolean isListAscendingOrder(List<Long> list) {
        return Ordering.natural().isOrdered(list);

    }

    public Iterator<String> getAllWindows() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        return itr;
    }

    public void getUrl(String url) {
        log.info("navigating to :-" + url);
        driver.get(url);
    }

    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }

    public boolean JSClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);

            flag = true;

        } catch (Exception e) {
            throw e;

        } finally {
            if (flag) {
                System.out.println("Click Action is performed: " + ele.getText());
            } else if (!flag) {
                System.out.println("Click Action is not performed: " + ele.getText());
            }
        }
        return flag;
    }

    public boolean assertHeaderTxtIsDisplayed(WebElement element) {
        return new VerificationHelper(driver).isDisplayed(element);
    }

    public ArrayList<Integer> getPriceMassagedData(Iterator<WebElement> itr) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (itr.hasNext()) {
            String p = itr.next().getText();
            if (p.contains("$")) {
                String actualData = p.substring(1);
                //log.info(actualData);
                double p1 = Double.parseDouble(actualData);
                int productPrice = (int) (p1);
                array.add(productPrice);
            }
        }
        return array;
    }

    //=======================================================//

    public WebElement getRegionStateDropdownBtn() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        return regionStateDropdownBtn;
    }

    public void selectFromRegionDropdown(Consumer<Select> consumer, WebElement element) {
        System.out.println("Option selected by VisibleText: " + "<" + element.getText() + ">");
        consumer.accept(new Select(element));
    }

    //=======================================================//

    public void click(WebElement element) {
        boolean flag = false;
        while (true) {
            try {
                element.click();
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
            if (flag) {
                try {
                    element.click();
                    System.out.printf(
                            "Element: " + element.getText() + " has been clicked, Selenium exception triggered");
                } catch (Exception e) {
                    System.out.printf(
                            "Element: " + element + " has beed clicked, Selenium exception triggered: "
                                    + e.getMessage());
                }
                break;
            }
        }
    }

    public boolean assertLogoDisplayed() {
        return new VerificationHelper(driver).isDisplayed(logo);

    }

    public void waitForElementInvisible(WebElement element, int timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void assertHeadingIsDisplayed() {
        Assert.assertTrue(pageHeader.isDisplayed(), "Heading not displayed");

    }

    public void assertIfSignOutButtonExists() {
        Assert.assertEquals("Sign Out", signout.getText());
    }

    // ********* Input Label names ********* //
    public void assertInputLabel(int i, String labelName) {
        Assert.assertEquals("Input label not matching", labelName, inputLabels.get(i).getText());
    }


    public void assertNoRadioButtonSelected() {
        Assert.assertTrue(radioBtns.get(1).isSelected(), "Radio button not selected");
    }

    public void assertYesRadioButtonSelected() {
        Assert.assertTrue(radioBtns.get(0).isSelected(), "Radio button not selected");
    }

    // ************** To validate Manage at risk Marker ******** //
    public void assertOnCorrectCookiesPreference(String userSelection) {
        ScrollPage.scrollToViewElement(driver, "google-analytics-true");
        Assert.assertTrue(useGoogleAnalyticsBtn.isSelected(), "Use google analytics Radio button not selected");
    }

    public void assertOnCorrectCandidateCookiesPreference(String userSelection) {
        Assert.assertTrue(candidateUseGoogleAnalyticsBtn.isSelected(), "Use google analytics Radio button not selected");
    }

    public void assertOnCorrectDefaultCookiesPreference(String userSelection) {
        ScrollPage.scrollToViewElement(driver, "google-analytics-false");
        Assert.assertTrue(
                doNotUseGoogleAnalyticsBtn.isSelected(), "Do not use google analytics Radio button not selected");
    }

    public void assertOnCorrectDefaultCandidateCookiesPreference(String userSelection) {
        ScrollPage.scrollToViewElement(driver, "analytics_enabled-false");
        Assert.assertTrue(
                candidateDoNotUseGoogleAnalyticsBtn.isSelected(), "Do not use google analytics Radio button not selected");
    }

    public void assertOnErrorMessagesForFieldsFromTable(List<Map<String, String>> datatable) {
        for (Map<String, String> data : datatable) {
            WebElement fieldInputTextBox = driver.findElement(By.id(data.get("Field")));
            fieldInputTextBox.clear();
            fieldInputTextBox.sendKeys(data.get("invalidValue"));
            continueButton.click();
            WebElement errorTextElement = driver
                    .findElement(By.id(data.get("ErrorField")));
            Assert.assertEquals(data.get("ErrorMessage"), errorTextElement.getText());

        }

    }

    public void assertOnOrderOfWebElementsByListOrder(List<String> elementIds) {
        String idOfParentElement = elementIds.get(0);
        WebElement parentWebElement = driver.findElement(By.id(idOfParentElement));
        List<WebElement> childWebElements = parentWebElement.findElements(By.xpath(".//*"));
        WebElementOrderChecker webElementOrderChecker = new WebElementOrderCheckerImpl(childWebElements);
        List<String> childIds = getIdListOfExpectedChildElements(elementIds);
        Assert.assertTrue(webElementOrderChecker
                .areWebElementsOrderedLikeSpecifiedListByElementId(getIdListOfExpectedChildElements(childIds)), "Web Elements are expected to be in the order: " + childIds.toString());
    }

    public void assertOnPageErrorMessage(String expectedErrorMsg) {
        //Assert.assertEquals("Error message mismatch", expectedErrorMsg, error.getText().trim());
    }

    public void assertOnSubHeadingText(String subHeadingText) {
        WebElement subHeading = driver.findElement(By.id("sub_heading"));
        Assert.assertEquals(subHeadingText, subHeading.getText());
    }

    public void assertOnSubHeadingTextt(String subHeadingText) {
        WebElement subHeading = driver.findElement(By.id("error-summary-title"));
        Assert.assertEquals(subHeadingText, subHeading.getText());
    }

    public void assertPolicyPrivacyLinkIsDisplayed() {
        Assert.assertTrue(policyPrivacyLink.isDisplayed(), "Policy privacy is not displayed");
    }

    // ********* Radio buttons ********* //
    public void assertRadioButtonsLabel(int i, String labelName) {
        Assert.assertTrue(radioBtnsLabels.get(i).getText().contains(labelName), "Radio button label not matching");
    }

    public void assertRadioButtonsUnchecked() {
        for (int i = 0; i < radioBtns.size(); i++) {
            Assert.assertFalse(radioBtns.get(i).isSelected(), (i + 1) + " Radio button is selected by default ");
        }
    }

    public void assertRejectedCookiesMessageIsNotVisible() {
        Assert.assertEquals(0, driver.findElements(By.id("rejected-cookies-message")).size(), "Web element was present");
    }

    public void assertContinueButtonIsDisplayed() {
        Assert.assertTrue(continueButton.isDisplayed(), "Save and Continue Button not displayed");
    }


    public void assertSaveRadioButtonIsDisplayed() {
        Assert.assertTrue(saveBtn.isDisplayed(), "Save button not selected");

    }

    public String getBackBtn() {
        return new VerificationHelper(driver).getText(backButton);
    }

    public AccountPage getBackButton() throws IOException {
        backButton.click();
        return new AccountPage(driver);
    }

    public void assertUseGoogleAnalyticsRadioButtonIsDisplayed() {
        Assert.assertTrue(useGoogleAnalyticsRadioBtn.isDisplayed(), "Use google analytics Radio button not displayed");
    }


    public void assertWebElementNotDisplayedInCurrentPage(By locator) {
        try {
            driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("no such element: Unable to locate element:"));
        }
    }


    public void backButtonIsDisplayed() {
        Assert.assertTrue(lnk_back.isEnabled());

    }

    public void clickCandidatePrivacyPolicyLink() {
        candidatePrivacyPolicyLink.click();

    }

    public void clickCanTermsAndConditionsLink() {
        canTermsAndConditionsLink.click();

    }

    public void clickContinueButton() {
        continueButton.click();

    }

    public void clickCookiesLink() {
        try {
            ScrollPage.scrollToView(cookiesLink);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cookiesLink.click();
    }

    public void clickOnBrowserBackButton() {
        driver.navigate().back();

    }


    public void clickOnEmployerSignOutLink() {
        lnk_employer_signOut.click();

    }

    public void clickOnFindOutMoreAboutEssentialCookiesLink() {
        essentialCookiesLink.click();
    }

    public void assertUseGoogleAnalyticsRadioButtonIsSelected() {
        Assert.assertTrue(useGoogleAnalyticsRadioBtn.isSelected());

    }

    public void clickOnFindOutMoreGoogleAnalyticsCookiesLink() {
        findMoreAboutGoogleAnalyticsCookiesLink.click();

    }

    public void clickOnGoBackLink() {
        if (backButton.isDisplayed() || backButton.isEnabled()) {
            backButton.click();
        } else {
            Assert.fail("I am unable to click on the Go Back link");
        }
    }

    // Button Actions
    public void clickOnLoginButton() {
        loginButton.click();
        loginButton.isSelected();
    }

    public void clickOnGoBackBtn() {
        backButton.click();

    }

    public void clickOnTheSaveButton() {
        saveBtn.click();

    }

    public void clickOnUseGoogleAnalyticsCookiesButton() {
        useGoogleAnalyticsBtn.click();
        saveBtn.click();
        driver.findElement(By.id("employer_sign_in")).click();

    }

    public void clickOnFeedbackLink() {
        feedbackLink.click();

    }

    public void clickPrivacyPolicyLink() {
        privacyPolicyLink.click();

    }

    public void clickRadioBtnOption(int i) {
        radioBtns.get(i).click();

    }

    public void clickSaveButton() {
        saveBtn.click();

    }

    public void clickTermsAndConditionsLink() {
        termsandconditionsLink.click();

    }

    public List<String> getArrayListOfStringWithCommaSeparated(String fieldNames) {
        List<String> errorIds = new ArrayList<>();
        if (fieldNames.contains(",")) {
            errorIds = Arrays.asList(fieldNames.split(","));
        } else {
            errorIds.add(fieldNames);
        }
        return errorIds;
    }


    private List<String> getIdListOfExpectedChildElements(List<String> elementIds) {
        List<String> ids = new ArrayList<>();
        for (String elementId : elementIds) {
            ids.add(elementId);
        }
        ids.remove(0);
        return ids;
    }

    // navigate helper
    public void navigateTo(String url) {
        driver.navigate().to(url);

    }

//======================================================================================//

    public ShoppingCartPage clickViewCartLink() {
        viewCartLink.click();
        return new ShoppingCartPage(driver);
    }

    public CheckoutPage clickCheckoutLink() {
        checkoutLink.click();
        return new CheckoutPage(driver);
    }

    public AccountPage goToAccountPage() throws IOException {
        new JavaScriptHelper(driver).scrollToElement(continueBtn);
        continueBtn.click();
        return new AccountPage(driver);
    }

    public ProductCategoryPage clickOnMenu(WebElement element) throws IOException {
        log.info("clicking on : " + element.getText());
        element.click();
        return new ProductCategoryPage(driver);
    }

    public ProductCategoryPage clickOnItem(String data) throws IOException {
        log.info("clicking on :" + data);
        WebElement item = driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]"));
        item.click();
        return new ProductCategoryPage(driver);
    }

    public void mouseOver(String data) {
        log.info("doing mouse over on :" + data);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]")))
                .build()
                .perform();
    }

    public void mouseOverElement(WebDriver driver, WebElement element) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(element).build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                log.info(" MouserOver Action is performed on: " + element.getText());
            } else {
                log.info("MouseOver action is not performed on");
            }
        }
    }


    public void tapOnLoginLinkFromAccountDropDown(String menuItem, String menuDropdownListItem) {
        topMenuList.stream()
                .filter(s -> s.getText().contains(menuItem))
                .findFirst()
                .ifPresent(WebElement::click);
        topMenuMyAccountDropdownItemList.stream()
                .filter(e -> e.getText().contains(menuDropdownListItem))
                .findFirst()
                .ifPresent(WebElement::click);
        log.info("clicked on the button");
        log.info("current page url:: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
    }


    public AccountRegisterPage clickContinueButtonInAccountLogin() throws IOException {
        log.info("Click :: " + continueBtn.getText());
        continueBtn.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page url :: " + getCurrentPageTitle());
        return new AccountRegisterPage(driver);
    }

    public AccountPage clickOnLoginBtn() throws IOException {
        loginButton.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }

    public void clickOnItemLinkInSideWidgetList(String Item) {
        List<WebElement> listSideWidget =
                driver.findElements(
                        By.xpath(
                                "//a[@class='list-group-item'][normalize-space()='" + Item + "']"));
        for (int i = 0; i < listSideWidget.size(); i = i++) {
            String listName = listSideWidget.get(i).getText();
            if (listName.contains(Item)) {
                listSideWidget.get(i).click();
                break;
            }
        }
        log.info("current page url :: " + getCurrentPageUrl());
    }

    public AccountLoginPage clickOnLoginFromMyAccountDropdown(String login) throws IOException {
        topMenuMyAccountDropdownItemList.stream()
                .filter(s -> s.getText().contains(login))
                .findFirst()
                .ifPresent(WebElement::click);
        System.out.println("Successfully clicked on an element:: " + login);
        return new AccountLoginPage(driver);
    }

    public void clickOnAnItemFromSubcategoriesList(String menuListItem) {
        subcategories.stream()
                .filter(s -> s.getText().contains(menuListItem))
                .findFirst()
                .ifPresent(WebElement::click);
        System.out.println("Successfully clicked on an element:: " + menuListItem);
    }

    public AccountLoginPage tapOnMatchingTxtFromSubCategoriesAndDropDownList(
            String menuItem, String menuDropdownListItem) throws IOException {
        subcategories.stream()
                .filter(s -> s.getText().contains(menuItem))
                .findFirst()
                .ifPresent(WebElement::click);

        subCategoriesDropdownList.stream()
                .filter(s -> s.getText().contains(menuDropdownListItem))
                .findFirst()
                .ifPresent(WebElement::click);
        return new AccountLoginPage(driver);
    }

    public void clickOnAnItemFromTopMenuList(String menuItem) {
        topMenuList.stream()
                .filter(s -> s.getText().contains(menuItem))
                .findFirst()
                .ifPresent(WebElement::click);
        System.out.println("Successfully clicked on an element:: " + menuItem);
    }

    public void clickOnAnItemFromTopMenuDropdownList(String menuDropdownListItem) {
        topMenuDropdownItemList.stream()
                .filter(s -> s.getText().contains(menuDropdownListItem))
                .findFirst()
                .ifPresent(WebElement::click);
        System.out.println("Successfully clicked on an element:: " + menuDropdownListItem);
    }

    public AccountLoginPage clickOnLoginFromMyAccountDropdownList(String login) throws IOException {
        topMenuMyAccountDropdownItemList.stream()
                .filter(s -> s.getText().contains(login))
                .findFirst()
                .ifPresent(WebElement::click);
        System.out.println("Successfully clicked on an element:: " + login);
        return new AccountLoginPage(driver);
    }

    public void clickOnAnItemFromMenuList(String menuListItem) {
        topMenuList.stream()
                .filter(s -> s.getText().contains(menuListItem))
                .findFirst()
                .ifPresent(WebElement::click);
        System.out.println("Successfully clicked on an element:: " + menuListItem);
    }

    public AccountLoginPage tapOnMatchingTxtFromSubCategoriesDropdownList(
            String menuItem, String menuDropdownListItem) throws IOException {
        subcategories.stream()
                .filter(s -> s.getText().contains(menuItem))
                .findFirst()
                .ifPresent(WebElement::click);
        subCategoriesDropdownList.stream()
                .filter(s -> s.getText().contains(menuDropdownListItem))
                .findFirst()
                .ifPresent(WebElement::click);
        return new AccountLoginPage(driver);
    }


    public AccountLogoutPage clickOnLogoutLinkFromMyAccountTopMenuLink() throws IOException {
        lnkMyaccount.click();
        lnkLogout.click();
        return new AccountLogoutPage(driver);
    }

    public AccountEditPage clickOnYourEditAccountInformationLink() throws IOException {
        log.info("clicked :: " + editYourAccountInformation.getText());
        editYourAccountInformation.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountEditPage(driver);
    }

    public void clickSideWidgetLinkByName(String linkName) {
        sideWidgetLinks.stream()
                .parallel()
                .filter(s -> s.getText().contains(linkName))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public AccountLoginPage tapOnLoginLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Login");
        log.info("clicked Login link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountLoginPage(driver);
    }

    public AccountEditPage tapOnEditAccount() throws IOException {
        clickSideWidgetLinkByName("Edit Account");
        log.info("clicked Edit Account link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountEditPage(driver);
    }

    public AccountLogoutPage tapOnLogoutLink() throws IOException {
        clickSideWidgetLinkByName("Logout");
        log.info("clicked Logout link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountLogoutPage(driver);
    }

    public AccountRegisterPage tapOnRegisterLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Register");
        log.info("clicked Register link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountRegisterPage(driver);
    }

    public ForgottenPasswordPage tapOnForgottenPasswordLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Forgotten Password");
        log.info("clicked Forgotten Password link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new ForgottenPasswordPage(driver);
    }

    public AccountPage tapOnMyAccountLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("My Account");
        log.info("clicked MyAccount link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }

    public AddressPage tapOnAddressBookLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Address Book");
        log.info("clicked Address Book link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AddressPage(driver);
    }

    public WishListPage tapOnWishListLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Wish List");
        log.info("clicked Wish List link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new WishListPage(driver);
    }

    public OrderHistoryPage tapOnOrderHistoryLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Order History");
        log.info("clicked Order History link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new OrderHistoryPage(driver);
    }

    public DownloadsPage tapOnDownloadLinkFromAsideWidget() {
        clickSideWidgetLinkByName("Download");
        log.info("clicked Order Download link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new DownloadsPage(driver);
    }

    public RecurringPaymentsPage tapOnRecurringPaymentsLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Recurring payments");
        log.info("clicked Recurring payments link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new RecurringPaymentsPage(driver);
    }

    public RewardPointsPage tapOnRewardPointsLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Reward Points");
        log.info("clicked Reward Points link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new RewardPointsPage(driver);
    }

    public NewsletterPage tapOnNewsletterLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Newsletter");
        log.info("clicked Newsletter link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new NewsletterPage(driver);
    }

    public ReturnsPage tapOnReturnsLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Returns");
        log.info("clicked Returns link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new ReturnsPage(driver);
    }

    public TransactionsPage tapOnTransactionsLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Transactions");
        log.info("clicked Transactions link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new TransactionsPage(driver);
    }

    public AccountEditPage tapOnEditAccountLink() throws Exception {
        log.info("clicked :: " + editAccountsideWidgetAccountLink.getText());
        editAccountsideWidgetAccountLink.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountEditPage(driver);
    }

    public AccountLogoutPage tapOnLogoutLinkFromAsideWidget() throws IOException {
        clickSideWidgetLinkByName("Logout");
        log.info("clicked Logout link");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountLogoutPage(driver);
    }

/*    public AccountSuccessPage clickOnAccountRegisterContinueBtn() throws IOException {
        log.info("clicked :: " + continueButton.getText());
        continueButton.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
        return new AccountSuccessPage(driver);
    }*/

    /*public AccountPage clickOnAccountSuccessContinueBtn() throws IOException {
        log.info("clicked :: " + continueBtn.getText());
        continueBtn.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }*/

    public AccountLogoutPage tapLogoutLinkFromSideWidgetLinks() throws IOException {
        log.info("clicked :: " + logoutAsideWidget.getText());
        logoutAsideWidget.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        return new AccountLogoutPage(driver);
    }

/*    public AccountPage clickOnEditAccountContinueButton() throws IOException {
        log.info("clicked :: " + continueButton.getText());
        continueButton.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page heading :: " + getCurrentPageTitle());
        return new AccountPage(driver);
    }*/

    public AccountRegisterPage tapOnItemFromAccountDropDownList(
            String menuItem, String menuDropdownListItem) throws IOException {
        topMenuList.stream()
                .filter(s -> s.getText().contains(menuItem))
                .findFirst()
                .ifPresent(WebElement::click);
        topMenuMyAccountDropdownItemList.stream()
                .filter(s -> s.getText().contains(menuDropdownListItem))
                .findFirst()
                .ifPresent(WebElement::click);
        accountRegisterPage = new AccountRegisterPage(driver);
        return accountRegisterPage;
    }

    public AccountLoginPage tapOnAnItemFromTopMenuAndclickItemFromDropdownList(
            String menuItem, String menuDropdownListItem) throws IOException {
        driver.findElement(By.xpath("//a[contains(text(),'" + menuItem + "')]")).click();
        topMenuMyAccountDropdownItemList.stream()
                .filter(s -> s.getText().equalsIgnoreCase(menuDropdownListItem))
                .findFirst()
                .ifPresent(WebElement::click);
        return new AccountLoginPage(driver);
    }

    public List<String> getAsideWidgetList() {
        List<String> asideWidgetList =
                sideWidgetLinks.stream()
                        .filter(WebElement::isDisplayed)
                        .map(WebElement::getText)
                        .toList();
        System.out.println("Aside Widget List: " + asideWidgetList);
        return asideWidgetList;
    }

    public int getCountAsideWidgetList() {
        List<String> asideWidgetList =
                sideWidgetLinks.stream()
                        .filter(WebElement::isDisplayed)
                        .map(WebElement::getText)
                        .toList();
        return asideWidgetList.size();
    }

    public AccountRegisterPage clickMyAccountLinkAndRegisterLink() throws IOException {
        lnkMyaccount.click();
        lnkRegister.click();
        log.info("current page :: " + getCurrentPageUrl());
        return new AccountRegisterPage(driver);
    }

    public AccountRegisterPage clickMyAccountAndRegister() throws IOException {
        lnkMyaccount.click();
        lnkRegister.click();
        log.info("current page :: " + getCurrentPageUrl());
        return new AccountRegisterPage(driver);
    }

    public boolean assertAsideWidgetAndLabelPosition(
            String labels_Count, String login, String newsletter) {
        int size = sideWidgetLinks.size();
        System.out.println("Size of labels: " + size);
        log.info("Size of labels: " + size);
        for (WebElement sideWidgetLink : sideWidgetLinks) {
            String labelsText = sideWidgetLink.getText();
            log.info(labelsText);
            System.out.println(labelsText);
        }
        return true;
    }

    public AccountLoginPage clickMyAccountAndLoginLink() throws IOException {
        myAccount.click();
        lnkLogin.click();
        log.info("current page :: " + getCurrentPageUrl());
        return new AccountLoginPage(driver);
    }

    //=======================================================================//

    public AccountLogoutPage clickSideWidgetLinks(String link) throws IOException {
        sideWidgetLinks.stream().parallel().filter(s -> s.getText().contains(link)).findFirst()
                .ifPresent(WebElement::click);
        return new AccountLogoutPage(driver);
    }

    public AccountEditPage clickEditAccountSideWidgetLinks(String link) throws IOException {
        sideWidgetLinks.stream().parallel().filter(s -> s.getText().contains(link)).findFirst()
                .ifPresent(WebElement::click);
        return new AccountEditPage(driver);
    }

    /*public IndexPage clickAccountLogoutContinueBtn() throws IOException {
        waitElementToAppearFor(0);
        log.info("clicked :: " + continueBtn.getText());
        continueBtn.click();
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page title:: " + getCurrentPageTitle());
        log.info("******************Test Ended******************");
        return new IndexPage(driver);
    }*/

    public AccountLogoutPage clickOnLogoutSideWidgetAccountLink() throws IOException, InterruptedException {
        waitElementToAppearFor(0);
        new JavaScriptHelper(driver).scrollToElement(logoutSideWidgetAccountLink);
        waitElementToAppearFor(1);
        logoutSideWidgetAccountLink.click();
        return new AccountLogoutPage(driver);
    }

    public AccountRegisterPage clickMyAccountAndRegisterLink() throws IOException {
        lnkMyaccount.click();
        lnkRegister.click();
        log.info("current page :: " + getCurrentPageUrl());
        log.info("current page :: " + getCurrentPageTitle());
        return new AccountRegisterPage(driver);
    }

    public SearchPage searchForAProduct(String productText) {
        searchBox.sendKeys(productText);
        searchButton.click();
        return new SearchPage(driver);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(driver);
    }


}
