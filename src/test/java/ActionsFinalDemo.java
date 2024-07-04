import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsFinalDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        driver.findElement(By.id("input-firstname")).sendKeys("test");

        Actions act = new Actions(driver);
        act.sendKeys(Keys.TAB).pause(Duration.ofSeconds(5))
                .sendKeys("sele")
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(5))
                .sendKeys("test@gmail.com")
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(5))
                .sendKeys("123456778")
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(5))
                .sendKeys("12345abc")
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(5))
                .sendKeys("12345abc")
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(5))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(5))
                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(5))
                .sendKeys(Keys.SPACE).sendKeys(Keys.TAB).pause(Duration.ofSeconds(5))
                .sendKeys(Keys.ENTER).build().perform();

    }
}
