package Page_Object_Metlife;

import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MetLife_Take_Along_PPO_Dental_Program extends Abstract_class {

    ExtentTest logger;

    public MetLife_Take_Along_PPO_Dental_Program(WebDriver driver){
        super();
        PageFactory.initElements(driver,this);
        this.logger=super.logger;
    }//end of constructor
    public MetLife_Take_Along_PPO_Dental_Program scrollToMiddle(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        logger.log(LogStatus.INFO,"Scroll To Middle of the page so we can have better better view of what it is clicking to");
        jse.executeScript("Scroll(0,4000)");
        return new MetLife_Take_Along_PPO_Dental_Program(driver);
    }//end of ScrollToMiddle


    public MetLife_Take_Along_PPO_Dental_Program CheckBoxClick(String dentalProgram){
        Reusable_Classes_logger.click(driver,"//*[@class='" + dentalProgram + "']","Clicking on the Chechbox",logger);
        return new MetLife_Take_Along_PPO_Dental_Program(driver);
    }//end of checkboxes

    public MetLife_Take_Along_PPO_Dental_Program EnrollInProgramNow(){
        Reusable_Classes_logger.click(driver,"//*[@id='tompenrolltab']","Click on Enroll In Program Now",logger);
        return new MetLife_Take_Along_PPO_Dental_Program(driver);
    }//end of Enroll In Program

    public MetLife_Take_Along_PPO_Dental_Program EnrollReferralCodeField(String referralCode){

        Reusable_Classes_logger.userKeys(driver,"//*input[@id='txtBxPromocode']",referralCode, "Entering the referral code Field",logger);
        return new MetLife_Take_Along_PPO_Dental_Program(driver);
    }//end of entering referral Code

    public MetLife_Take_Along_PPO_Dental_Program GoIconReferralPage(){
        Reusable_Classes_logger.click(driver,"//*button[@id='enrollgobtn']","Clicking on the Go Icon After Enttering the code",logger);
        return new MetLife_Take_Along_PPO_Dental_Program(driver);
    }//end of go Icon After entering the referral Code

    public MetLife_Take_Along_PPO_Dental_Program RedMessage(){
        Reusable_Classes_logger.captureText(driver,"//span[contains(text(),'Referral Code was not recognized')]","Capture the RedMessage",logger);
        return new MetLife_Take_Along_PPO_Dental_Program(driver);
    }//end of Capture the RedMessage

    public MetLife_Take_Along_PPO_Dental_Program EnrollWithoutRCode(){
        Reusable_Classes_logger.click(driver,"//*[@id='withoutrefcode']","click on enroll without Referral Code",logger);
        return new MetLife_Take_Along_PPO_Dental_Program(driver);
    }//end of Enroll Click without Referral Code


}//end of java class
