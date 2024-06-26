import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SyncDemo4 {

    public static void main(String[] version) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.id("ta1")).sendKeys("selenium");
        System.out.println("test");
    }
}
