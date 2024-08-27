//Write a program to find the factorial of a given number- default constructor

class Fact
{
    int num, result;
    Fact()    //default constructor
    {
        num=5;
        result=1;
    }
    public void factorial()
    {
        for(int number=1; number<=num; number++)
        {
            result*=number;
        }
        System.out.println(result);    
    }
}
class Factorial
{
    public static void main(String[] args)
    {
        Fact f1=new Fact();
        f1.factorial();
    }
}