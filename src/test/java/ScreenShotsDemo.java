import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShotsDemo {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

//      taking screenshot
//       File srcFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(srcFile,new File("./Screenshots/basic.png"));

        // take screenshots webelement wise
        WebElement el = driver.findElement(By.id("multiselect1"));
        File src = el.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("./Screenshots/test.png"));
//        driver.quit();
    }
}
