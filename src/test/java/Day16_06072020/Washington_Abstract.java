package Day16_06072020;

import Day2_04122020.While_loop;
import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Washington_Abstract extends Abstract_class {


    @Test
    public void washington() {
        logger.log(LogStatus.INFO, "navigating to washington website");
        driver.navigate().to("https://faculty.washington.edu/chudler/java/boxes.html");


    int i=0;
    while (i<101){

            if (i%5!=0) {
                Reusable_Classes_logger.clickByIndex(driver,"//*[@type='checkbox']",i,"Click the Checkbox",logger);
            }
            i++;

        }//end of the for loop
    }//end of the test annotation
}//end of the java class
