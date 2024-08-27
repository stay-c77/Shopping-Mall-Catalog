class Animal{
    String color="White";
}
class Dog extends Animal{
    String color="Black";
    void printColor(){
        System.out.println(color);
        System.out.println(super.color); //super instance variable
    }
}
class TestSuper1 {
    public static void main(String[] args) {
        Dog d=new Dog();
        d.printColor();
    }
}
