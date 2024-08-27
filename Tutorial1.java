//T1: Check if number is prime
import java.util.Scanner;
class IsPrime
{
    int num;
    public void getInput()
    {
        System.out.println("Enter number:");
        Scanner s=new Scanner(System.in);
        num=s.nextInt();
    }
    public int check()
    {
        for(int i=2;i<num;i++)
        {
            if(num%i==0)
            {
                return 0;
            }
        }
        if (num==1)
        {
            return 0;
        }
        return 1;
    }
}
class Tutorial1
{
    public static void main(String[] args)
    {
        int r;
        IsPrime t1=new IsPrime();
        t1.getInput();
        r=t1.check();
        if(r==1)
        {
            System.out.println((t1.num)+" is prime"); 
        }
        else
        {
            System.out.println((t1.num)+" is not prime");
        }
    }
}