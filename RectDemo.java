class Rect
{
    int len, wid;
    boolean isFilled;

    public Rect(int l, int w, boolean isF)
    {
        len=l;
        wid=w;
        isFilled=isF;
    }
}
public class RectDemo
{
    public static void main(String[] args)
    {
        Rect r1=new Rect(6,6,false);
        System.out.println(r1.len);
    }
}
