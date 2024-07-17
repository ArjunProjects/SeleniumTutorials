import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CalendarDemo5 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/");

        WebElement calendarField = driver.findElement(By.name("bdaytime"));
        calendarField.sendKeys("10092024");
        calendarField.sendKeys(Keys.TAB);
        calendarField.sendKeys("1030");
//        Actions act = new Actions(driver);

//        act.moveToElement(calendarField)
//                .sendKeys("12052024").pause(Duration.ofSeconds(10))
//                .sendKeys(Keys.TAB).pause(Duration.ofSeconds(10))
//                .sendKeys("1050").pause(Duration.ofSeconds(10));



        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
