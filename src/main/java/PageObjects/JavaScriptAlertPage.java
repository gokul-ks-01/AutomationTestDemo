package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertPage {
    WebDriver driver;
    @FindBy(xpath = "//button[text()='Click me!' and @onclick='jsAlert()']")
    WebElement alertBox;

    @FindBy(xpath = "//button[text()='Click me!' and @onclick='jsConfirm()']")
    WebElement confirmBox;
    @FindBy(xpath = "//button[text()='Click for Prompt Box']")
    WebElement promptBox;


    public JavaScriptAlertPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    public String getAlertText(){

        Alert alert = driver.switchTo().alert();
        String alertText =  alert.getText();
        alert.accept();
        return alertText ;
    }
    public void  acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void  dismissAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void  typeTextOnAlert(String textToType){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(textToType);
    }

    public void clickOnAlertBox(){
        alertBox.click();
    }
    public void clickOnConfirmBox(){
        confirmBox.click();
    }
    public void clickOnPromptBox(){
        promptBox.click();
    }


}

