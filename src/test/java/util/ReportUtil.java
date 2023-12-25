package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportUtil implements ITestListener {

    private final ExtentReports extentReports;
    private static ExtentTest extentTest;
    String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
    public ReportUtil() {
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportPath);
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Selenium Test Report");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }

    @Override
    public void onStart(ITestContext context) {
        // Not required to do anything specific here, as initialization is done in the constructor
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.INFO,"Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (extentTest != null) {
            extentTest.log(Status.PASS, "Test passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (extentTest != null) {
            extentTest.log(Status.FAIL, "Test Failed");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (extentTest != null) {
            extentTest.log(Status.SKIP, "Test Skipped");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    public ExtentReports getExtentReports() {
        return extentReports;
    }

    public static void writeTestInfo(String info){
        extentTest.log(Status.INFO,info);
    }
}
