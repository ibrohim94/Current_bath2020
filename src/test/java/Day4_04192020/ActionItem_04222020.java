package Day4_04192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionItem_04222020 {

    public static void main(String[] args) throws InterruptedException {

        //open google chrome
        System.setProperty("webdriver.chrome.driver", "/Users/ibrokhimbekkhamidov/Desktop/JAVA AUTOMATION/src/Resource/chromedriver");

        WebDriver driver = new ChromeDriver();

           //create a dynamic array loop for country
        String[] country = new String[5];
        country[0] = "USA";
        country[1] = "China";
        country[2] = "CANADA";
        country[3] = "INDIA";
        country[4] = "RUSSIA";


        //this is where you will start your loop from navigate up until before quit

        for (int i = 0; i < country.length; i++) {
            //opening the browser automatically to go to Bing home page
            driver.navigate().to("https://www.Bing.com");
           //maximize the browser
            driver.manage().window().maximize();

            //wait few second
            Thread.sleep(2000);


             //it's displaying the search box than it's letting search for countries
            driver.findElement(By.name("q")).sendKeys(country[i]);
            //it's entering Bing search
            driver.findElement(By.id("sb_form_go")).submit();

            //wait time is 2 second
            Thread.sleep(2000);

             //web will catch the result you need
            String message = driver.findElement(By.className("sb_count")).getText();

            //array splits the message
            String[] arrayResult = message.split(" ");
            System.out.println("My county is " + country[i] + " and search number is " + arrayResult[0]);











        }//end of loop
         // browser will close
        driver.quit();



    }//end of main method


}//end of java class
