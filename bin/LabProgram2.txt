/*Program 2: Create an exception class named AgeOutOfRangeException extended from the class Exception. 
This class should contain a constructor which takes the user’s age (ex. 40) as parameter. 
Will print following message when called, "You are older than the requested age (25 years), you are 40!!!” */

import java.util.Scanner;

class AgeOutOfRangeException1 extends Exception{
    public AgeOutOfRangeException1(int age){
        super("You are older than the requested age (25 years), you are " + age + "!!!");
    }
}
public class LabProgram2 {
    public static void main(String[] args){
        LabProgram2 l=new LabProgram2();
        try{
            Scanner s=new Scanner(System.in);
            System.out.println("Enter age:");
            int age=s.nextInt();
            if(age>25){
                throw new AgeOutOfRangeException1(age);
            }
        }
        catch(AgeOutOfRangeException1 e1){
            System.out.println("Exception: "+e1.getMessage());
        }
    }
}
