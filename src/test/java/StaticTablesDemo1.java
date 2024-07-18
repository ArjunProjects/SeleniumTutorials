import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StaticTablesDemo1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

       List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
       List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table1']//th"));
       for(int row = 1;row<=rows.size();row++) {
           if(row==1) {
               for(int col =1;col<=cols.size();col++) {
                   String xpathText = "//table[@id='table1']//th["+col+"]";
                   String tHeadData = driver.findElement(By.xpath(xpathText)).getText();
                   System.out.print(tHeadData+" ");

               }
           } else {
               for(int col =1;col<=cols.size();col++) {
                   String xpathTest = "//table[@id='table1']//tr["+(row-1)+"]//td["+col+"]";
                   String tBodyData = driver.findElement(By.xpath(xpathTest)).getText();
                   System.out.print(tBodyData+" ");
               }
           }
           System.out.println();
       }
    }
}

