package tests;

import base.DriverInitializer;
import pageObjects.InputFormPage;
import pageObjects.MainPage;
import pageObjects.SimpleFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.ScreenshotUtil;
import java.io.IOException;

@Listeners(util.ReportUtil.class)
public class SimpleFormTest extends DriverInitializer{

    MainPage mainPage;
    SimpleFormPage simpleFormPage ;
    WebDriver driver;
    InputFormPage inputFormPage;
    private static final String MESSAGE = "You did it fine" ;

    @Test(testName = "verifySimpleForm",retryAnalyzer = util.RetryAnalyzer.class)
    public void verifySimpleForm() throws IOException {
        driver = getDriver();
        mainPage = new MainPage(driver);
        mainPage.selectForm();
        /*ReportUtil reportUtil = ReportUtil.getInstance();
        reportUtil.logToExtentReport(Status.INFO,"this is to test extra info");*/
       /* ReportUtil.writeTestInfo("selected input form");*/
        inputFormPage = new InputFormPage(driver);
        inputFormPage.clickSimpleFormDemoSideMenu();
        simpleFormPage = new SimpleFormPage(driver);
        simpleFormPage.enterMessage(MESSAGE);
        simpleFormPage.clickButtonShowMessage();
        Assert.assertEquals(simpleFormPage.getMessageEntered(),"Your Message : "+MESSAGE);
        ScreenshotUtil.captureScreenshot(driver,"simpleFormTest1");

    }
}
