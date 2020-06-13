package Yahoo_Page_Object;

import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_Search_Result_Page extends Abstract_class {

    ExtentTest logger;

    public Yahoo_Search_Result_Page(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;

    }//end of constructor method

    public Yahoo_Search_Result_Page scrollToBottom(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        logger.log(LogStatus.INFO,"Scrolling to the bottom of the Yahoo Search Result page");
        jse.executeScript("scroll(0,10000)");
        return new Yahoo_Search_Result_Page(driver);

    }//end of scroll method

    //method to capture the Search number
    public Yahoo_Search_Result_Page searchNumber(){
        String searchResult = Reusable_Classes_logger.captureText(driver,"//*[@class='compPagination']","Search Result",logger);
        String[] searchNumber = searchResult.split("Next");
        //it will only count from right from Next as it is in the page. anything after next is 0 and 1 will be out result we looking for
        logger.log(LogStatus.INFO,"My Search Number is " + searchNumber[1]);

        return new Yahoo_Search_Result_Page(driver);

    }//end of capture result


}//end of java class
