import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DynamicTableDemo {
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
        String eCname = "Kathy Durr";
        // one way to solve the checkbox thing

//        List<WebElement> cNames=driver.findElements(By.xpath("//form[@id='form-order']//table//tr//td[3]"));
//        for(int i=0;i<cNames.size();i++) {
//            if(cNames.get(i).getText().equals(eCname)) {
//                String xpathTest = "//form[@id='form-order']//table//tr["+(i)+"]//td[1]";
//                System.out.println(eCname+" Found at iteration "+(i+1));
//                driver.findElement(By.xpath(xpathTest)).click();
//
//                break;
//            } else {
//                System.out.println("did not find at iteration: "+(i+1)+" , please continue");
//            }
//        }

        // another simplest way to solve the checkbox thing

        String xpathTest = "//form[@id='form-order']//tbody//tr//td[text()='"+eCname+"']//preceding-sibling::td[2]";
        driver.findElement(By.xpath(xpathTest)).click();

    }
}
