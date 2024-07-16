import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.tools.DocumentationTool;
import java.time.Duration;

public class CalendarDemo3 {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");

        WebElement cal = driver.findElement(By.id("form-field-travel_comp_date"));

        Actions act = new Actions(driver);
        act.moveToElement(cal).click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='flatpickr-current-month']")));
        System.out.println(driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText());

        selectDayMonthYear("16","January","2024");

    }

    public static void selectDayMonthYear(String selectDay, String selectMonth, String selectYear) {


        if(Integer.parseInt(selectDay)>31) {
            System.out.println("Invalid date provided "+selectDay);
            return;
        }
        if(selectMonth.equalsIgnoreCase("february") && Integer.parseInt(selectDay)>28) {
            System.out.println("Invalid date provided for the month feb" +selectDay);
        }
        WebElement el = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']"));
        String monthYear = el.getText();
        String month = monthYear.split(" ")[0];
        String year = monthYear.split(" ")[1];
        System.out.println("Before changing the date:\n"+monthYear);
        while(!((month.equals(selectMonth))&&(year.equals(selectYear)))) {
            driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
            el = driver.findElement(By.xpath("//div[@class='flatpickr-current-month']"));
            monthYear = el.getText();
            month = monthYear.split(" ")[0];
            year = monthYear.split(" ")[1];
        }
        //System.out.println("after changing the date: "+driver.findElement(By.className("ui-datepicker-title")).getText());
        String xpath = "//td[@data-handler='selectDay']/a[text()='"+selectDay+"']";
        String xpath2 = "//div[@class='dayContainer']//span[@class='flatpickr-day '][text()='"+selectDay+"']";
        try {
            driver.findElement(By.xpath(xpath)).click();
        }catch (Exception e) {
            System.out.println("invalid date provided");
        }
    }
}
