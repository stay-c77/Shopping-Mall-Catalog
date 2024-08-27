class Cat          //qstn aboutt polymorphism explain method overriding
{
    final public void Sound()  //final to prevent overriding  so error
    {
        System.out.println("meow");
    }
}

/* Method overriding rules */
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
        Lion l1=new Lion();
        l1.sniff();
        l1.Sound();
    }
}
