import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;


public class AlertTest {

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
    public void verifyAlert() throws Exception {

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
        WebElement alertsTab = driver.findElement(By.id("alert-modal"));
        alertsTab.click();
        driver.findElement(By.xpath("//a[text()='Javascript Alert']")).click();
        driver.findElement(By.xpath("//button[text()='Click me!' and @class='btn btn-success']")).click();
        Alert alert = driver.switchTo().alert();
        //Assert.assertEquals(alert.getText().trim(),"I am a Javascript alert box!");
        // Assertion hardAssert =  new Assertion();
        SoftAssert softAssert = new SoftAssert();
        //Assertion softAssert = new SoftAssert();
        // hardAssert.assertEquals(alert.getText().trim(),"I am a Javascript alert bo!");
        softAssert.assertEquals(alert.getText().trim(),"I am a Javascript alert box!");
        alert.accept();
        driver.quit();
        System.out.println("after assertion");
        softAssert.assertAll();

        //wait commands


        /*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("")))).click();*/

/*

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.pollingEvery(Duration.ofSeconds(2));
        fluentWait.withTimeout(Duration.ofSeconds(30));
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.ignoring(WebDriverException.class);
        WebElement element= fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver arg) {
                return arg.findElement(By.id("email"));
            }
        });
*/


        //JavascriptExecutor
        /*JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver ;
        String value = "text";
        javascriptExecutor.executeScript("document.getElementById('textBox').value='"+value+"'");
        javascriptExecutor.executeScript("window.open('', '_blank');");
        javascriptExecutor.executeScript("window.scrollBy(100, 0)");
        javascriptExecutor.executeScript("window.scrollBy(0, 100)");*/

        //screenshot
       /* TakesScreenshot takesScreenshot = (TakesScreenshot)driver ;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("C:\\Programming\\Obsqura\\SeleniumTrainingDemo\\target\\screenshot.png"));
*/
        //robot class
       /* String filePath = "path/to/your/file.txt";
        Robot robot = new Robot();
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        driver.findElement(By.xpath("")).click();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/

        //iframes
        /*driver.switchTo().frame("firstframe") ;
        driver.switchTo().frame(driver.findElement(By.id("childFrame1")));
        driver.switchTo().parentFrame();
        driver..frame(driver.findElement(By.id("childFrame2")));
        driver.switchTo().defaultContent();
        */

        //window handle
        /*String parentWindow = driver.getWindowHandle();
        Set<String> WindowHandlesss= driver.getWindowHandles() ;
        for (String childWindow : WindowHandlesss) {
            if (!parentWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }*/

        //alert
        /*Alert alert= driver.switchTo().alert();
        alert.sendKeys("ok");
        alert.getText() ;
        alert.accept();
        alert.dismiss();*/


        //actions
        /*Actions action = new Actions(driver);
        action.doubleClick().perform();
        action.contextClick(sourceElement).perform();
        action.dragAndDrop(sourceElement,targetElement).perform();
        action.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();*/



    }
}