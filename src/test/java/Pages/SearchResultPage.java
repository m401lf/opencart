package Pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class SearchResultPage extends BasePage {

    private WebDriver driver;
    private Logger log = LogManager.getLogger(SearchResultPage.class);

    public SearchResultPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
