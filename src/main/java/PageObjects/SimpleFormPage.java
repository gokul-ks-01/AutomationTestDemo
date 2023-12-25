package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleFormPage {
    WebDriver driver;
    public SimpleFormPage(WebDriver driver){
        this.driver = driver ;
    }
    @FindBy(id = "single-input-field")
    WebElement messageInput;
    @FindBy(css = "#button-one")
    WebElement showMessageButton;
    @FindBy(id = "message-one")
    WebElement messageEntered;

    public void enterMessage(String message){
        messageInput.clear();
        messageInput.sendKeys(message);
    }
    public void clickButtonShowMessage(){
        showMessageButton.click();
    }
    public  String getMessageEntered(){
       return messageEntered.getText();
    }
}
