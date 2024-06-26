import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowsDemo {
    static Set<String> allWindows;
    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.xpath("//textarea[@id='ta1']")).sendKeys("hello from selenium");

        driver.findElement(By.linkText("Open a popup window")).click();
        driver.findElement(By.linkText("Blogger")).click();
        allWindows = driver.getWindowHandles();
        switchToRequiredWindow("New Window");
        switchToRequiredWindow("Blogger.com - Create a unique and beautiful blog easily.");
        driver.findElement(By.xpath("//a[text()='Create your blog']")).click();
        driver.quit();

    }

    public static void switchToRequiredWindow(String title) {
        Iterator<String> it = allWindows.iterator();
        while(it.hasNext()){
            String win = it.next();
            driver.switchTo().window(win);
            if (driver.getTitle().equals(title)) {
                System.out.println(driver.getTitle());
            }
        }

    }
}
