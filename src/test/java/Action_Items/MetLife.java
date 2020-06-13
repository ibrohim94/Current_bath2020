package Action_Items;

import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MetLife extends Abstract_class {






    @Test
    public void MetTife() throws InterruptedException {


        //declare the zipCode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("11235");
        zipCode.add("11204");

        //declare the array
        ArrayList<String> referralCode = new ArrayList<>();
        referralCode.add("6222");
        referralCode.add("4445");
        referralCode.add("1151");

        //define the dental program list
        ArrayList<String> dentalProgram = new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");

        //define the log info for navigate to the metLife
        logger.log(LogStatus.INFO, "navigate to metLife website");

        //navigate to the url
        driver.navigate().to("https://www.metlife.com");

        //put sleep time
        Thread.sleep(2500);
        System.out.println(driver.getTitle());

        //verify the title
        Reusable_Classes_logger.verifyTitle(driver, "Insurance and Employee Benefits | MetLife", logger);

        //click on solute button
        Reusable_Classes_logger.mouseHover(driver, "(//*[@class='header__navigation-container-menu-item-title font-eyebrow-1'])[1]", "Solution", logger);

        Thread.sleep(2000);


        //click the MetLife takeAlong dental from drop down
        Reusable_Classes_logger.click(driver, "//*[@href='/insurance/dental-insurance/takealongdental/']", "Dental", logger);
        Thread.sleep(2000);

        for (int i =0;i<zipCode.size();i++) {
            //click on enrol now
           // Reusable_Classes_logger.click(driver, "//*[@class='btn-brand-2nd table']", "enrol now", logger);
            Reusable_Classes_logger.click(driver, "//*[contains(text(),'Enroll Now')]", "enrol now", logger);
            Thread.sleep(5000);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            //handling the switching to the new tab
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(4000);

            //verify the title in new window
            Reusable_Classes_logger.verifyTitle(driver, "MetLife TakeAlong Dental – Dental Insurance", logger);

            //enter the zipCode
            Reusable_Classes_logger.userTypeAndHitEnter(driver, "//*[@class='form-control']", zipCode.get(i), "enter the zipCode and enter it", logger);
             //wait few secs
            Thread.sleep(2000);


            //click on the checkbox
            Reusable_Classes_logger.click(driver,"//*[@class='" + dentalProgram.get(i) + "']","Dental program",logger);

            //wait few secs
            Thread.sleep(2500);

            Reusable_Classes_logger.click(driver,"//*[@id='topenrolltab']","Enroll in Program",logger);

            Thread.sleep(1500);

            Reusable_Classes_logger.userTypeAndHitEnter(driver,"//input[@id='txtBxPromocode']",referralCode.get(i),"Referral Code",logger);

            //capture the error message
            Reusable_Classes_logger.captureText(driver,"//span[contains(text(),'Referral Code was not recognized')]","error message",logger);

            //Click on enroll without referral code
            Reusable_Classes_logger.click(driver, "//a[@class='btn btn-primaryborder']", "Enroll without referral code", logger);

            //wait few secs
            Thread.sleep(2500);

            //Capture the the text
            String programPage = Reusable_Classes_logger.captureText(driver, "//div[@class='col-sm-8']", "capturing the search result", logger);

            //split the final result
            String [] finaldentalResult= programPage.split(" ");

            //print out the search dental programs
            System.out.println("The search result is "+finaldentalResult[3]);

            //define the login information
            logger.log(LogStatus.INFO,"The search result is "+finaldentalResult[3]);


            //closing the window
            driver.close();

            //switch back to the parent window
            driver.switchTo().window(tabs.get(0));


        }//end of the for loop


    }

}//end of java class
