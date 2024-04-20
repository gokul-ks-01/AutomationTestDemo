package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InputFormPage {
    WebDriver driver ;
    public InputFormPage(WebDriver driver) {
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Simple Form Demo')]")
    WebElement simpleFormDemoSideMenu;
    @FindBy(xpath = "//a[text()='Select Input']")
    WebElement selectInputSideMenu;
    public void clickSimpleFormDemoSideMenu(){
        simpleFormDemoSideMenu.click();
    }
    public void clickSelectSideMenu(){
        selectInputSideMenu.click();
    }
}
