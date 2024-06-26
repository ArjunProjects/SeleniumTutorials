import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class DemoCode {

    public static  void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("https://omayo.blogspot.com/");
//        String expectedString = "audi";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(By.xpath("//input[@name='textboxn']"));
        js.executeScript("arguments[0].scrollIntoView(true);",element);
       List<WebElement> dropDown = driver.findElements(By.xpath("//div[@id='LinkList1']//a"));
       int noOfLinks = dropDown.size();
       String path = "(//div[@id='LinkList1']//a)";
       for(int i=1;i<=noOfLinks;i++) {
            String elementPath = path+"["+i+"]";
            driver.findElement(By.xpath(elementPath)).click();
            driver.navigate().back();
        }

       driver.quit();

    }
}
