import Resuable_Classes.Abstract_class;
import Resuable_Classes.Reusable_Classes_logger;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Kayak_Data_Driven_TestNG extends Abstract_class {
    //when using annotation method your local driver
    //must be declared outside so i can call it
    //on all my annotation method

    //readable workbook
    Workbook readableFile;
    //readable sheet
    Sheet readableSheet;
    //writable workbook
    WritableWorkbook writableFile;
    //writable sheet
    WritableSheet wSheet;
    //initiate row count
    int row;


    @Test
    public void kayakSearch() throws InterruptedException, WriteException, IOException, BiffException {
        //define the path of readable file
        readableFile = Workbook.getWorkbook(new File("src/main/java/Excel/Kayak_Search.xls"));
        //define readable sheet
        readableSheet = readableFile.getSheet(0);
        //define the path to create writable file
        writableFile = Workbook.createWorkbook(new File("src/main/java/Excel/Kayak_Search_Results.xls"), readableFile);
        //define the writable sheet
        wSheet = writableFile.getSheet(0);
        //get all visible row count
        row = wSheet.getRows();


        logger.log(LogStatus.INFO, "Navigating to Kayak website");
        for (int i = 1; i < 2; i++) {
            //navigating to kayak
            driver.navigate().to("https://www.kayak.com");
            Thread.sleep(2000);

            //click on Search field
            Reusable_Classes_logger.click(driver, "//*[contains(@id,'pickup-field')]", "Search Filed", logger);
            //enter keyword on search field
            String airports = wSheet.getCell(0, i).getContents();
            Reusable_Classes_logger.userKeys(driver, "//*[@name='pickup']", airports, "Search Field", logger);

            //click on car result item as first one
            Reusable_Classes_logger.click(driver, "//*[@class='item-info']", "Car Result", logger);

            //click on drop off
            Reusable_Classes_logger.click(driver, "//*[@data-placeholder='Drop-off']", "Drop-off Date", logger);
            Thread.sleep(2000);


            //enter pick up date
            String dropOffDate = wSheet.getCell(3, i).getContents();
            Reusable_Classes_logger.userTypeAndHitEnter(driver, "//*[contains(@id,'dropoff-date-input')]", dropOffDate, "Drop-off Date", logger);
            Thread.sleep(2000);
            //click somewhere outside
            Reusable_Classes_logger.click(driver, "//*[@class='title dark']", "Text Content", logger);

            //click on drop off time
            Thread.sleep(1000);
            Reusable_Classes_logger.click(driver, "//*[contains(@id,'end-time-select')]", "Drop off Time", logger);

            //choose drop off up time
            Thread.sleep(2000);


            String dropOffTime = wSheet.getCell(4, i).getContents();
            Reusable_Classes_logger.mouseClick(driver, "//*[contains(@id,'end-time-select-option') and @data-title='" + dropOffTime + "']", "Choose Drop-off Time", logger);

            //click on pick up date
            Reusable_Classes_logger.click(driver, "//*[@data-placeholder='Pick-up']", "Pick-up Date", logger);
            Thread.sleep(2000);
            //enter pick up date
            String pickupDate = wSheet.getCell(1, i).getContents();
            Reusable_Classes_logger.userTypeAndHitEnter(driver, "//*[contains(@id,'pickup-date-input')]", pickupDate, "Pick-up Date", logger);
            //click somewhere outside
            Reusable_Classes_logger.click(driver, "//*[@class='title dark']", "Text Content", logger);

            //choose pick up time
            Thread.sleep(2000);
            String pickupTime = wSheet.getCell(2, i).getContents();
            Reusable_Classes_logger.mouseClick(driver, "//*[contains(@id,'start-time-select-option') and @data-title='" + pickupTime + "']", "Choose Drop-off Time", logger);

            //click on search icon
            Reusable_Classes_logger.click(driver, "//*[@title='Search cars']", "Search Icon", logger);
            Thread.sleep(4000);
            //click on vehicle size checkbox
            String vehicleSize = wSheet.getCell(5, i).getContents();
            Reusable_Classes_logger.click(driver, "//div[text()='" + vehicleSize + "']", "Vehicle Size Checkbox", logger);

            //click on second View Deal button
            Thread.sleep(5000);
            Reusable_Classes_logger.clickByIndex(driver, "//*[text()='View Deal']", 1, "View Deal", logger);
            Thread.sleep(3000);
            ArrayList<String> list = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window(list.get(1));
            Thread.sleep(2000);
            String result = Reusable_Classes_logger.captureText(driver, "//*[contains(@class,'bui-panel') or @class='search' or @class='booking-section' or @class='addressGrid']", "Car Info", logger);
            Label label = new Label(6, i, result);
            wSheet.addCell(label);
            driver.close();
            driver.switchTo().window(list.get(0));

            driver.manage().deleteAllCookies();
        }//end of for loop
        writableFile.write();
        writableFile.close();
        readableFile.close();
        //driver.quit();
        //because you have called it to ur abstract

    }//end of Kayak test



}//end of the java class