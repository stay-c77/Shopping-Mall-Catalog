/*Create a main class named GPA to prompt the user to enter his/her age and his GPA. 
The user application for a job will be rejected either if his age is greater than 25 years or his GPA is less than 2.5. 
You should declare two try-throw-catch blocks; one to handle the AgeOutOfRangeException and the other to handle the LowGpaException. 
If the user enters acceptable age and GPA, display the message "Your application is accepted and is under study" */

import java.util.Scanner;
class AgeOutOfRangeException extends Exception{
    public AgeOutOfRangeException(String s){
        super(s);
    }
}
class LowGpaException extends Exception{
    public LowGpaException(String s){
        super(s);
    }
}
class Gpa{
    void ageCheck(int age) throws AgeOutOfRangeException{
        if(age>25){
            throw new AgeOutOfRangeException("Age cannot be greater than 25");
        }
    }
    void gpaCheck(double gpa) throws LowGpaException{
        if(gpa<2.5){
            throw new LowGpaException("Gpa cannot be less than 2.5");
        }
    }
    public static void main(String[] args){
        Gpa g1=new Gpa();
        try{
            Scanner s=new Scanner(System.in);
            System.out.println("Enter name:");
            String name=s.nextLine();
            System.out.println("Enter age:");
            int age=s.nextInt();
            g1.ageCheck(age);
            System.out.println("Enter gpa:");
            double gpa=s.nextDouble();
            g1.gpaCheck(gpa);
            System.out.println("Your application is accepted and is under study");
        }
        catch(AgeOutOfRangeException e1){
            System.out.println("Exception: "+e1.getMessage());
        }
        catch(LowGpaException e2){
            System.out.println("Exception: "+e2.getMessage());
        }
    }
}