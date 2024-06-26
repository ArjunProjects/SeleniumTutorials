import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;
import java.sql.SQLOutput;
import java.util.List;

public class DropDownDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");
        WebElement drop = driver.findElement(By.id("drop1"));

        //Select select = new Select(drop);
        // select.selectByVisibleText("doc 1");
        // select.selectByIndex(1);
        // select.selectByValue("ghi");
//       boolean isSelect =  select.isMultiple();
//       System.out.println(isSelect);

        //multi select example

        WebElement mul = driver.findElement(By.id("multiselect1"));
        Select select = new Select(mul);
        System.out.println(select.isMultiple());
//        List<WebElement> options = select.getOptions();
//
//        for(WebElement option:options){
//            System.out.println(option.getText());
//        }

        select.selectByVisibleText("Hyundai");
        //select.selectByIndex(3);
        select.selectByValue("volvox");
        select.selectByIndex(1);
        select.deselectAll();
//        List<WebElement> all = select.getAllSelectedOptions();
//        for(WebElement a:all) {
//            System.out.println(a.getText());
//        }


    }
}
