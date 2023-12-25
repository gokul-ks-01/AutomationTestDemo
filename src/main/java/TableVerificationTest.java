import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TableVerificationTest {
    @BeforeSuite
    public void suiteStart(){
        System.out.println("test suite start");
    }
    @AfterSuite
    public void suiteEnd(){
        System.out.println("test suite end");
    }
    @BeforeTest
    public void testStart(){
        System.out.println("test start");
    }
    @AfterTest
    public void testEnd(){
        System.out.println("testEnd");
    }
    @BeforeClass
    public void classStart(){
        System.out.println("class start");
    }
    @AfterClass
    public void classEnd(){
        System.out.println("class end");
    }
    @BeforeMethod
    public void methodStart(){
        System.out.println("method start");
    }
    @AfterMethod
    public void methodEnd(){
        System.out.println("method end");
    }

    @Test
    public void verifyStaticTable() throws Exception {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Programming\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        driver.findElement(By.linkText("Select Input")).click();
        //  Select selectColour = new Select(driver.findElement(By.id("single-input-field")));
        Select multiColourSelect = new Select(driver.findElement(By.id("multi-select-field")));
        multiColourSelect.selectByIndex(1);
        multiColourSelect.selectByIndex(2);
        driver.findElement(By.id("button-all")).click();
        WebElement alertsTab = driver.findElement(By.xpath("//a[contains(text(),'Table')]"));
        alertsTab.click();

        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr/child::td[1]"));
        int countOfRows = tableRows.size();
        int currentRow = 1;
        String expectedName = "Rhona Davidson" ;
        for (WebElement eachRow:tableRows) {
            if(eachRow.getText().equals(expectedName)){

                WebElement actualSalaryElement = driver.findElement(By.xpath("//table[@id='dtBasicExample']/tbody/descendant::tr["+currentRow+"]/child::td[6]"));
                System.out.println("Actual Salary found is "+ actualSalaryElement.getText());
                break;
            }
            currentRow++;
        }
    driver.quit();
    }
    @Test
    public void verifyDynamicTable() throws Exception {

        System.out.println("this is DynamicTableTest ");

    }
}