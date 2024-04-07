package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import util.ScreenshotUtil;

public class DriverInitializer {

    public static final String PAGE_URL = "https://selenium.qabible.in/index.php" ;
    WebDriver driver ;
    @Parameters({"browser"})
    @BeforeTest
    public void setup (@Optional("chrome") String browser){
        driver = createWebDriverSession(browser);
        driver.get(PAGE_URL);
    }
    public WebDriver getDriver(){
        return  driver ;
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
    public WebDriver createWebDriverSession(String browserName) {
        WebDriver driver;
        switch (browserName) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
            default -> {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
            }
        }
        return driver;
    }


}
