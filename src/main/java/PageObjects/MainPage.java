package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    //this is page object for the top bar menu or the home page.
    WebDriver driver ;
    public MainPage(WebDriver driver){
        this.driver = driver ;
    }
    @FindBy(xpath = "//a[text()='Home']")
    WebElement homeMenu;
    @FindBy(xpath = "//a[contains(text(),'Input Form')]")
    WebElement formMenu;
    @FindBy(xpath = "//a[contains(text(),'Date Pickers')]")
    WebElement datePickerMenu;
    @FindBy(xpath = "//a[contains(text(),'Table')]")
    WebElement tableMenu;
    @FindBy(id = "alert-modal")
    WebElement alertsAndModals;
    @FindBy(xpath = "//a[contains(text(),'List Box')]")
    WebElement listBox;
    @FindBy(id = "others")
    WebElement others;

    @FindBy(id ="progress-bars" )
    WebElement progressBars;


    public void selectHome(){
        homeMenu.click();
    }
    public void selectForm(){
        formMenu.click();
    }
    public void selectDatePicker(){
        datePickerMenu.click();
    }
    public void selectTable(){
        tableMenu.click();
    }
    public void selectAlerts(){
        alertsAndModals.click();
    }
    public void selectListBox(){
        listBox.click();
    }
    public void selectOthers(){
        others.click();
    }
    public void selectProgressBars(){
        progressBars.click();
    }
}
