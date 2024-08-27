class Cat          //qstn aboutt polymorphism explain method overriding
{
    public void Sound()
    {
        System.out.println("meow");
    }
}


class Lion extends Cat
{
    public void sniff()
    {
        System.out.println("sniff");
    }
    public void Sound()
    {
        System.out.println("roar");
    }    
}
class x extends Lion
{
    public static void main(String[] args)
    {
        System.out.println("in main");
    }
}
