public class ThrowsDemo {
    void division() throws ArithmeticException{
        int a=45, b=0,rs;
        rs=a/b;
        System.out.println("\nResult: "+rs);
    }
    public static void main(String[] args) {
        ThrowsDemo T=new ThrowsDemo();
        try{
            T.division();
        }
        catch(ArithmeticException ex){
            System.out.println("\nError: "+ex.getMessage());
        }
        System.out.println("End of program");
    }
}
