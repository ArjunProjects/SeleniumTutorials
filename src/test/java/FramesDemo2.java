import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FramesDemo2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://docs.oracle.com/javase/8/docs/api/");
        List<WebElement> frames= driver.findElements(By.tagName("frame"));
        int countOfFrames = frames.size();
        System.out.println(countOfFrames);
        int el = 0;
        int index = 0;
        for(int i=0;i<countOfFrames;i++) {
            driver.switchTo().frame(i);
            el = driver.findElements(By.linkText("Description")).size();

            if(el>0) {
                index = i;
                driver.switchTo().parentFrame();
                break;
            }
            driver.switchTo().parentFrame();
        }
        driver.switchTo().frame(index);
        driver.findElement(By.linkText("Description")).click();
    }
}
