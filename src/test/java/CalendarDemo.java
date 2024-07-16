import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.tools.DocumentationTool;
import java.time.Duration;

public class CalendarDemo {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        driver.findElement(By.id("datepicker")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-title")));
        selectDayMonthYear("50","December","2024");

    }

    public static void selectDayMonthYear(String selectDay, String selectMonth, String selectYear) {


        if(Integer.parseInt(selectDay)>31) {
            System.out.println("Invalid date provided "+selectDay);
            return;
        }
        if(selectMonth.equalsIgnoreCase("february") && Integer.parseInt(selectDay)>28) {
            System.out.println("Invalid date provided for the month feb" +selectDay);
        }
        WebElement el = driver.findElement(By.className("ui-datepicker-title"));
        String monthYear = el.getText();
        String month = monthYear.split(" ")[0];
        String year = monthYear.split(" ")[1];
        System.out.println("Before changing the date:\n"+monthYear);
        while(!((month.equals(selectMonth))&&(year.equals(selectYear)))) {
            driver.findElement(By.xpath("//span[(text()='Next')]")).click();
            el = driver.findElement(By.className("ui-datepicker-title"));
            monthYear = el.getText();
            month = monthYear.split(" ")[0];
            year = monthYear.split(" ")[1];
        }
        System.out.println("after changing the date: "+driver.findElement(By.className("ui-datepicker-title")).getText());
        String xpath = "//td[@data-handler='selectDay']/a[text()='"+selectDay+"']";
        try {
            driver.findElement(By.xpath(xpath)).click();
        }catch (Exception e) {
            System.out.println("invalid date provided");
        }
    }
}
