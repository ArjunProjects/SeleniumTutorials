import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sel.HelperDemo;

import java.time.Duration;

public class WaitsDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        driver.get("https://omayo.blogspot.com/");
//        driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
//        driver.findElement(By.linkText("Gmail")).click();
//        System.out.println("gmail clicked");
//        driver.quit();

        // explicit wait
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Gmail")));
        driver.findElement(By.linkText("Gmail")).click();
        driver.quit();
    }
}
