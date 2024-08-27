class Test
{
    int a,b;
    Test()
    {
        a=10;
        b=20;
    }
    void display(Test obj) //Method that returns current class instance passes object as a parameter
    {
        System.out.println("a="+obj.a+" b="+obj.b);
    }
    void get()
    {
        display(this);
    }
}

public class ThisClass4 
{
    public static void main(String[] args)
    {
        Test object=new Test();
        object.get();
    }
}
