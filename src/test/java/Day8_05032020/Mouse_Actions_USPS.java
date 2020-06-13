package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Actions_USPS {
    public static void main(String[] args) throws InterruptedException {


        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "/Users/ibrokhimbekkhamidov/Desktop/JAVA AUTOMATION/src/Resource/chromedriver");
        //set some pre condition using ChromeOptions
        ChromeOptions options= new ChromeOptions();
        //set the argument  you want for the driver
        options.addArguments("incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to USPS
        driver.navigate().to("https://www.usps.com");

        Thread.sleep(2000);

        driver.manage().window().maximize();
        Thread.sleep(1500);


        //call your Mouse Action
        Actions mouse = new Actions(driver);

        //hover to Mail & Ship tab
        try {
            WebElement mailAndShip = driver.findElement(By.xpath("//*[text()='Mail & Ship']"));
            mouse.moveToElement(mailAndShip).perform();
        }catch (Exception e){
            System.out.println("Unable to locate Main & Ship " + e);
        }//end of Mail & Ship Exception


        //click on Click-N-Ship using Actions
         Thread.sleep(2000);

        try {
            //WebElement clickAndShip = driver.findElement(By.xpath("//*[@class='tool-cns']/a[text()='Click-N-Ship']"));
            WebElement clickAndShip = driver.findElement(By.xpath("//a[text()='Click-N-Ship']"));
            //call your Actions command to move to the element and then click
            mouse.moveToElement(clickAndShip).click().perform();
            //this is to submit using mouse actions
            //clickAndShip.submit();
            //mouse.moveToElement(clickAndShip).sendKeys(Keys.ENTER).perform();
        }catch (Exception e){
            System.out.println("Unable to locate Click-N-Ship " + e);
        }//end of Click-N-Ship Exception



    }//end of main

}//end of class
