import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator{
    int n1,n2;
    Calculator(int n1, int n2){
        this.n1=n1;
        this.n2=n2;
    }
    public void add(){
        try{
            if (n1<0 || n2<0) {
                throw new ArithmeticException("Error: Numbers cannot be negative");
            }
            System.out.println("Sum is "+(n1+n2));
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
    public void subtract(){
        try{
            if (n1<0 || n2<0) {
                throw new ArithmeticException("Error: Numbers cannot be negative");
            }
            System.out.println("Difference is "+(n1-n2));
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
    public void multiply(){
        try{
            if (n1==0 || n2==0) {
                throw new ArithmeticException("Error: Numbers cannot be zero");
            }
            System.out.println("Product is "+(n1*n2));
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }        
    }
    public void division(){
        try{
            if (n1==0 || n2==0) {
                throw new ArithmeticException("Error: Numbers cannot be zero");
            }
            System.out.println("Quotient is "+(n1/n2));
        }
        catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Lab {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter first number for addition: ");
            String a1 = scanner.nextLine();
            int add1=Integer.parseInt(a1);
            System.out.print("Enter second number for addition: ");
            String a2 = scanner.nextLine();
            int add2=Integer.parseInt(a2);
            System.out.print("Enter first number for subtraction: ");
            String s1 = scanner.nextLine();
            int sub1=Integer.parseInt(s1);
            System.out.print("Enter second number for subtraction: ");
            String s2 = scanner.nextLine();
            int sub2=Integer.parseInt(s2);
            System.out.print("Enter first number for multiplication: ");
            String m1 = scanner.nextLine();
            int mul1=Integer.parseInt(m1);
            System.out.print("Enter second number for multiplication: ");
            String m2 = scanner.nextLine();
            int mul2=Integer.parseInt(m2);
            System.out.print("Enter first number for division: ");
            String d1 = scanner.nextLine();
            int div1=Integer.parseInt(d1);
            System.out.print("Enter second number for division: ");
            String d2 = scanner.nextLine();
            int div2=Integer.parseInt(d2);
            Calculator c1 = new Calculator(add1, add2);
            Calculator c2 = new Calculator(sub1, sub2);
            Calculator c3 = new Calculator(mul1, mul2);
            Calculator c4 = new Calculator(div1, div2);
            c1.add();
            c2.subtract();
            c3.multiply();
            c4.division();
        }
        catch (NumberFormatException e) {
            System.out.println("Input has to be an integer");
        }
    }
}
