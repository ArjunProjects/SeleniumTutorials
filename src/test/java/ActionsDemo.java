import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://omayo.blogspot.com/");

        Actions act = new Actions(driver);
        WebElement blogs = driver.findElement(By.id("blogsmenu"));
        act.moveToElement(blogs).build().perform();
        WebElement options =driver.findElement(By.xpath("//li[@class='has-sub']//child::ul//child::li"));
        String xpath = "(//li[@class='has-sub']//child::ul//child::li)";
        for(int i=1;i<=4;i++) {

          String elPath = xpath+"["+i+"]";
          String actual = driver.findElement(By.xpath(elPath)).getText();
          System.out.println(actual);
          if(actual.contentEquals("SeleniumTwoByArun")) {
              driver.findElement(By.xpath(elPath)).click();
          } else {
              continue;
          }

        }
    }
}
