import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {

    static WebDriver driver =null;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.xpath("//label[@for='fromCity']")).click();
        WebElement search = driver.findElement(By.xpath("//label[@for='fromCity']"));
        search.sendKeys("Bang");
        search.sendKeys(Keys.ARROW_DOWN);
        search.sendKeys(Keys.ENTER);


    }
}
