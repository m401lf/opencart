package testCases.Selenium4_New_Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Action_Class_Update_In_Selenium4 {
    public static void main(String[] args) {

        /*
         * Action Class Update In Selenium 4
         */


        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        driver.get("https://www.actitime.com");


    }

}
