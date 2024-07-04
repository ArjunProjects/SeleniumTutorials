import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyDownAndKeyUpDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        WebElement el = driver.findElement(By.linkText("compendiumdev"));
        Actions act = new Actions(driver);
        //opens the link in new tab
        act.keyDown(Keys.CONTROL).moveToElement(el).click().keyUp(Keys.CONTROL).build().perform();

    }
}
