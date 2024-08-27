class Animal{
    Animal(){System.out.println("Animal is created");}
}
class Dog extends Animal{
    Dog(){
        super();  //super constructor
        System.out.println("Dog is created");
    }
}
public class TestSuper3 {
    public static void main(String[] args) {
        Dog d=new Dog();
    }
}
