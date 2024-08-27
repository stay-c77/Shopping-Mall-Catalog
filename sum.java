//Find the sum of 2 user inputed number
import java.io.*;
import java.util.Scanner;
class Sum
{
    int num1, num2, result;
    Sum(int n1, int n2)
    {
        num1=n1;
        num2=n2;
    }
    public void sum()
    {
        result=num1+num2;
        System.out.println("Result is "+result);
    }
}
class Result
{
    public static void main(String[] args)
    {
        int num1, num2;
        System.out.println("Enter the first integer:");
        Scanner s1=new Scanner(System.in);
        num1=s1.nextInt();
        System.out.println("Enter the second integer:");
        Scanner s2=new Scanner(System.in);
        num2=s2.nextInt();
        Sum s=new Sum(num1, num2);
        s.sum();
    }
}
