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

    private static final ExtentReports extentReports;
    ExtentTest extentTest ;

    static {
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        htmlReporter.config().setDocumentTitle("Selenium Test Report");
        htmlReporter.config().setReportName("Test Result");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Extent Report - Test Suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Extent Report - Test Suite finished: " + context.getName());
        extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        extentTest = extentReports.createTest(testName);
        extentTest.log(Status.INFO, "Test Started");
        extentTest.assignCategory(result.getMethod().getRealClass().getSimpleName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test Failed");
        extentTest.log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test Skipped");
    }

    public static ExtentReports getExtentReports() {
        return extentReports;
    }
}
