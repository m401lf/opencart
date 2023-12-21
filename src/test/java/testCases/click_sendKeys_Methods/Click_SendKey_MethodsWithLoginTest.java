package testCases.click_sendKeys_Methods;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(TestComponents.Listeners.class)

public class Click_SendKey_MethodsWithLoginTest {
    public WebDriver driver;
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;
    AccountEditPage accountEditPage;
    Logger log = LogManager.getLogger(AccountLoginPage.class);


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        ops.addArguments("--ignore-certificate-errors");
        //ops.addArguments("--headless");
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(description = "Login test with click() method")
    public void loginTestUsingClick() {

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        email.sendKeys("admin@admin.com");
        password.sendKeys("Password");
        loginButton.submit();

    }

    @Test(description = "Login test with Actions class method")
    public void loginTestUsingActionsClass() {

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        Actions action = new Actions(driver);
        action.moveToElement(email).sendKeys(emailAddress).build().perform();
        action.moveToElement(email).sendKeys(pass).build().perform();
        action.moveToElement(email).click().build().perform();

    }

    @Test(description = "Login test using JavascriptExecutor method")
    public void loginTestUsingJavascriptExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        email.sendKeys("admin@admin.com");
        password.sendKeys("Password");
        js.executeScript("arguments[0].click();", loginButton);

    }

    @Test(description = "Login test using mouse action: sendKeys(Keys.RETURN)")
    public void loginTestUsingMoseAction() {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        Actions action = new Actions(driver);
        action.moveToElement(email).sendKeys(emailAddress).build().perform();
        action.moveToElement(password).sendKeys(pass).build().perform();
        loginButton.sendKeys(Keys.RETURN);

    }

    @Test(description = "Login test using WebDriverWait")
    public void loginTestUsingWebDriverWait() {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        String emailAddress = "admin@admin.com";
        String pass = "Password";
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(emailAddress);
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

    }

}