package Tests;

import Base.DriverInitializer;
import PageObjects.JqueryProgressPage;
import PageObjects.MainPage;
import PageObjects.ProgressBarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
@Listeners(util.ReportUtil.class)
public class VerifyCloseButtonProgressBar extends DriverInitializer {
    WebDriver driver;
    MainPage mainPage;
    ProgressBarPage progressBarPage;
    JqueryProgressPage jqueryProgressPage;
    @Parameters({"browser"})
    @BeforeTest
    public void setup (@Optional("chrome") String browser){
        driver =  createWebDriverSession(browser);
        driver.get(PAGE_URL);
    }

    @Test
    public void verifyCloseButton() throws IOException {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.selectProgressBars();
        progressBarPage = PageFactory.initElements(driver, ProgressBarPage.class);
        progressBarPage.clickJqueryProgressSideMenu();
        jqueryProgressPage = PageFactory.initElements(driver, JqueryProgressPage.class);
        jqueryProgressPage.startDownload();
        Assert.assertTrue(jqueryProgressPage.isComplete());

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}
