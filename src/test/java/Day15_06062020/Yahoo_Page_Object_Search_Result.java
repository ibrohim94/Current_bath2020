package Day15_06062020;

import Resuable_Classes.Abstract_class;
import Yahoo_Page_Object.Yahoo_Base_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Yahoo_Page_Object_Search_Result extends Abstract_class {
    @Test
    public void Yahoo_Search_Result() throws InterruptedException {
        logger.log(LogStatus.INFO,"navigate to Yahoo Home page");
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2500);
        Yahoo_Base_Class.yahoo_homePage().searchField("Cars");
        //click on search icon
        Yahoo_Base_Class.yahoo_homePage().searchIcon();
        Thread.sleep(2000);
        //scroll to the bottom of the page
        Yahoo_Base_Class.yahoo_search_result_page().scrollToBottom();
        //capture the result number from the bottom of the page
        Yahoo_Base_Class.yahoo_search_result_page().searchNumber();


    }//end of test method


}//end of java class