package Tests;

import Base.DriverInitializer;
import PageObjects.AlertModalsPage;
import PageObjects.JavaScriptAlertPage;
import PageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAlertsTests extends DriverInitializer {

    WebDriver driver ;
    MainPage mainPage;
    AlertModalsPage alertModalsPage;
    JavaScriptAlertPage javaScriptAlertPage;
    static String EXPECTED_JAVASCRIPT_ALERT_TEXT ="I am a Javascript alert box";
    static String TEXT_TO_ENTER = " Hi there" ;


    @Test(priority = 1,retryAnalyzer = util.RetryAnalyzer.class)
    public void verifyJavascriptAlertText(){
        driver =getDriver();
        mainPage = new MainPage(driver);
        mainPage.selectAlerts();
        alertModalsPage = new AlertModalsPage(driver);
        alertModalsPage.clickOnJavascriptAlerts();
        javaScriptAlertPage = new JavaScriptAlertPage(driver);
        javaScriptAlertPage.clickOnAlertBox();
        String actual = javaScriptAlertPage.getAlertText().trim();
        Assert.assertEquals(actual,EXPECTED_JAVASCRIPT_ALERT_TEXT);
    }
    @Test(priority = 2)
    public void verifyJavascriptAlertConfirmButton() {
        javaScriptAlertPage.clickOnConfirmBox();
        javaScriptAlertPage.dismissAlert();
    }
    @Test(priority = 3)
    public  void verifyJavascriptPromptBox(){
        javaScriptAlertPage.clickOnPromptBox();
        javaScriptAlertPage.typeTextOnAlert(TEXT_TO_ENTER);
        javaScriptAlertPage.acceptAlert();
    }
}
