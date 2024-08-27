public class Bus 
{
    final int SPEED=70; //final variable
    void change()
    {
        SPEED=50;
    }
    public static void main(String[] args) 
    {
        Bus b=new Bus();
        b.change();    
    }
}
