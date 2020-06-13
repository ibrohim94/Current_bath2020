package Day16_06072020;

import java.util.ArrayList;

public class Letter_vowel {

    public static void main(String[] args) {

        //defining the array for letters
        ArrayList<String > letters= new ArrayList<>();
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");
        letters.add("e");


        for(int i=0; i<letters.size();i++){

            if(letters.get(i).equals("a")||letters.get(i).equals("e")){
                System.out.println("The letter is "+letters.get(i)+" which is vowel");
            }else{
                System.out.println("The letter is "+letters.get(i)+" which is consonant");
            }//end of the if-else condition

        }//end of the for loop

    }//end of the main method

}//end ot the java class
