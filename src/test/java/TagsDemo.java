import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TagsDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        List<WebElement> tags = driver.findElements(By.tagName("input"));
        for(WebElement tag:tags) {
            System.out.println(tag.getAttribute("type"));
        }
        System.out.println("number of input tags are "+tags.size());
        driver.quit();
    }
}
