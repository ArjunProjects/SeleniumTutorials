import org.openqa.selenium.WebDriver;

public class Helper {
   static WebDriver driver = null;
    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void launchApplication(String url) {
        driver.get(url);
    }

    public static void quitBrowser() {
        driver.quit();
    }
}
