package Tests;

import Base.DriverInitializer;
import PageObjects.InputFormPage;
import PageObjects.MainPage;
import PageObjects.SimpleFormPage;
import util.ReportUtil;
import util.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(util.ReportUtil.class)
public class SimpleFormTest extends DriverInitializer{

    WebDriver driver;
    MainPage mainPage;
    SimpleFormPage simpleFormPage ;

    InputFormPage inputFormPage;
    private static final String MESSAGE = "You did it fine" ;

    @Parameters({"browser"})
    @BeforeTest
    public void setup (@Optional("chrome") String browser){
        driver =  createWebDriverSession(browser);
        driver.get(PAGE_URL);
    }

    @Test(testName = "verifySimpleForm")
    public void verifySimpleForm() throws IOException {
        mainPage = PageFactory.initElements(driver,MainPage.class);
        mainPage.selectForm();
        ReportUtil.writeTestInfo("selected input form");
        inputFormPage = PageFactory.initElements(driver,InputFormPage.class);
        inputFormPage.clickSimpleFormDemoSideMenu();
        simpleFormPage = PageFactory.initElements(driver,SimpleFormPage.class);
        simpleFormPage.enterMessage(MESSAGE);
        simpleFormPage.clickButtonShowMessage();
        Assert.assertEquals(simpleFormPage.getMessageEntered(),"Your Message : "+MESSAGE);
        ScreenshotUtil.captureScreenshot(driver,"simpleFormTest1");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}
