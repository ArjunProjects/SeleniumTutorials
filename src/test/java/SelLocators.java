import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java. lang.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SelLocators {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://omayo.blogspot.com/");
//        Rectangle r = driver.findElement(By.id("but2")).getRect();
//        System.out.println(r.getHeight());
//        System.out.println(r.getWidth());
//        System.out.println(r.getX());
//        System.out.println(r.getY());
        driver.manage().window().fullscreen();

        driver.quit();

    }
}
