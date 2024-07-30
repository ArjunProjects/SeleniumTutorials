import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        WebElement el = driver.findElement(By.id("pah"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //change color of a paragraph in webpage
        js.executeScript("arguments[0].style.color='red'",el);

    }
}
