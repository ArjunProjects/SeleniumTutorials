import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MultiWindowsDemo {

    static WebDriver driver = null;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        Helper.maximizeWindow();
        Helper.launchApplication("https://omayo.blogspot.com");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.findElement(By.id("ta1")).sendKeys("hello selenium");
        System.out.println("new application title: "+driver.getTitle());
        driver.switchTo().newWindow(WindowType.WINDOW);
        Helper.maximizeWindow();
        Helper.launchApplication("https://tutorialsninja.com/demo/");
        driver.findElement(By.name("search")).sendKeys("HP");
        System.out.println("new application title: "+driver.getTitle());
        System.out.println("test");
        driver.findElement(By.xpath("//button[@type='button']/parent::span")).click();
        Helper.quitBrowser();
    }


}
