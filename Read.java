//Write a program to read an integer and display
import java.io.*;
import java.util.Scanner;
class Read
{
    public static void main(String[] args)
    {
        int num;
        System.out.println("Enter the integer:");
        Scanner s=new Scanner(System.in);
        num=s.nextInt();
        System.out.println("Entered integer is "+num);
    }
}
