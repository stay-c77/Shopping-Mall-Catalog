class Animal    //check later
{ 
    int name;
    private void eating(){
        System.out.println("eating");
    }
}
class Dog extends Animal{
    public static void main(String[] args)
    {
        System.out.println("Barking");
    }
}