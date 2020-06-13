package Yahoo_Page_Object;
import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Yahoo_HomePage extends Abstract_class {

    ExtentTest logger;

  //we need to create a constructor method that defines
    //driver and logger to be reuse localy to this page class
    public Yahoo_HomePage(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        //local page logger gets set to abstract class logger when you use it in
        //page object
        this.logger = super.logger;
    }//end of constructor

    //method for search field
    public Yahoo_HomePage searchField(String userValue) {

        Reusable_Classes_logger.userKeys(driver,"//*[@id='header-search-input']",userValue,"Search Field",logger);
        return new Yahoo_HomePage(driver);

    }//end of search field method

    //method for search icon
    public Yahoo_HomePage searchIcon() {

        Reusable_Classes_logger.click(driver,"//*[@id='header-desktop-search-button']","Click on Search Icon",logger);
        return new Yahoo_HomePage(driver);

    }//end of searchIcon method
}//end of java class
