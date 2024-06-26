import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SyncDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://verifalia.com/validate-email");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement val = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Validate']")));
        val.click();
        System.out.println("validate button clicked");
    }
}
