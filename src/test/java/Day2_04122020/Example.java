package Day2_04122020;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Example {
    public static void main(String[] args) throws InterruptedException {
        //first set the chrome path
        System.setProperty("webdriver.chrome.driver", "src/Resource/chromedriver");
        //set some pre conditions using the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //set the arguments you want for the driver
        options.addArguments("incognito");

        //define chrome driver
        WebDriver driver = new ChromeDriver(options);

        //must define the string Array variables
        String[] zipCode = new String[3];
        zipCode[0] = "10006";
        zipCode[1] = "10010";
        zipCode[2] = "10018";
        //above i used dynamic array and defined my variables

        //go to the website and open the home page
        driver.navigate().to("https://www.weightwatchers.com/us");


        //now maximize the web page
        driver.manage().window().maximize();


        //sleep now 2 seconds
        Thread.sleep(2000);

        //i want to capture the website name and print it
        String Title = driver.getTitle();
        if (Title.equals("WW (Weight Watchers): Weight Loss & Wellness Help")) {
            System.out.println("Title matches as expected ");
        } else {
            System.out.println("Title doesn't match");
        }
        System.out.println(driver.getTitle());

        //sleep now 2 seconds
        Thread.sleep(2000);


        //starting of the for loop
        for (int i = 0; i < zipCode.length; i++) {


            //now i want it to click on the find a workshop
            driver.findElement(By.xpath("//*[@id='ela-menu-visitor-desktop-supplementa_find-a-workshop']")).click();

            //sleep for 2 seconds
            Thread.sleep(2000);

            //let's enter our zipCodes in the search field
            driver.findElement(By.xpath("//*[@id='meetingSearch']")).sendKeys(zipCode[i]);
            //sleep for 2 seconds
            Thread.sleep(3500);
            //
            driver.findElement(By.xpath("//*[@class='btn spice-translated']")).click();

            if (i == 0) {
                driver.findElements(By.xpath("//*[@class='location__name']")).get(0).click();

                Thread.sleep(2000);

            }//end of the else condition
            if (i == 1) {

                driver.findElements(By.xpath("//*[@class='location__name']")).get(1).click();

                Thread.sleep(2000);
            }//end of the else if condition

            if (i == 2){
                driver.findElements(By.xpath("//*[@class='location__name']")).get(2).click();

            }//end of the else condition

            //sleep for 2 seconds
            Thread.sleep(2000);

            String address1 = driver.findElement(By.xpath("//*[@class='location__container']")).getText();
            System.out.println("The zipCode of my WW is "+zipCode[i] + "and the Name is " + address1);

            //print the table
            String tableA = driver.findElement(By.xpath("//*[@class='meeting-detail-bottom-top']")).getText();
            System.out.println("The Location for my WW's are " + zipCode[i] + " my S-chart is " + tableA);



        }//end of for loop


        driver.quit();
        //quit the session


    }//end of main method
}

