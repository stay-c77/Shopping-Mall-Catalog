import java.util.Scanner;
class InvalidTimeException extends Exception{
    public InvalidTimeException(String s){
        super(s);
    }
}

class Tutorial8 {
    public static void main(String[] args){
        Tutorial8 t=new Tutorial8();
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter hours:");
            int h=sc.nextInt();
            if(h<0 || h>=24){
                throw new InvalidTimeException("Invalid hours");
            }
            System.out.println("Enter minutes:");
            int m=sc.nextInt();
            if(m<0 || m>=60){
                throw new InvalidTimeException("Invalid minutes");
            }
            System.out.println("Enter seconds:");
            int s=sc.nextInt();
            if(s<0 || s>=60){
                throw new InvalidTimeException("Invalid seconds");
            }
            System.out.println("Time is successfully entered");
        }
        catch(InvalidTimeException e){
            System.out.println("Exception: "+e.getMessage());
        }
    }
}
