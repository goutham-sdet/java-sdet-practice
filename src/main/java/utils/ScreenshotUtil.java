package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil
{
    public static String takeScreenshot(WebDriver driver, String testname)
    {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss"));
        String dir = "target/screenshots/";
        try
        {
            Files.createDirectories(Paths.get(dir));
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = dir + testname + "_" + timestamp + ".png";
            Files.copy(src.toPath(), Paths.get(path));
            return path;
        }
        catch(IOException e)
        {
            throw new RuntimeException("Failed to save Screenshot", e);
        }
    }
}