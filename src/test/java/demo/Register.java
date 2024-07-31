package demo;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Register extends Base {

    public static void main(String[] args) throws IOException {
        handleConfigFile();
        launchBrowser("chrome");
        driver.get(p.getProperty("url"));
        driver.manage().window().maximize();

        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys(p.getProperty("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(p.getProperty("lastname"));
        driver.findElement(By.id("input-email")).sendKeys("testautomation"+getRandomNum()+"@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys(p.getProperty("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(p.getProperty("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(p.getProperty("password"));
        driver.findElement(By.xpath("//input[@name='newsletter' and @value='0']")).click();
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();


    }

    public static String getTimeStamp() {
        Date date = new Date();
        return date.toString().replace(" ","_").replace(":","_");

    }
    public static Integer getRandomNum() {
        Random r = new Random();
        return r.nextInt(10);
    }
}
