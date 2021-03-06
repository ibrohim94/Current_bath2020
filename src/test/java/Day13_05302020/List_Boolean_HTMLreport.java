package Day13_05302020;

import Day9_05092020.Reusable_Library;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class List_Boolean_HTMLreport {







    //declare the driver outside
    WebDriver driver;

    ExtentReports reports;

    ExtentTest logger;


    @BeforeSuite
    public void defineDriver() {
        driver = Reusable_Classes_logger.setDriver();
        //define the report path here as a before suite
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html",true);

    }//end of before method


    @Test
    public void yahoo_verification() throws InterruptedException{
        //define and start the test
        logger = reports.startTest("Yahoo verification");
        //navigate to yahoo home page
        logger.log(LogStatus.INFO,"Navigating to yahoo home page");

        //navigate to yahoo home page
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(4000);
        logger.log(LogStatus.INFO,"Getting the list count for all the links");
        //i want tp count all the links in yahoo home page and print it
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(17px)')]"));

        //verify if the linkCount returns you 12 links
        if (linkCount.size() == 13){
            System.out.println("MY yahoo page link count matches and it it " + linkCount.size());
            logger.log(LogStatus.PASS,"MY yahoo page link count matches and it it " + linkCount.size());

        }else {
            System.out.println("MY yahoo home page link count doesn't matches and actual is " + linkCount.size());
            logger.log(LogStatus.FAIL,"MY yahoo home page link count doesn't matches and actual is " + linkCount.size());
        }//end of else

        //click on sign in link
        Reusable_Classes_logger.click(driver,"//*[@id='header-signin-link']","Sign In",logger);
        //wait 3 seconds
        Thread.sleep(3000);
        //verify the state of the checkbox is checked for stay signed in section
        boolean checkboxstate = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkboxstate == true){
            System.out.println("Checkbox is selected by default");
            logger.log(LogStatus.PASS,"Checkbox is selected by default");
        }else{
            System.out.println("Checkbox is not selected by default");
            logger.log(LogStatus.FAIL,"Checkbox is not selected by default");

        }//end of else
        reports.endTest(logger);

    }//end of test method

    @AfterSuite
    public void closeSession(){
        driver.quit();
        //flushing = writing the logs(loggers) back to your automation report that you defined
        reports.flush();
    }//end of after suits




}
