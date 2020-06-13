package Page_Object_Metlife;

import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Take_Along_Page extends Abstract_class {

    ExtentTest logger;

    public MetLife_Take_Along_Page(WebDriver driver){

     super();
        PageFactory.initElements(driver,this);
     this.logger = super.logger;
    }//end of constructor

    public MetLife_Take_Along_Page ENROLL_NOW(){
        Reusable_Classes_logger.click(driver,"//*[contains(text(),'Enroll Now')]","Click on Enroll now",logger);
        return new MetLife_Take_Along_Page(driver);
    }//end of click on enroll now



}//end of java class
