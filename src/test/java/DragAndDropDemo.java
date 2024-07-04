import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/p/page3.html");

        WebElement source = driver.findElement(By.xpath("//a[@aria-labelledby='price-min-label']"));
        WebElement destination = driver.findElement(By.xpath("//a[@aria-labelledby='price-max-label']"));
        Actions act = new Actions(driver);
//        act.dragAndDrop(source,destination).build().perform();
//        act.moveToElement(source).clickAndHold().moveToElement(destination).release().build().perform();
        act.dragAndDropBy(source,150,0).perform(); //moving across
        act.dragAndDropBy(source,-30,0).perform(); //moving left

    }


}
