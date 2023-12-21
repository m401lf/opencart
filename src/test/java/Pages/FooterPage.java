package Pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FooterPage extends BasePage {
    private final Logger log = LogManager.getLogger(FooterPage.class);
    WebDriver driver;
    @FindBy(css = ".footer-info-heading")
    List<WebElement> footerTxtHearing;
    @FindBy(xpath = "//h3[contains(text(),'Navigate')]")
    WebElement navigate;
    @FindBy(xpath = "//h3[contains(text(),'Categories')]")
    WebElement categories;
    @FindBy(xpath = "//h3[contains(text(),'Popular Brands')]")
    WebElement popularBrands;
    @FindBy(xpath = "//h3[contains(text(),'Info')]")
    WebElement info;
    @FindBy(xpath = "//h3[contains(text(),'Subscribe to our newsletter')]")
    WebElement subscribeNewsletter;
    @FindBy(css = "#nl_email")
    WebElement subscribeEmailBox;
    @FindBy(xpath = "/html/body/footer/div[1]/section/article[5]/form/fieldset/div/div/input[2]")
    WebElement subscribeBtn;

    public FooterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFooterHearingTextName(String textName) {
        List<WebElement> textNames = footerTxtHearing;
        for (WebElement c : textNames) {
            String text = c.getText().trim();
            if (text.equals(textName)) {
                log.info("selecting date as: " + textName);
                c.click();
                break;
            }
        }
    }

}
