import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //to handle popup authentication
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement el =driver.findElement(By.xpath("//p"));
        System.out.println(el.getText());
    }
}
