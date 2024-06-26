import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HandlePushNotificationDemo {

    public static void main(String[] args) {
        ChromeOptions chrome = new ChromeOptions();
        chrome.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(chrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.justdial.com/");
        //driver.findElement(By.xpath("//div[text()='We are Hiring']")).click();
    }
}
