package Day3_04182020;

public class if_else_with_operators {

    public static void main(String[] args) {



            //scenario is if student grade is 90 to 100 then it's A
            //if student grade is 80 to below 90 then it's B
            //if student grade is 70 to below 80 then it's C
            //if anything below C is failure (F)

            //define a variable which will represent grade number
            int grade = 95;


            //&&represents and operator in java
            if (grade >= 90 && grade <= 100) {
                System.out.println("Students grade is A");

            }else if (grade >= 80 && grade <90)  {
                System.out.println("Studets grade is B");

            }else if (grade >=80 && grade < 80)  {
                System.out.println("Student grade is C");

            }else if (grade >=70 && grade <70) {
                System.out.println("Student grade is F ");

            }//end of conditional statements



    }//end of main method


    }//end of java class
