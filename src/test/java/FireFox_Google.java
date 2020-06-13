import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.WatchEvent;

public class FireFox_Google {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
        WebDriver driver =new FirefoxDriver();
        driver.navigate().to("https://www.google.com");
    }

}//
