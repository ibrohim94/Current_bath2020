package Day7_05022020;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Mat_Life_Tabs {

    public static void main(String[] args) {



        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "/Users/ibrokhimbekkhamidov/Desktop/JAVA AUTOMATION/src/Resource/chromedriver");
        //set some pre condition using ChromeOptions
        ChromeOptions options= new ChromeOptions();
        //set the argument  you want for the driver
        options.addArguments("incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);








    }//end of main
}//end of class
