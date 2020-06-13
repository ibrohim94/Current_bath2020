package Action_Items;

import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class googleSearch extends Abstract_class {

    @Test
    public void googleSearch() throws InterruptedException{

        //define the array list for country
        ArrayList<String> country= new ArrayList<>();
        country.add("America");
        country.add("China");
        country.add("Uzbekistan");

        //defining the login info for the browser
        logger.log(LogStatus.INFO,"Navigating to google browser");

        //navigate to google browser
        driver.navigate().to("https://www.google.com");
        //wait few secs
        Thread.sleep(2500);

        for(int i=0; i<country.size();i++){
            //entering the value inside the search box and hit submit
            Reusable_Classes_logger.userTypeAndHitEnter(driver,"//*[@name='q']",country.get(i),"insert variable and hit enter",logger);

            //wait few secs
            Thread.sleep(3000);

            //define the variable to capture the search results
            String searchResult=  Reusable_Classes_logger.captureText(driver,"//*[@id='result-stats']","Searh result", logger);

            //Split the final result
            String[] actualNumber= searchResult.split(" ");

            //printing  the desired search result
            System.out.println("The search result of "+country.get(i)+"is "+actualNumber[1]);

            //define the log information for the output
            logger.log(LogStatus.INFO,"The search result of "+country.get(i)+"is "+actualNumber[1]);

        }//end of the for loop

    }//end of the test method

}//end of the java class
