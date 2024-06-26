import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo2 {
    static WebDriver driver=null;
    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/dropdowns");
        WebElement fruits = driver.findElement(By.id("fruits"));
        WebElement heros = driver.findElement(By.id("superheros"));
        WebElement lang = driver.findElement(By.id("lang"));
        WebElement country = driver.findElement(By.id("country"));


        selectOptionInDropDown(fruits,"index","1"); //normal dropdown
        selectOptionInDropDown(heros,"value","bt"); //multi select box
        selectOptionInDropDown(heros,"index","6");
        selectOptionInDropDown(lang,"visibletext","Java");
        selectOptionInDropDown(country,"value","India");

    }

    public static void selectOptionInDropDown(WebElement el, String optionSelection, String optionValue) {

        Select select = new Select(el);
        switch(optionSelection) {
            case "visibletext":
                select.selectByVisibleText(optionValue);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(optionValue));
                break;
            case "value":
                select.selectByValue(optionValue);
                break;
            default:
                System.out.println("none of the params passed in a function");
                break;

        }
    }
}
