package Page_Object_Metlife;

import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Take_Along_Page_Enter_Data extends Abstract_class {

    ExtentTest logger;
    public MetLife_Take_Along_Page_Enter_Data(WebDriver driver){

        super();
        PageFactory.initElements(driver,this);
        this.logger=super.logger;
    }//end of constructor

    public MetLife_Take_Along_Page_Enter_Data EnterzipCodeField(String zipCodes){
        Reusable_Classes_logger.click(driver,"//*[@id='txtZipCode']","Enter zipCode",logger);
        return new MetLife_Take_Along_Page_Enter_Data(driver);
    }//end of entering zipCode

    public  MetLife_Take_Along_Page_Enter_Data EnterzipCode(String zipCode){
        Reusable_Classes_logger.click(driver,"//*[@id='txtZipCode']","Click in the ZipCode Field",logger);
        return new MetLife_Take_Along_Page_Enter_Data(driver);
    }//


    public MetLife_Take_Along_Page_Enter_Data GoIcon(){
        Reusable_Classes_logger.click(driver,"//*[@id='texZipCodetxt']","Go Icon",logger);
        return new MetLife_Take_Along_Page_Enter_Data(driver);
    }//end of Go Icon




}//end of java class
