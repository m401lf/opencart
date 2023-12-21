package Pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage extends BasePage {

    private final Logger log = LogManager.getLogger(CheckoutPage.class);
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
