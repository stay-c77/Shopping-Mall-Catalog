abstract class MyTest{
    int a, b;
    public void getData(int x, int y){
        a=x;
        b=y;
    }
    abstract void calculate();
}
class Addition extends MyTest{
    void calculate(){
        System.out.println("Sum is "+(a+b));
    }
}
class Subtraction extends MyTest{
    void calculate(){
        System.out.println("Difference is "+(a-b));
    }
}
class Multiplication extends MyTest{
    void calculate(){
        System.out.println("Product is "+(a*b));
    }
}
public class MyAbstractClass {
    public static void main(String[] args) {
        Addition a=new Addition();
        Subtraction s=new Subtraction();
        Multiplication m=new Multiplication();
        a.getData(3, 4);
        a.calculate();
        s.getData(3, 4);
        s.calculate();
        m.getData(3, 4);
        m.calculate();
        m.show();
    }
}
