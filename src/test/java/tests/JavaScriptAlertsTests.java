package tests;

import base.DriverInitializer;
import pageObjects.AlertModalsPage;
import pageObjects.JavaScriptAlertPage;
import pageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsTests extends DriverInitializer {

    WebDriver driver ;
    MainPage mainPage;
    AlertModalsPage alertModalsPage;
    JavaScriptAlertPage javaScriptAlertPage;
    static String EXPECTED_JAVASCRIPT_ALERT_TEXT ="I am a Javascript alert box!";
    static String TEXT_TO_ENTER = " Hi there" ;


    @Test(priority = 1,retryAnalyzer = util.RetryAnalyzer.class,groups = {"smoke"})
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
        System.out.println("rest of the commands");


    }
    @Test(priority = 2,groups = {"regression","smoke"})
    public void verifyJavascriptAlertConfirmButton() {
        javaScriptAlertPage.clickOnConfirmBox();
        javaScriptAlertPage.dismissAlert();
    }
    @Test(priority = 3,groups = {"smoke"})
    public  void verifyJavascriptPromptBox(){
        javaScriptAlertPage.clickOnPromptBox();
        javaScriptAlertPage.typeTextOnAlert(TEXT_TO_ENTER);
        javaScriptAlertPage.acceptAlert();
    }
}
