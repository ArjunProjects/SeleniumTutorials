import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/resizable/");

        WebElement frameEl = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frameEl);

        WebElement resizeEl = driver.findElement(By.xpath("(//div[@style='z-index: 90;'])[3]"));
        Actions act = new Actions(driver);


        act.dragAndDropBy(resizeEl,50,80).perform();
    }
}
