package Day16_06072020;

import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Action_Item extends Abstract_class {

    @Test
    public void yahoo() throws InterruptedException {

        logger.log(LogStatus.INFO, "navigating to yahoo website");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2500);

        Reusable_Classes_logger.userTypeAndHitEnter(driver, "//*[@id='header-search-input']", "QA", "input and go", logger);
        Reusable_Classes_logger.click(driver, "//*[contains(text(),'Wikipedia')]", "clicking wikipedia", logger);
        logger.log(LogStatus.INFO, "switching to the new window");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());

        Boolean phrase = driver.findElement(By.xpath("//*[contains(text(),'Middle Ages')]")).isDisplayed();

        if (phrase = true) {
            logger.log(LogStatus.PASS, "The phrase exists");
            System.out.println("The phrase exists");
        } else {
            logger.log(LogStatus.FAIL, "Phrase doesn't exist");
            System.out.println("Phrase doesn't exist");
        }


        //logger.log(LogStatus.INFO,"Switching ");


    }


}//end of java class
