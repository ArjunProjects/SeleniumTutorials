import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertsDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.id("alert1")).click();
        // will get UnhandledAlertException since we did not switch to the alert window
        driver.findElement(By.id("ta1")).sendKeys("selenium");

    }
}
