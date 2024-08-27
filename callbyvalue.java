class swap
{
    int temp;
    swap(int x, int y)
    {
        temp=x;
        x=y;
        y=temp;
        System.out.println("x is "+x+" y is "+y);
    }
    
}
public class callbyvalue 
{
    public static void main(String[] args)
    {
        int a,b;
        a=10;
        b=20;
        System.out.println("a is "+ a+ " b is "+ b);
        swap s=new swap(a,b);
        System.out.println("a is "+a +" b is "+ b);
    }
}
