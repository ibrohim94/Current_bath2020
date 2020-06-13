package Page_Object_Metlife;

import Resuable_Classes.Abstract_class;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Base_Class extends Abstract_class {
    public MetLife_Base_Class(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
    }//end of constructor

    public static MetLife_Home_Page metLife_home_page(){
        MetLife_Home_Page metLife_home_page = new MetLife_Home_Page(driver);
      return metLife_home_page;
    }//end of object reference  for MetLife home Page

    public static MetLife_Take_Along_Page metLife_take_along_page(){
        MetLife_Take_Along_Page metLifeTakeAlongPage = new MetLife_Take_Along_Page(driver);
        return metLifeTakeAlongPage;
    }//end of

    public static MetLife_Take_Along_Page_Enter_Data metLife_take_along_page_enter_data(){
        MetLife_Take_Along_Page_Enter_Data metLife_take_along_page_enter_data = new MetLife_Take_Along_Page_Enter_Data(driver);
        return metLife_take_along_page_enter_data;
    }// end of entering the zipCode

    public static MetLife_Take_Along_PPO_Dental_Program metLife_take_along_ppo_dental_program(){
        MetLife_Take_Along_PPO_Dental_Program metLife_take_along_ppo_dental_program = new MetLife_Take_Along_PPO_Dental_Program(driver);
        return metLife_take_along_ppo_dental_program;
    }//end of PPO program


    public static MetLife_Take_Along_Dental_Program_LastPage metLife_take_along_dental_program_lastPage(){
        MetLife_Take_Along_Dental_Program_LastPage metLife_take_along_dental_program_lastPage = new MetLife_Take_Along_Dental_Program_LastPage(driver);
        return  metLife_take_along_dental_program_lastPage;
    }//end of dentall program

    public static MetLife_Base_Class metLife_base_class(){
        MetLife_Base_Class metLife_base_class = new MetLife_Base_Class(driver);
        return metLife_base_class;
    }//end of base class


}//end of java class
