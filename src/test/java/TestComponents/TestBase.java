package TestComponents;

import Pages.IndexPage;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.logger.LoggerHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class TestBase {

    public static File reportDirectery;
    public WebDriver driver;
    public IndexPage indexPage;
    public Properties prop;
    public Properties dataProp;
    Status status;
    Logger log = LoggerHelper.getLogger(TestBase.class);


    public WebDriver initializeDriver() {
        // properties class
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir") + "//src//test//java//resources//GlobalData.properties");

        dataProp = new Properties();
        File dataPropFile =
                new File(
                        System.getProperty("user.dir") + "//src//test//java//resources//testdata.properties");

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


        String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
                : prop.getProperty("browser");
        //prop.getProperty("browser");

        if (browserName.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-dev-shm-usage");
            ops.addArguments("--no-sandbox");
            ops.addArguments("--disable-extensions");
            ops.addArguments("--start-maximized");
            ops.addArguments("--disable-gpu");
            ops.addArguments("--whitelisted-ips");
            ops.addArguments("--ignore-certificate-errors");
            //ops.addArguments("--headless");
            ops.addArguments("--test-type");
            ops.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(ops);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            // Firefox
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Edge
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;

    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read json to string
        String jsonContent = FileUtils.readFileToString(new File(filePath),
                StandardCharsets.UTF_8);

        //String to HashMap- Jackson Databind

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;

        //{map, map}

    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(
                System.getProperty("user.dir") + "//extentReports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//extentReports//" + testCaseName + ".png";


    }

    //@BeforeMethod(alwaysRun = true)
    @BeforeMethod()
    public IndexPage launchApplication(String url) throws IOException {
        driver = initializeDriver();
        indexPage = new IndexPage(driver);
        getApplicationUrl(url);
        return indexPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public void getApplicationUrl(String url) {
        driver.get(url);
        log.info("navigating to ..." + url);
    }


    public String captureScreen(String fileName) {
        if (driver == null) {
            log.info("driver is null..");
            return null;
        }
        if (fileName == "") {
            fileName = "blank";
        }
        File destFile = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File screFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            destFile = new File(
                    reportDirectery + "/" + fileName + "_" + formater.format(calendar.getTime()) + ".png");
            Files.copy(screFile.toPath(), destFile.toPath());
            Reporter.log(
                    "<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
                            + "'height='100' width='100'/></a>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destFile.toString();
    }


}
