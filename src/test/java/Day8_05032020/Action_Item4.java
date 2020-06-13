package Day8_05032020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Action_Item4 {

    public static void main(String[] args) throws InterruptedException {

               //set the chrome path
        System.setProperty("webdriver.chrome.driver", "src/Resource/chromedriver");
        //set some pre condition using ChromeOptions
        ChromeOptions options= new ChromeOptions();
        //set the argument  you want for the driver
        options.addArguments("incognito");
        //now simply define your chrome driver
        WebDriver driver = new ChromeDriver(options);


       //declare the zipCode
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("11235");
        zipCode.add("11204");

        //declare the array
        ArrayList<String > referralCode = new ArrayList<>();
        referralCode.add("6222");
        referralCode.add("4445");
        referralCode.add("1151");

        //define the dental program list
        ArrayList<String> dentalProgram = new ArrayList<>();
        dentalProgram.add("PPO-LOW");
        dentalProgram.add("PPO-MEDIUM");
        dentalProgram.add("PPO-HIGH");



        //navigate to MetLife
        driver.navigate().to("https://www.metlife.com");
        //wait few seconds
        Thread.sleep(3000);

        //maximize the browser
        driver.manage().window().maximize();
        //wait few seconds
        Thread.sleep(3500);


        String Title1 = driver.getTitle();
        if (Title1.equals("Insurance and Employee Benefits | MetLife")) {
            System.out.println("Title matches and the name of the Title is "+ Title1);
        }else{
            System.out.println("Title doesn't match and the name of the Title is "+ Title1);
        }//I match the title and print it out

         try{
         driver.findElement(By.xpath("(//*[@class='header__navigation-container-menu-item']) [1]")).click();
         }catch (Exception e) {
          System.out.println("Unable to click SOLUTIONS "+ e);
         }//I clicked on solutions

         try{
         driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
         }catch (Exception e) {
             System.out.println("unable to click MetLife TakeAlong Dental " + e);
         }//I clicked on MetLife TakeAlong Dental

        String Title2  = driver.getTitle();
         if (Title2.equals("MetLife TakeAlong Dental | MetLife")) {
             System.out.println("Title matches and the name of the Title is " + Title2);
         }else{
             System.out.println("Title doesn't matches and the name of the Title is " + Title2);
         }//matching the title2

        //wait 5 seconds
        Thread.sleep(5000);
         //I clicked on enrol now button
        //beginning of the for loop
         for(int i=0; i<zipCode.size();i++) {

         try{
         driver.findElement(By.xpath("//*[@class='btn-brand-2nd table']")).click();
         }catch (Exception e) {
          System.out.println("unable to click on the enrol now " + e);

    }//end of click to enrol now
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

    driver.switchTo().window(tabs.get(1));
    try {
        WebElement input = driver.findElement(By.xpath("//*[@id='txtZipCode']"));
       input.clear();
        input.sendKeys(zipCode.get(i));
    } catch (Exception e) {
        System.out.println("Unable to put zipcode "+e);
    }//end of enter zipCode
    try {
  driver.findElement(By.xpath("//*[@id='txtZipCodetxt']")).click();
    }catch (Exception e){
        System.out.println("unable to go button" + e);
    }//end of clicking on go button
             //wait 5 seconds
    Thread.sleep(5000);

    try {
        driver.findElement(By.xpath("//*[@class='"+dentalProgram.get(i)+"']")).click();
    }catch (Exception e){
        System.out.println("unable to click on check box " + e);
    }//end of clicking the dental program check box


    try{
        driver.findElement(By.xpath("//*[@id='topenrolltab']")).click();
    }catch (Exception e){
        System.out.println("Unable to click entering the dental program "+ e);
    }//end of click on search field of referral code
             //wait 6 seconds
    Thread.sleep(6000);

    try{
        driver.findElement(By.xpath("//*[@id='txtBxPromocode']")).sendKeys(referralCode.get(i));
    }catch (Exception e){
        System.out.println("unable to put the referral code " + e);
    }//end of entering referral code into search field
             //wait 3 seconds
     Thread.sleep(3000);

    try{
    driver.findElement(By.xpath("//*[@id='enrollgobtn']")).click();
    }catch (Exception e){
        System.out.println("Unable to click on go button " + e);
    }//end of clicking the go button after entering the referral code
             //wait 3 seconds
    Thread.sleep(3000);

    try{
        WebElement error= driver.findElement(By.xpath("//*[contains(text(),'Referral Code was not recognized')]"));
        System.out.println(error.getText());
    }catch (Exception e){
        System.out.println("unable to get the error message "+ e);
    }//end of capturing the error message
      try{
    driver.findElement(By.xpath("//*[@class='btn btn-primaryborder']")).click();
     }catch (Exception e){
    System.out.println("unable to proceed without referral code "+ e);
      }//end of clicking on proceed without referral code

      try {
    String message = driver.findElement(By.xpath("//*[@class='col-sm-8']")).getText();
    String[] arrayMessage= message.split(" ");
    System.out.println(message);
    if(dentalProgram.get(i).equals(arrayMessage[3])){
        System.out.println("Dental program matches and the name of the program is "+ arrayMessage[3]);
    }else{
        System.out.println("Dental program doesn't matche and the name of the program is "+ arrayMessage[3]);
    }//end of capturing dental program message

     }catch (Exception e){
    System.out.println("Unable to print the text " + e);
    }//end of printing the text

      driver.close();
      driver.switchTo().window(tabs.get(0 ));

    }//end of the for loop
        driver.quit();
      }//end of main method
   }//end of java class
