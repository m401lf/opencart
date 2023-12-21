package Pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    WebDriver driver;
    Logger log = LogManager.getLogger(SearchPage.class);
    @FindBy(linkText = "HP LP3065")
    private WebElement validHPProduct;
    @FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
    private WebElement noProductMessage;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String retrieveNoProductMessageText() {
        return noProductMessage.getText();

    }

    public boolean displayStatusOfHPValidProduct() {
        return validHPProduct.isDisplayed();

    }


}
