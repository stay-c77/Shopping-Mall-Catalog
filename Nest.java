class OuterClass{
    private int a;
    OuterClass(){
        a=100;    
    }
    void methodofOuter(){
        System.out.println("Outer class");
    }
    class InnerClass{
        int b;
        InnerClass(){
            b=200;    
        }
        public void methodofInner(){
            System.out.println("Inner class a is "+a+" and value of b is "+b);
        }
    }
}

public class Nest 
{
    public static void main(String[] args){
        OuterClass objOuter=new OuterClass();
        OuterClass.InnerClass objInner=objOuter.new InnerClass();   //syntax is like this as it is called in a different class
        objOuter.methodofOuter();
        objInner.methodofInner();
    }
}
