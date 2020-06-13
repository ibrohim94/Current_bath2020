package Day5_04252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LOcate_By_Xpath {

    public static void main(String[] args) throws InterruptedException {


        //define your property
        System.setProperty("webdriver.chrome.driver", "/Users/ibrokhimbekkhamidov/Desktop/JAVA AUTOMATION/src/Resource/chromedriver");
        //define the driver
        WebDriver driver = new ChromeDriver();
        //navigate to amazon home page
        driver.navigate().to("https://www.amazon.com");
        //maximize your driver window
        driver.manage().window().maximize();
        //wait few seconds
        Thread.sleep(2000);

        //enter a keyword laptop on amazon search field by using xpath
        driver.findElement(By.xpath("//*[@name='field-keywords']")).sendKeys("laptop");
        //click on search icon
        driver.findElement(By.xpath("//*[@value='Go']")).submit();

        Thread.sleep(2000);
        //click on second image item of the same element within that page using index number
        driver.findElements(By.xpath("//img[contains (@class,'s-image')]")).get(2).click();
        //renovate back to home page
        driver.navigate().to("https://www.amazon.com");

    }//end of main
}//end of java class
