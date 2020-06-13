package Resuable_Classes;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;

public class Reusable_Classes_logger {
        static int timeout = 20;


        //method to re use chrome driver and chrome options
        public static WebDriver setDriver(){
            //set the chrome path
            System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver2");
            //set some pre conditions using ChromeOptions
            ChromeOptions options = new ChromeOptions();
            //set the arguments you want for the driver
            options.addArguments("incognito");
            //now simply define your chrome driver
            WebDriver driver = new ChromeDriver(options);

            return driver;
            //must return because its a return type it will be using more than once so it has to return or the system let me use it many times
            //when ever you are creating a reusable make sure to understand it if its void or return
        }

        //method to compare expected with actual title
        public static void verifyTitle(WebDriver driver,String expectedTitle, ExtentTest logger){
            String actualTitle = driver.getTitle();
            if(actualTitle.equals(expectedTitle)){
                System.out.println("Expected title matches with Actual " + expectedTitle);
                Reporter.log("Expected title matches with Actual " + expectedTitle);
                logger.log(LogStatus.INFO,"Expected title matches with Actual " + expectedTitle);
            } else {
                System.out.println("Expected doesn't match actual title. Actual title is " + actualTitle);
                Reporter.log("Expected doesn't match actual title. Actual title is " + actualTitle);
                logger.log(LogStatus.FAIL,"Expected doesn't match actual title. Actual title is " + actualTitle);
            }
        }//end of verify title method


        //method to select a drop down value by visible text
        public static void dropdownByText(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            try{
                System.out.println("Selecting a value on element " + elementName);
                Reporter.log("Selecting a value on element " + elementName);
                logger.log(LogStatus.INFO,"Selecting a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                Select dDown = new Select(element);
                dDown.selectByVisibleText(userInput);
            } catch (Exception e) {
                System.out.println("Unable to select element " + elementName + " " + e);
                Reporter.log("Unable to select element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to select element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of drop down by text method

        //method to enter user input on send keys
        public static void userKeys(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            try{
                System.out.println("Entering a value on element " + elementName);
                Reporter.log("Entering a value on element " + elementName);
                logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.clear();
                element.sendKeys(userInput);
            } catch (Exception e) {
                System.out.println("Unable to enter element " + elementName + " " + e);
                Reporter.log("Unable to enter element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of sendKeys method

        //method to click on an element
        public static void click(WebDriver driver, String locator, String elementName, ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            try{
                System.out.println("Clicking a value on element " + elementName);
                logger.log(LogStatus.INFO,"Clicking a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to click element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click method

        //method to submit on an element
        public static void submit(WebDriver driver,String locator,String elementName, ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            try{
                System.out.println("Submitting a value on element " + elementName);
                logger.log(LogStatus.INFO,"Submitting a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.submit();
            } catch (Exception e) {
                System.out.println("Unable to submit element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to submit element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click method

        //method to return text from an element
        //when you are capturing the text its a String so its return
        //its not the title of the page its the text within the page like the headline
        public static String captureText(WebDriver driver,String locator,String elementName, ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            String result = null;
            //null means nothing it just has to be there
            try{
                System.out.println("Capturing a text from element " + elementName);
                logger.log(LogStatus.INFO,"Capturing a text from element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                result = element.getText();
                System.out.println("My Text result is " + result);
            } catch (Exception e) {
                System.out.println("Unable to capture text on element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }

            return result;
        }//end of click method

        public static void mouseHover(WebDriver driver,String locator,String elementName, ExtentTest logger) {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            Actions mouse = new Actions(driver);
            try{
                System.out.println("Move to the element " + elementName);
                logger.log(LogStatus.INFO,"Move to the element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

                mouse.moveToElement(element).perform();
            }catch (Exception e) {
                System.out.println("Unable to move element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to move element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }//end of catch
        }//end of mouseHover


        //method to click by index on an element
        public static void clickByIndex(WebDriver driver,String locator,int index, String elementName, ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            try{
                System.out.println("Clicking a value by index " + index + " on element " + elementName);
                logger.log(LogStatus.INFO,"Clicking a value by index " + index + " on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator))).get(index);
                element.click();
            } catch (Exception e) {
                System.out.println("Unable to click by index " + index +  " on element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to click by index " + index +  " on element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }
        }//end of click method

        //method to enter user input on send keys
        public static void userTypeAndHitEnter(WebDriver driver,String locator, String userInput, String elementName, ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            try{
                System.out.println("Entering a value on element " + elementName);
                Reporter.log("Entering a value on element " + elementName);
                logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.clear();
                Thread.sleep(2000);
                element.sendKeys(userInput);
                Thread.sleep(2500);
                element.sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("Unable to enter element " + elementName + " " + e);
                Reporter.log("Unable to enter element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }

        }//end of userTypeAndHitEnter method
        public static void Enter(WebDriver driver,String locator,String elementName, ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            try{
                System.out.println("Entering a value on element " + elementName);
                logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                element.sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("Unable to enter element " + elementName + " " + e);
                Reporter.log("Unable to enter element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }

        }//end of userTypeAndHitEnter method

        public static void mouseClick(WebDriver driver,String locator,String elementName, ExtentTest logger){
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            Actions mouse= new Actions(driver);
            try{
                System.out.println("Entering a value on element " + elementName);
                logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                mouse.moveToElement(element).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to enter element " + elementName + " " + e);
                logger.log(LogStatus.FAIL,"Unable to enter element " + elementName + " " + e);
                getScreenShot(driver,logger,elementName);
            }

        }//end of userTypeAndHitEnter method


        //screenshot
        public static void getScreenShot(WebDriver wDriver, ExtentTest logger, String imageName) {
            try {
                String fileName = imageName + ".png";
                String directory = "src/main/java/HTML_Report/Screenshots/";
                File sourceFile = ((TakesScreenshot) wDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(sourceFile, new File(directory + fileName));
                //String imgPath = directory + fileName;
                String image = logger.addScreenCapture("Screenshots/" + fileName);
                logger.log(LogStatus.FAIL, " ", image);
            } catch (Exception e) {
                logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
                e.printStackTrace();
            }
        }


}//end of java class
