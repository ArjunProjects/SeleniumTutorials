import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FramesDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://docs.oracle.com/javase/8/docs/api/");
//
//        List<WebElement> frames=driver.findElements(By.xpath("//frame"));
//
//        int framesSize = frames.size();
//
//        driver.switchTo().frame(1);
//        driver.findElement(By.linkText("AbstractButton")).click();
//
//        driver.navigate().back();
//
//        driver.switchTo().frame(2);
//        driver.findElement(By.linkText("Description")).click();

         driver.get("https://the-internet.herokuapp.com/nested_frames");
         driver.switchTo().frame("frame-top");
         driver.switchTo().frame("frame-left");
         WebElement topFrame = driver.findElement(By.xpath("//body"));
         System.out.println(topFrame.getText());
         driver.switchTo().parentFrame();
         driver.switchTo().frame("frame-middle");
         WebElement middleFrame = driver.findElement(By.xpath("//body"));
         System.out.println(middleFrame.getText());
         driver.switchTo().parentFrame();
         driver.switchTo().frame("frame-right");
        WebElement rightFrame = driver.findElement(By.xpath("//body"));
        System.out.println(rightFrame.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrame = driver.findElement(By.xpath("//body"));
        System.out.println(bottomFrame.getText());





    }
}
