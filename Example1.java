public class Example1 {
    public static void main(String[] args) {
        int num1, num2;
        try{
            num1=0;
            num2=62/num1;
            System.out.println(num2);
            System.out.println("Hey, I'm at the end of try block");
        }
        catch(ArithmeticException e){
            System.out.println("You cannot divide a number by zero");
        }
        catch(Exception e){
            System.out.println("Exceptions occurred");
        }
        System.out.println("I'm out of try-catch block");
    }
}
