package helper.browserConfiguration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeBrowser {

    public static void getChromeOptions() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.get("http://localhost/opencartshop/");
        System.out.println("Url :: " + driver.getCurrentUrl());
        System.out.println("Title :: " + driver.getTitle());
        driver.quit();
    }

    public static void main(String[] args) {
        getChromeOptions();
    }

}
