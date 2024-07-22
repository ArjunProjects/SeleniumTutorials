import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PaginationDemo {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //https://demo3x.opencartreports.com/admin/
        driver.get("https://demo3x.opencartreports.com/admin/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        File file =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-username"))).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(file,new File(".//Screenshots/username.png"));
        driver.findElement(By.id("input-username")).sendKeys("demo");
        driver.findElement(By.id("input-password")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("Sales")).click();
        driver.findElement(By.linkText("Orders")).click();


        String pageNumber = driver.findElement(By.xpath("//div[contains(text(),'Showing')]")).getText();
        String eName="Lester Mercedes";
        int sIndex = pageNumber.indexOf("(")+1;
        int eIndex = pageNumber.indexOf("Pages")-1;
        System.out.println(sIndex);
        System.out.println(eIndex);
        String totalPages = pageNumber.substring(sIndex,eIndex);
        System.out.println(totalPages);

        for(int p=0;p<Integer.parseInt(totalPages);p++) {
            String xpathTest = "//form[@id='form-order']//table//tr//td[contains(text(),'"+eName+"')]";
           try {

               if(driver.findElement(By.xpath(xpathTest)).isDisplayed()) {
                   String xpathTest2 = "//form[@id='form-order']//table//tr//td[contains(text(),'"+eName+"')]//preceding-sibling::td[2]";
                   driver.findElement(By.xpath(xpathTest2)).click();
                   break;
               }
           }catch(Throwable t) {

           }

                driver.findElement(By.xpath("//ul[@class='pagination']//li[@class='active']//span//following::a[1]")).click();
        }


    }
}
