package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static Properties p =null;
    public static WebDriver driver = null;

    public static void handleConfigFile() throws IOException {
        p = new Properties();
        FileInputStream fis = new FileInputStream(".//src//test//java//config//tutorials.properties");
        p.load(fis);
    }

    public static void launchBrowser(String browserName) {
        switch (browserName) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "internet explorer" -> driver = new InternetExplorerDriver();
            default -> throw new RuntimeException(browserName + " is not a valid browser to test");
        }

    }

    public static void launchApplication() {
        driver.get(p.getProperty("url"));
    }
}
