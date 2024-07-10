import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;

public class RobotClassDemo {

    public static void main(String[] args) throws AWTException, IOException {
        // robot class to take screenshots with application url and alerts but this isn't possible with normal way of screenshot method

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        Robot robot = new Robot();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rect = new Rectangle(d);
//        Rectangle rect = new Rectangle(d);
        BufferedImage bufferedImage = robot.createScreenCapture(rect);
        String path = System.getProperty("user.dir")+"//Screenshots/new.png";
        ImageIO.write(bufferedImage,"png",new File(path));

    }
}
