//Write a program to find the factorial of a given number- parameterized constructor

class Fact
{
    int num, result;
    Fact(int n, int f)    //parameterized constructor
    {
        num=n;
        result=f;
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
        Fact f1=new Fact(10,1);
        f1.factorial();
    }
}