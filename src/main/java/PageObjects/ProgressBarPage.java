package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPage {
    WebDriver driver;
    public ProgressBarPage(WebDriver driver){
        this.driver =  driver;
    }
    @FindBy(xpath = "//a[text()='JQuery UI Progress']")
    WebElement jqueryProgressSideMenu;
    @FindBy(xpath = "//a[text()='Range Sliders']")
    WebElement rangeSliderSideMenu;

    public void clickJqueryProgressSideMenu(){
        jqueryProgressSideMenu.click();
    }
    public void clickRangeSliderSideMenu(){
        rangeSliderSideMenu.click();
    }
}
