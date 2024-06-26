import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LightBoxDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.name("search")).sendKeys("HP");
        driver.findElement(By.xpath("//span[@class=\"input-group-btn\"]/button")).click();
        driver.findElement(By.linkText("HP LP3065")).click();
        driver.findElement(By.xpath("//a[@title='HP LP3065']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='mfp-close']"))));
        driver.findElement(By.xpath("//button[@class='mfp-close']")).click();
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
