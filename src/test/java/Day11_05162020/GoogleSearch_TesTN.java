
package Day11_05162020;

import Resuable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleSearch_TesTN {

        //when using annotation method your local driver
        //must be declared outside so i can call it on all my annotation method
        WebDriver driver;

        @Test
        public void googleSearch() throws InterruptedException {
            //enter the keyword car on my search field
            Reusable_Library.userKeys(driver, "//*[@name='q']", "cars", "Search field");
            //click on submit
            Reusable_Library.submit(driver, "//*[@name='btnK']", "Google search button");
            Thread.sleep(2000);
            //capture text print the search number
            String searchresult = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "Search result");
            //split the text and print the number
            String[] arraySearch = searchresult.split(" ");
            System.out.println("My search number for car is " + arraySearch[1]);


        }//end of test method

        @BeforeMethod
        public void CallDriver(){
            driver = Reusable_Library.setDriver();
            driver.navigate().to("https://www.google.com");

        }//end of beforeMethod

        @AfterMethod
        public void quitDriver(){
            driver.quit();
        }//end of afterMethod



    }//end of java class






