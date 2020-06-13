package Day12_05172020;

import Resuable_Classes.Reusable_Library;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Kayak_TestNG_Assertions {
    //declare the webdriver outside the all method to reuse it
    WebDriver driver;


    @BeforeSuite
    public void defineDriver(){
        driver = Reusable_Library.setDriver();


    }//end of before suite

    @Test
    public void KayakTestCase () throws InterruptedException {

        driver.navigate().to("www.kayak.com");
        Thread.sleep(2000);


        //verify the title using hard assertion
        //assert.assertEquals(driver.getTitle(),"search Hotels, cars");
        //using soft assertion

        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(driver.getTitle(),"Search Hotels, Cars ");
        //click airport or city
        Reusable_Library.click(driver,"//*[continues(@id,'pickup-field')]","search Field");
        //enter the airport
        Reusable_Library.userKeys(driver,"//*[@name='pickup']","JFK","search Field");
        Thread.sleep(3000);
        //pass assertAll that it doesn't skip all your test steps
        sAssert.assertAll();
    }//end of the method
    @AfterMethod
    public void closeSession(){
        driver.quit();

    }//end of after suite


}//end of java class
