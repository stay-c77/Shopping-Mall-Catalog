public class ThrowDemo {
    public static void main(String[] args) {
        int a=45, b=0, rs;
        try{
            if (b==0){
                throw(new ArithmeticException("Can't divide by 0"));
            }
            else{
                rs=a/b;
                System.out.println("\nThe result is "+rs);
            }
        }
        catch(ArithmeticException ex){
            System.out.println("\nError: "+ex.getMessage());
        }
        System.out.println("End of program");
    }
}
