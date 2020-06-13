package Day4_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_test {


    public static void main(String[] args) throws InterruptedException {

        //set the system chrome driver path at lease once in one of your main method
        //Webdriver.chrome.driver needs to be in lower case string followed by your driver path

        System.setProperty("webdriver.chrome.driver", "/Users/ibrokhimbekkhamidov/Desktop/JAVA AUTOMATION/src/Resource/chromedriver");


        //you declare and define the driver
        WebDriver driver = new ChromeDriver();

        //opening the browser automatically to go to google home page
        driver.navigate().to("https://www.google.com");

        //maximise your browser
        driver.manage().window().maximize();

        //wait few seconds after navigation to a page so browser can load properly
        //sleep statement handles in milliseconds so example 1 sec = 1000 millisecond
        Thread.sleep ( 2000);


        //locate the search field by inspecting in first and than enter a keyword let say cars
        driver.findElement(By.name("q")).sendKeys ("cars");
        //click on google search
        driver.findElement(By.name("btnK")).submit();



        //wait few seconds
        Thread.sleep(2000);




        //to capture a text from web site you need to
        String message = driver.findElement(By.id("result-stats")).getText();
        //using array variable to split above message
        String[] arrayResult = message.split(" ");
        System.out.println("My search number is " + arrayResult[1]);








        //close vs quit the session
        //quit will kill the driver from your test memory
        //close will only close the driver but not from your memory
        //i prefer to use quit
        //driver.quit();

        driver.quit();






    }//end of main method



}//end of java class
