package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JqueryProgressPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    public JqueryProgressPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="downloadButton")
    WebElement startDownloadButton;

    @FindBy(xpath = "//div[@id='dialog']/child::div[@class='progress-label']")
    WebElement progress;

    @FindBy(xpath = "//button[text()='Close' and @class='ui-button ui-corner-all ui-widget']")
    WebElement closeButton;

    public void startDownload(){
        startDownloadButton.click();
    }
    public boolean  isComplete() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(progress,"Complete!"));
       return webDriverWait.until(ExpectedConditions.visibilityOf(closeButton)).isDisplayed();
    }

}
