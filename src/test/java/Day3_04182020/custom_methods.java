package Day3_04182020;

public class custom_methods {

    //purpose of these user defined custom methods so that i can reuse it again and again
    //and call it on my main method when i need to use them


    // user defined customer will be created here

    //lets create one for void first
    //void method only execute on your statements
    public static void  voidAdd(int a, int b) {
        int result = a+b;
        System.out.println("My addition result is " + result );

    }//end of method

    //create same method as return method
    //return method execute your statements as well as returns you the result you want
    public static int returnAdd(int a, int b) {
        int result = a+b;
        System.out.println("My addition result is " + result);
        return result; //wil return the result c


    }//end of return method


}//end of java class
