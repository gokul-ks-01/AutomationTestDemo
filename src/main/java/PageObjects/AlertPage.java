package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AlertPage {
    WebDriver driver ;

    @FindBy(xpath = "xpathExpression")
    WebElement javascriptAlert ;

    @FindBy(className = "x")
    List<WebElement> elements;


    public AlertPage(WebDriver driver){
        this.driver = driver ;
    }

    public  void click(){
        javascriptAlert.click();
    }
}

