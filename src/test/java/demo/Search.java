package demo;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static Base.Base.handleConfigFile;

public class Search extends Base {
    public static void main(String[] args) throws IOException {
        handleConfigFile();
        launchBrowser("chrome");
        launchApplication();
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@id='search']//input")).sendKeys(p.getProperty("searchProduct"));
        driver.findElement(By.xpath("//div[@id='search']//span")).click();
    }
}
