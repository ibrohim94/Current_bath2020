package Page_Object_Metlife;

import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Take_Along_Dental_Program_LastPage extends Abstract_class {

    ExtentTest logger;
    public MetLife_Take_Along_Dental_Program_LastPage(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger = super.logger;

    }//end of constructor

    public MetLife_Take_Along_Dental_Program_LastPage PPONameLastInfo(){
        String PPOINFO = Reusable_Classes_logger.captureText(driver,"//*[@class='col-sm-8']","PPO INFO",logger);
        String[] thePPOInfo = PPOINFO.split(" ");
        logger.log(LogStatus.INFO,"My PPO Info matches as " + PPONameLastInfo());
        return new MetLife_Take_Along_Dental_Program_LastPage(driver);
    }//end of the PPO Last Info


}//end of java class
