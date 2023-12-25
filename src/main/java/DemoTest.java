import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class DemoTest {
    ExtentReports extentReports;
    @Test(priority = -1,groups = {"smoke","regression"})
    public void myTestMethod1(){
        System.out.println("test 1");

    }
    @Test(priority = 1)
    public void myTestMethod2(){
        System.out.println("test 2");
    }
    @Test(priority = 2,groups = "smoke")
    public void myTestMethod3(){System.out.println("test 3");
    }
    @Test(priority = 3)
    public void myTestMethod4(){
        System.out.println("test 4");
    }



    @Parameters({"browser"})
    @Test(priority=1)
    public  void myTestMethod5(String p){
        extentReports = generateReports() ;
        ExtentTest extenTest =extentReports .createTest("myTestMethod5");
        extenTest.log(Status.INFO,"entering test");
        System.out.println(p);
        extenTest.log(Status.PASS,"test passed");
        extentReports.flush();
    }

    public ExtentReports generateReports(){
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Test Automation Results");
        htmlReporter.config().setTheme(Theme.STANDARD);
         extentReports= new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        return extentReports;
    }

    @AfterTest
    public void tearDown(){

    }
}
