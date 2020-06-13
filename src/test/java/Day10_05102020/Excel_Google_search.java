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

public class Excel_Google_search {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {
        //Step 1:
        //locate the readable file path
        Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/Google_Search.xls"));

        //Step 2:
        //locate the readable worksheet  by index
        Sheet readableSheep = readableFile.getSheet(0);

        //Step 3:
        // we need create a writable workbook to mimic readable file because we shouldn't be writing on readable file
        WritableWorkbook WritableFile = Workbook.createWorkbook(new File("src/Resource/Google_search_Result.xle"),readableFile);
        //create writable sheet
        WritableSheet wSheet = WritableFile.getSheet(0);
        //get the total rows that are not empty
        int rows = wSheet.getRows();

        //define the web driver using resuable library
        WebDriver driver = Reusable_Library.setDriver();


        //define the for loop
        for (int i = 1; i < rows; i++) {


            //Step 4:
            //store the cars column value as a String variable
            //column are always hard coded whereas the rows are dynamic based on your i
            String cars = wSheet.getCell(0, i).getContents();

            //navigate to google page
            driver.navigate().to("https://www.google.com");
            //timeout
            Thread.sleep(2500);

            //reusable library to enter car values on search field
            Reusable_Library.userKeys(driver, "//*[@name='q']", cars, "search Field");

            //reusable library to click on google search
            Reusable_Library.submit(driver, "//*[@name='btnK']", "Google search");

            //timeout
            Thread.sleep(2500);

            String result = Reusable_Library.captureText(driver, "//*[@id='result-stats']", "search Result");
            String[] resultArray = result.split(" ");
            System.out.println("My search number is " + resultArray[1]);


            //Step 5:
            //Write the search number result back to writable sheet
            Label label = new Label(1, i, resultArray[1] + " " + resultArray[3] + " " + resultArray[4]);
            //adding back to writable cell
            wSheet.addCell(label);


        }//end of loop


        //outside of the loop we need to write and close the excel
        WritableFile.write();
        WritableFile.close();
        readableFile.close();

        //quit the driver
        driver.quit();

    }//end of main method

}//end of java class
