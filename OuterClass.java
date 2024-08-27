public class OuterClass
{
    //method of  outerclass
    void methodofOuter()
    {
        System.out.println("Outer class");
    }
    class InnerClass
    {
        void methodofInner()
        {
            System.out.println("Inner class");
        }
    }

    public static void main(String[] args)
    {
        OuterClass objOuter=new OuterClass();
        InnerClass objInner=objOuter.new InnerClass();  //syntax is like this as psvm is called in the same class
        objOuter.methodofOuter();
        objInner.methodofInner();
    }
}