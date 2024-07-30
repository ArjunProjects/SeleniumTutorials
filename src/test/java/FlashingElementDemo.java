import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class FlashingElementDemo {
    static WebDriver driver;
    public static void main(String[] args) throws IOException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        WebElement cartButton = driver.findElement(By.cssSelector("div#cart button"));
        WebElement cartBtn = driver.findElement(By.xpath("//div[@id='cart']//button"));
        WebElement searchText = driver.findElement(By.name("search"));
        javascriptFlash(driver,cartButton);
        javascriptDrawBorder(driver,cartBtn);
        //javascriptClick(driver,cartButton);
        String pageTitle = getApplicationTitle(driver);
        System.out.println(pageTitle);

        String pageUrl = javascriptPageUrl(driver);
        System.out.println(pageUrl);

        javascriptSendValue(driver,searchText,"Dell");
        String textOnPage = javascriptGetEntireTextFromPage(driver);
        System.out.println(textOnPage);

    }

    public static String javascriptGetEntireTextFromPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.documentElement.innerText").toString();
    }

    public static void javascriptScrollToDesiredElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public static void javascriptScrollToEndOfPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public static void javascriptDrawBorder(WebDriver driver, WebElement element) throws IOException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px solid red';",element);
        screenshotCapture();
        js.executeScript("arguments[0].style.border='';",element);
    }
    public static void javascriptFlash(WebDriver driver, WebElement element) {

        String defaultColor = element.getCssValue("background-color");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for(int i=0;i<30;i++) {

            js.executeScript("arguments[0].style.background='green';",element);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            js.executeScript("arguments[0].style.background='"+defaultColor+"';",element);
        }
    }
    public static void javascriptClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }

    public static void screenshotCapture() throws IOException {

       File screen =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileHandler.copy(screen, new File(".//Screenshots//highlight.png"));
    }

    public static String getApplicationTitle(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js.executeScript("return document.title").toString();
    }

    public static String javascriptPageUrl(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js.executeScript("return document.URL").toString();
    }

    public static void javascriptSendValue(WebDriver driver, WebElement element, String textToBeSearched) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+textToBeSearched+"'",element);
    }

    public static void javascriptRefreshApp(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0)");
    }
}
