package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    public Navigation navigation;
    public Properties prop;
    public Properties dataProp;

    public Base() {

        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir") + "//src//test//java//config//config.properties");

        dataProp = new Properties();
        File dataPropFile = new File(System.getProperty("user.dir") + "//src//test//java//resources//testdata.properties");

        try {
            FileInputStream dataFis = new FileInputStream(dataPropFile);
            dataProp.load(dataFis);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("safari")) {

            driver = new SafariDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(prop.getProperty("url"));

        return driver;

    }


}
