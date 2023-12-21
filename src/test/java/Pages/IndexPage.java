package Pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalVars;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class IndexPage extends BasePage {

    public final String url = "http://localhost/opencartshop/index.php";
    private final Logger log = LogManager.getLogger(IndexPage.class);
    public WebDriver driver;
    AccountLoginPage accountLoginPage;
    @FindBy(css = "img[title='Your Store']")
    WebElement logoImage;
    @FindBy(xpath = "/html/body/main/div[2]/div/div/div[2]/div/div")
    List<WebElement> allProductsList;
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccount;
    @FindBy(linkText = "Login")
    private WebElement loginOption;
    @FindBy(linkText = "Register")
    private WebElement registerOption;
    @FindBy(css = "input[placeholder='Search']")
    private WebElement searchBox;
    @FindBy(xpath = "i.fa-solid.fa-magnifying-glass")
    private WebElement searchButton;

    public IndexPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://tutorialsninja.com/demo/");
        log.info("******************Test Started******************");
        log.info("current page url :: " + getCurrentPageUrl());
        log.info("current page url :: " + getCurrentPageTitle());
    }

    public List<WebElement> getTopMenuList() {
        return topMenuList;

    }

    public WebElement getTopMenuItemByName(String itemNameTopMenu) {
        return getTopMenuList()
                .stream()
                .filter(product -> product.getText().equals(itemNameTopMenu))
                .findFirst()
                .orElse(null);
    }

    public void clickonTopmenuItem(String itemNameTopMenu) {
        WebElement TopMenuItem = getTopMenuItemByName(itemNameTopMenu);
        TopMenuItem.click();
    }

    public int countAllDisplayedProductsInIndexPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until((d) -> this.allProductsList.size() > 15);
        System.out.println("Products count Displayed: " + this.allProductsList.size());
        return this.allProductsList.size();
    }

    public void enterProductIntoSearchBoxField(String productText) {
        searchBox.sendKeys(productText);

    }

    public void clickOnMyAccount() {
        myAccount.click();

    }

    public AccountLoginPage selectLoginOption() throws IOException {
        loginOption.click();
        return new AccountLoginPage(driver);
    }

    public AccountLoginPage naviageToLoginPage() throws IOException {
        myAccount.click();
        loginOption.click();
        return new AccountLoginPage(driver);

    }

    public AccountRegisterPage selectRegisterOption() throws IOException {
        registerOption.click();
        return new AccountRegisterPage(driver);

    }

    public AccountRegisterPage navigateToRegisterPage() throws IOException {
        myAccount.click();
        registerOption.click();
        return new AccountRegisterPage(driver);
    }


    public void gotoUrl() {
        driver.get(GlobalVars.URL_HOMEPAGE);
        log.info("current page url :: " + getCurrentPageUrl());
    }


}
