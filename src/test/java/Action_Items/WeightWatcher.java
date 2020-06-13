package Action_Items;

import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WeightWatcher extends Abstract_class {

    @Test
    public void weightWatchers() throws InterruptedException {

        //define the string array variable
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11223");
        zipCode.add("11238");
        zipCode.add("11000");

        //defining the  log information for navigating to the weight watcher web
        logger.log(LogStatus.INFO, "navigating to weight watchers website");

        //navigate to the weight watcher website
        driver.navigate().to("https://weightwatchers.com");

        //wait for few secs
        Thread.sleep(3000);

        //verifying the title
      Reusable_Classes_logger.verifyTitle(driver, "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA", logger);

        for (int i = 0; i < zipCode.size(); i++) {
            Reusable_Classes_logger.click(driver, "(//*[contains(text(),'Find a Workshop')]) [1]", "Clicking find a workshop", logger);

            //Click on the search box
            Reusable_Classes_logger.click(driver, "//*[@id='meetingSearch']", "Search box", logger);

            //enter the zipCode inside the search box
            Reusable_Classes_logger.userTypeAndHitEnter(driver, "//*[@id='meetingSearch']", zipCode.get(i),"input the zip code" , logger);

            //click on the search button
            Reusable_Classes_logger.click(driver,"//button[@class='btn spice-translated']","searcg button", logger);

            //wait for 3 secs
            Thread.sleep(3000);

            //click on the  link
            Reusable_Classes_logger.clickByIndex(driver, "//*[@class='location__top']", 4-i,"Clicking the link", logger);

            //Capture the studio name and address
            Reusable_Classes_logger.captureText(driver,"//*[@class='location']", "Studio name and address",logger );

            //Capture the weekly schedule
            Reusable_Classes_logger.captureText(driver,"//*[contains(@class,'meeting-schedule ')]", "Weekly schedule", logger);


        }//end of the for loop


    }//end of the test method


}//end of the java class