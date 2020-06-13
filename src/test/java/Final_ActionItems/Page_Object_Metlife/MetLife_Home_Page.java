package Final_ActionItems.Page_Object_Metlife;

import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Home_Page extends Abstract_class {

    ExtentTest logger;
    public MetLife_Home_Page(WebDriver driver){
     super();
        PageFactory.initElements(driver,this);
        this.logger=super.logger;
    }//end of constructor

    public MetLife_Home_Page SOLUTIONS(){
        Reusable_Classes_logger.mouseHover(driver,"//*[contains(text(),'SOLUTIONS')][1]", "Hover to SOLUTIONS",logger);
        return new MetLife_Home_Page(driver);
    }
    public MetLife_Home_Page MetLifeTakeAlong(){
        Reusable_Classes_logger.mouseClick(driver,"//*[contains(text(),'MetLife TakeAlong Dental')]","Click on MetLife TakeAlong Dental",logger);
        return new MetLife_Home_Page(driver);
    }//end of mouseClick on TakeAlong

}//end of java class
