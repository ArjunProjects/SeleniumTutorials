import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarDemo6 {

    public static WebDriver driver;
    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");

        driver.findElement(By.id("third_date_picker")).click();

        selectDayInCalendar("10","Apr","2017");
    }

    public static void selectDayInCalendar(String selectDay,String selectMonth, String selectYear) {
        WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select s = new Select(month);
        s.selectByVisibleText(selectMonth);

        WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select s2 = new Select(year);
        s2.selectByVisibleText(selectYear);

        String xpath = "//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']//a[text()='"+selectDay+"']";
        driver.findElement(By.xpath(xpath)).click();
    }
}
