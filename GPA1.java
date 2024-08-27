import java.util.Scanner;

 

class AgeOutOfRangeException extends Exception {

    public AgeOutOfRangeException(int age) {

        super("You are older than the requested age (25 years), you are " + age + "!!!");

    }

}

 

public class GPA1 {

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        System.out.println("Enter age: ");

        int age = s.nextInt();

 

        try {

            if (age > 25) {

                throw new AgeOutOfRangeException(age);

            }

            else

            {

                System.out.println("Age is less than 25");

            }

            // Continue with the rest of your code here

        } catch (AgeOutOfRangeException e) {

            System.out.println("Age Exception: " + e.getMessage());

        }

    }

}

