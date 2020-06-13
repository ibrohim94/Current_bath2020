package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scrolling_Mortgage_Calculator {

    public static void main(String[] args) throws InterruptedException {


        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "/Users/ibrokhimbekkhamidov/Desktop/JAVA AUTOMATION/src/Resource/chromedriver");
        //set some pre condition using ChromeOptions
        ChromeOptions options= new ChromeOptions();
        //set the argument  you want for the driver
        options.addArguments("incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator home page
        driver.navigate().to("https://www.mortgagecalculator.org");

        Thread.sleep(3000);

        driver.manage().window().maximize();


        //declare and define javascript
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //scroll all the way to the bottom of the page

        //jse.executeScript("scroll(0,5000)");
        //Thread.sleep(2000);

        //scroll all the way to the up
        //jse.executeScript("scroll(0,-5000)");

        //Thread.sleep(1000);


        //scrolling to an element view for loan ream
        try {
            WebElement loanTerm = driver.findElement(By.xpath("//*[@id='loanterm']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",loanTerm);
        }catch (Exception e) {
            System.out.println("Unable to locate loanTerm " + e);


        }//end of loan Term





    }//end of main
}//end of class
