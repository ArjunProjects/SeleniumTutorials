import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class CalendarDemo4 {

    public static void main(String[] args) {


        String expectedDate = "15-10-2018";
        DateTimeFormatter formateDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parseDate = LocalDate.parse(expectedDate, formateDate);
        int eDay = parseDate.getDayOfMonth();
        int eMonth = parseDate.getMonthValue();
        int eYear = parseDate.getYear();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

       driver.findElement(By.id("datepicker")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ui-datepicker-title']")));

        String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        int convertStringMonthToInt = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(currentMonth).get(ChronoField.MONTH_OF_YEAR);

        String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
        int convertYearToInt = Integer.parseInt(currentYear);
// handling previous dates
        while(eMonth<convertStringMonthToInt || eYear<convertYearToInt) {
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            convertStringMonthToInt = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(currentMonth).get(ChronoField.MONTH_OF_YEAR);

            currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            convertYearToInt = Integer.parseInt(currentYear);
        }
// handling future dates
        while(eMonth>convertStringMonthToInt || eYear>convertYearToInt) {
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            convertStringMonthToInt = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(currentMonth).get(ChronoField.MONTH_OF_YEAR);

            currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            convertYearToInt = Integer.parseInt(currentYear);
        }

        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']//a[text()='"+eDay+"']")).click();



    }
}
