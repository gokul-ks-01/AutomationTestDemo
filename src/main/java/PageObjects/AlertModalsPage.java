package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertModalsPage {
    WebDriver driver ;

    @FindBy(linkText = "Javascript Alert")
    WebElement javascriptAlert ;

    @FindBy(className = "x")
    List<WebElement> elements;


    public AlertModalsPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    public  void clickOnJavascriptAlerts(){
        javascriptAlert.click();
    }
}

