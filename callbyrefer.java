
public class callbyrefer
{
    static void display(int[] x)
    {
        int temp;
        temp=x[0];
        x[0]=x[1];
        x[1]=temp;
        System.out.println("In the function, "+x[0]+" "+x[1]);
    }
    public static void main(String[] args)
    {
        int a[]={0,0};
        for(int i=0; i<2; i++)
        {
            a[i]=(i+1);
        }
        System.out.println(a[0]+ " "+ a[1]);
        display(a);
        System.out.println(a[0]+ " "+ a[1]);
    }
}
