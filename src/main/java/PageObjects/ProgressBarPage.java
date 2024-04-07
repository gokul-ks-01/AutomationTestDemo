package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage {
    WebDriver driver;
    public ProgressBarPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
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
