package Yahoo_Page_Object;

import Resuable_Classes.Abstract_class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.security.Policy;

public class Yahoo_Base_Class extends Abstract_class {
    public Yahoo_Base_Class(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        //local page logger gets set to abstract class logger when you use it in page object concept

    }//end of constructor

    //crete a new name to refer to the actual page class
    //object/method for yahoo homepage
    //just making it lower case and making it static so that i will be using it over and over anywhere i need it
    public static Yahoo_HomePage yahoo_homePage(){
        Yahoo_HomePage yahoo_homePage = new Yahoo_HomePage(driver);
        return yahoo_homePage;
    }//end of yahoo home home page////end of new name for home page or he wrote // end of object reference for yahoo homepage

    //object/method for yahoo search result page
    public static Yahoo_Search_Result_Page yahoo_search_result_page(){
        Yahoo_Search_Result_Page yahoo_search_result_page = new Yahoo_Search_Result_Page(driver);
        return yahoo_search_result_page;

    }//end of object reference for search result page

}//end of java class