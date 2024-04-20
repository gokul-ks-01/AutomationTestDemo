package tests;

import base.DriverInitializer;
import pageObjects.JqueryProgressPage;
import pageObjects.MainPage;
import pageObjects.ProgressBarPage;
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

    @Test
    public void verifyCloseButton() throws IOException {
        driver = getDriver();
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
