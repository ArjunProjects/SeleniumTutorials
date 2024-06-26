import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertsDemo2 {


   public static void main(String[] args) {
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://omayo.blogspot.com/");

       Alert alert = driver.switchTo().alert();
       // NoAlertPresentException should display as we did not click on alert
       driver.findElement(By.id("ta1")).sendKeys("test");
   }
}
