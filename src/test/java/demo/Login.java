package demo;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Login extends Base {

    public static void main(String[] args) throws IOException {
        handleConfigFile();
        launchBrowser("chrome");
        driver.get(p.getProperty("url"));
        driver.manage().window().maximize();

        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("input-email")).sendKeys(p.getProperty("email"));
        driver.findElement(By.id("input-password")).sendKeys(p.getProperty("password"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();

    }
}
