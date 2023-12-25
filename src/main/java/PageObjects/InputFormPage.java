package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InputFormPage {
    WebDriver driver ;
    public InputFormPage(WebDriver driver) {
        this.driver =  driver ;
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
