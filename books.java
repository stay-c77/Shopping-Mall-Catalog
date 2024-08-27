final class stud{
    //methods cannot be extended to its sub class
}
public class books extends stud {
    void show()
    {
        System.out.println("Book class method");
    }
    public static void main(String[] args) {
        books b1=new books();
        b1.show();
    }
}
