//this keyword: reference variable that refers to the current object
class Test
{
    int a, b;
    Test(int a, int b)
    {
        a=a;
        b=b;
    }
    void display()
    {
        System.out.println("a="+ a +" b="+ b); //system gets confused between the 2 a's and 2 b's- ambiguity
    }
}
public class ThisClass
{
    public static void main(String[] args)
    {
        Test object=new Test(10,20);
        object.display();
    }
}
