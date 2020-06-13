package Resuable_Classes;


import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class Abstract_class {

    //to be used on your @Test classes
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;


    //define before suite to set a static driver
    @BeforeSuite
    public void defineDriver() throws IOException, InterruptedException {
        driver = Reusable_Classes_logger.setDriver();
        //define the report path as usual
        reports = new ExtentReports("src/main/java/HTML_Report/TestReport.html",true);


    }//end of before suite

    //before method will be used to capture a unique @test name that you gave
    //on your test class

    @BeforeMethod
    public void getMethodName(Method testName){
        //start the logger here to capture specific @Test method name
        logger = reports.startTest(testName.getName());

    }//end of before method
    //after method will end each test

    @AfterMethod
    public void endTest(){

        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void classInfo(){
        driver.quit();
        //or
        reports.flush();
    }//end of afterSuite



}//end of java class