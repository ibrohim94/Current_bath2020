package Day10_05102020;

import Resuable_Classes.Reusable_Library;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Action_Item_Express {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {

        //locate the readable path
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/Action_Item_Express1111.xls"));
        //locate the readable worksheet by index
        Sheet readableSheet = readableFile.getSheet(0);

        // we need create a writable workbook to mimic readable file so we don't have to writing on readable file
        WritableWorkbook WritableFile = Workbook.createWorkbook(new File("src/Resource/Action_Item_Express1111_RESULT.xls"),readableFile);

        //create writable sheet
        WritableSheet wSheet = WritableFile.getSheet(0);

        //get the rows that are not empty
        int rows = wSheet.getRows();

        //define the web driver  by using the reusable library
        WebDriver driver = Reusable_Library.setDriver();

        //define the for loop
        for (int i = 1; i < rows; i++) {

            String size = wSheet.getCell(0,i).getContents();
            String quantity = wSheet.getCell(1,i).getContents();
            String firstName = wSheet.getCell(2,i).getContents();
            String lastName = wSheet.getCell(3,i).getContents();
            String email = wSheet.getCell(4,i).getContents();
            String phoneNumber = wSheet.getCell(5,i).getContents();
            String streetAdd = wSheet.getCell(6,i).getContents();
            String postalCode = wSheet.getCell(7,i).getContents();
            String city = wSheet.getCell(8,i).getContents();
            String State = wSheet.getCell(9,i).getContents();
            String creditCardNumber = wSheet.getCell(10,i).getContents();
            String expirtationMonth = wSheet.getCell(11,i).getContents();
            String expirationYear = wSheet.getCell(12,i).getContents();
            String cvvCode = wSheet.getCell(13,i).getContents();

         driver.navigate().to("https://www.Express.com");

          driver.manage().window().maximize();

          Thread.sleep(2000);

          Reusable_Library.Hover(driver,"//*[@href='/womens-clothing']  [1]","Hover over the Women");

          Reusable_Library.click(driver,"//*[@href='/womens-clothing/dresses/cat550007'] [1]", "Click on dresses");

          Thread.sleep(2000);

          Reusable_Library.click(driver,"//*[@class='_1ddDj _136PD'] [1]","Click on dress");

          Thread.sleep(2000);

          Reusable_Library.click(driver,"//span[text()='"+ size +"']","Size selection");

          Thread.sleep(2000);

          Reusable_Library.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _3yOD6 _1Qp1L _2veMA']","Click on add to bag");

           Thread.sleep(2000);

           Reusable_Library.Hover(driver,"(//*[@class='_2CsVP svg-icon--shopping-bag'])[2]", "Hover over the view bag");

           Reusable_Library.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ'] [1]", "Click on VIEW BAG & CHECK OUT");

           Thread.sleep(2000);

           Reusable_Library.dropdownByText(driver,"//*[@id='qdd-0-quantity']",quantity,"VIEW THE DROPDOWN");

           Thread.sleep(2000);

           Reusable_Library.click(driver,"//*[@id='continue-to-checkout']","click on check out");

           Thread.sleep(2000);

           Reusable_Library.click(driver,"(//*[@class='btn _9yfmt _194FD _2tFXQ'])[3]","Click on continue as a guess");

           Thread.sleep(2000);

           Reusable_Library.userKeys(driver,"//*[@name='firstname']",firstName,"Enter firstName");


           Thread.sleep(2000);

           Reusable_Library.userKeys(driver,"//*[@name='lastname']",lastName,"Enetr lastName");
           Thread.sleep(2000);

           Reusable_Library.userKeys(driver,"(//*[@name='email'])[1]", email,"enter email");

           Thread.sleep(2000);

           Reusable_Library.userKeys(driver,"//*[@name='confirmEmail']",email,"enter email");

           Thread.sleep(2000);

           Reusable_Library.userKeys(driver,"//*[@type='tel']",phoneNumber,"enter phone number");

           Thread.sleep(2000);

           Reusable_Library.click(driver,"//*[@type='submit'][1]","click on continue button");

           Thread.sleep(2000);

           Reusable_Library.userKeys(driver,"//*[@name='shipping.line1']",streetAdd,"enter street address");

           Thread.sleep(2000);

           Reusable_Library.userKeys(driver,"//*[@name='shipping.postalCode']",postalCode,"enter zippcode");

           Thread.sleep(2000);

           Reusable_Library.userKeys(driver,"//*[@name='shipping.city']",city,"enter city");

           Thread.sleep(2000);

           Reusable_Library.dropdownByText(driver,"//*[@name='shipping.state']",State,"View the states");

            Thread.sleep(2000);

           Reusable_Library.click(driver,"//*[@class='btn _9yfmt _194FD _2tFXQ _2SogC']","click on continue button");

           Thread.sleep(2000);

           Reusable_Library.click(driver,"//span[contains(text(),'Continue')]","click on continue button");

            Thread.sleep(2000);

           Reusable_Library.userKeys(driver,"//*[@id='creditCardNumberInput']", creditCardNumber,"enter credit card numbers");

            Thread.sleep(2000);

           Reusable_Library.dropdownByText(driver,"//*[@name='expMonth']", expirtationMonth,"enter the experation month");

            Thread.sleep(2000);

           Reusable_Library.dropdownByText(driver,"//*[@id='rvndd--expYear--6']",expirationYear,"enter expiration year");

            Thread.sleep(4000);

           Reusable_Library.userKeys(driver,"//*[@name='cvv']", cvvCode,"enter cvvCode");

            Thread.sleep(4000);

           Reusable_Library.click(driver,"(//*[@type='submit'])[1]","click on place order");

            Thread.sleep(2000);

           String errormessage = Reusable_Library.captureText(driver,"//*[@id='rvn-note-NaN']","capture the error message");

           //print the errorMessage
            System.out.println("The ErrorMessage is  " +  errormessage);

            //define the label
            Label label = new Label(14,i,errormessage);
            wSheet.addCell(label);

            //delete the cookies
            driver.manage().deleteAllCookies();


        }//end of for loop

        WritableFile.write();
        WritableFile.close();
        readableFile.close();

        //quit
        driver.quit();


    }//end of main method


}//end of java
