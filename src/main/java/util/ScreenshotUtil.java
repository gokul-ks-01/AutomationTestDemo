package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    static String folder =  System.getProperty("user.dir") +"/target/screenshots/" ;
    public static void captureScreenshot(WebDriver driver, String fileName) throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot)driver ;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File(folder+ fileName+".png"));


    }
}
