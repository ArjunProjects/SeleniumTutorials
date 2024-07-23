import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.System.console;

public class JavascriptExecutorDemo {
    public static void main(String [] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        WebElement el =driver.findElement(By.id("alert1"));
        JavascriptExecutor js = (JavascriptExecutor)driver;

        // one way
        // js.executeScript("document.getElementById('alert1').click()");

        //other way
        js.executeScript("arguments[0].click()",el);

    }
}
