package Day2_04122020;

public class ActionItems_While_loop {


    public static void main(String[] args) {


        //declare string dynamic array variables

        String[] zipCode;

        //declare integer dynamic array variables

        int[] streetNumber;

        //define the dynamic array with the length (size) of that variable


        zipCode = new String[5];
        zipCode[0] = "11220";
        zipCode[1] = "11221";
        zipCode[2] = "11222";
        zipCode[3] = "11223";
        zipCode[4] = "11224";


        //declare the integer dynamic array

        streetNumber = new int[5];
        streetNumber[0] = 58;
        streetNumber[1] = 98;
        streetNumber[2] = 103;
        streetNumber[3] = 179;
        streetNumber[4] = 200;

         // while loop is more of broken down into statements

          int i = 0;
          while (i < streetNumber.length) {


            //print all value for zipCode
            System.out.println("My zipCode is " + zipCode[i] + " and my street number is  " + streetNumber[i]);

            i = i + 1;

            // incrementation and you put this at the end of you statement


        }// end of while loop

    }//end of main method


     }//end of java class
