package Day6_04262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class self_though {
    public static void main(String[] args) throws InterruptedException {

         String [] zipCode= new String[2];
         zipCode[0] = "11204";
         zipCode[1] = "11218";


        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "/Users/ibrokhimbekkhamidov/Desktop/JAVA AUTOMATION/src/Resource/chromedriver");
        //set some pre condition using chromeOptions
        ChromeOptions options = new ChromeOptions();
        //set up the argument
        options.addArguments("incognito");
        //define your chrome drive
        WebDriver driver = new ChromeDriver(options);
        //navigate to state form
        driver.navigate().to("https://www.libertymutual.com");
        Thread.sleep(2000);
        //maximize the window
        driver.manage().window().maximize();
        Thread.sleep(2000);

        String CompName = driver.getTitle();
        if (CompName.equals("Start Saving with a Free Custom Quote | Liberty Mutual")){
            System.out.println("CumpName matches as expected" + CompName);
        }else {
            System.out.println("CumpName does not matched as expected " + "Please f youself ");
        }
         Thread.sleep(3000);

        for (int i=0; i < zipCode.length; i++) {
            driver.findElement(By.xpath("//*[@"));
        }






    }//end of main method

}//end of java class
