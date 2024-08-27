//this keyword: reference variable that refers to the current object
class Test
{
    int a, b;
    //default
    Test()
    {
        this(10,20);  //default calls parameterized
        System.out.println("Inside default constructor"); 
    }
    //parameterized
    Test(int a, int b)
    {
        this.a=a;   //to avoid ambiguity
        this.b=b;
        System.out.println("Inside parameterized constructor"); 
    }
    void display()
    {
        System.out.println("a="+ a +" b="+ b); 
    }
}
public class ThisClass3
{
    public static void main(String[] args)
    {
        Test object=new Test();
        object.display();
    }
}
