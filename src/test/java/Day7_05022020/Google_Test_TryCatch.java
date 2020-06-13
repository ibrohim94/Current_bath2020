package Day7_05022020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Test_TryCatch {





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

            //using to catch exception to handle any error

            try {
                //locate the search field by inspecting it first and then enter a keyword let say cars
            }catch (Exception e){
                System.out.println("Unable to enter data on search Field" + e);
            }//end of search field exception
            try {
                driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            }catch (Exception e) {
                System.out.println("Unable to submit Icon" + e);
            }//end of search icon exception


            //wait few seconds
            Thread.sleep(2000);


            try {
                //to capture a text from web site you need to
                String message = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
                //using array variable to split above message
                String [] arrayResult = message.split(" ");
                System.out.println("My search number is " + arrayResult[1]);
            }catch (Exception e){
             System.out.println("Unable to capture on search Result" + e);
            }//end of search result exception


            //when you inspect an element and most of the time it takes you to the lowest tag and property within it
            // but I can still use the tags before and the properties of it as long as it highlights the same element in the page



            //i prefer to use quit


            //close vs quit the session
            //quit will kill the driver from your test memory
            //close will only close the driver but not from your memory
            //i prefer to use quit
            //driver.quit();

            driver.quit();






        }//end of main method



    }//end of java class