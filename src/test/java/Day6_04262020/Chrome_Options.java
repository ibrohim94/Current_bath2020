package Day6_04262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Chrome_Options {
    public static void main(String[] args) throws InterruptedException {


        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "/Users/ibrokhimbekkhamidov/Desktop/JAVA AUTOMATION/src/Resource/chromedriver");
        //set some pre condition using ChromeOptions
        ChromeOptions options= new ChromeOptions();
        //set the argument  you want for the driver
        options.addArguments("incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mlcalc.com
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);

        //I want to capture the title of the page
        //System.out.println("my title is " + driver.getTitle());
        //store your actual title on a variable and then compare with your expect
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("MORTGAGE CALCULATOR & LOAN CALCULATOR")) {
            System.out.println("Title matches with expected");
        }else {
            System.out.println("Titel doesn't match " + actualTitle);
        }//end of if else

        //use fullscreen command for some mac system
        driver.manage().window().fullscreen();

        //if same locator used more than once then store it as a WebElement variable to reuse it
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        //clear the field first
        pPrice.clear();
        //enter your new data
        pPrice.sendKeys("400000");

        //store your start month in WebElement variable and call it on your select command
        WebElement sMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        //call my selenium command and it only works when you dropdown locator is under select tag
        Select sMonthList = new Select(sMonth);
        //select the drop down value by visible text
        sMonthList.selectByVisibleText("Aug");

        //whenever drop down is not under select tag then we must click on the dropdown and then
        //click on the value of the dropdown
        //let's verify some of the start year to make sure it's matching on the drop down
        String[] yearArray = new String[] {"2005","2015","2035",};
        for (int i =0;i < yearArray.length;i++) {


            driver.findElement(By.xpath("//*[@name='sy']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[text()='"+yearArray[i]+ "']")).click();
        }//end of loop

    }//end of main method

}//end of java class
