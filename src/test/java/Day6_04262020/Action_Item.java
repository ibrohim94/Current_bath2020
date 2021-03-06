package Day6_04262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Action_Item {
    public static void main(String[] args) throws InterruptedException {
        String[] zipCode = new String[3];
        zipCode[0] = "11238";
        zipCode[1] = "11223";
        zipCode[2] = "11209";


        //set the chrome path
        System.setProperty("webdriver.chrome.driver", "/Users/ibrokhimbekkhamidov/Desktop/JAVA AUTOMATION/src/Resource/chromedriver");
        //set some pre condition using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the argument  you want for the driver
        options.addArguments("incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to weightwatchers.com
        driver.navigate().to("https://weightwatchers.com");
        Thread.sleep(2000);

        //use fullscreen command
        driver.manage().window().maximize();
        //set your actual title than compare it with expected title
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("WW (Weight Watchers): Weight Loss & Wellness Help | WW USA")) {
            System.out.println("Title matches with expected");
        } else {
            System.out.println("Title doesn't match " + actualTitle);
        }//end of else

        for (int i = 0; i <=2; i++) {
            driver.findElement(By.xpath("//*[@id='ela-menu-visitor-desktop-supplementa_find-a-workshop']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='meetingSearch']")).sendKeys(zipCode[i]);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class='btn spice-translated']")).submit();
            Thread.sleep(2000);
            if (i == 0) {
                driver.findElements(By.xpath("//*[@class='location__name']")).get(0).click();
                Thread.sleep(2000);

            } if (i==1) {
                driver.findElements(By.xpath("//*[@class='location__name']")).get(2).click();
                Thread.sleep(3000);

            } if (i==2) {
                driver.findElements(By.xpath("//*[@class='location__name']")).get(3).click();
                Thread.sleep(2000);
            }


            String location = driver.findElement(By.xpath("//*[@class = 'location__container']")).getText();
            Thread.sleep(2000);
            System.out.println(location);
            Thread.sleep(2000);
            String schedule = driver.findElement(By.xpath("//*[@class = 'meeting-detail-bottom-top']")).getText();
            Thread.sleep(2000);
            System.out.println(schedule);
            Thread.sleep(2000);


        }//end of the for loop
         driver.quit();

        //click on find studio





        //driver.quit();
    }//end of main method

}//end of java class
