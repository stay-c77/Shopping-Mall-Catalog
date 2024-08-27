class Outer2{
    static int id=11;
    static String name="Adil";
    static class Inner{
        static void display(){
            System.out.println("ID is: "+id);
            System.out.println("Name is: "+name);
        }
    }
    public static void main(String args[]){
        Outer2.Inner obj=new Outer2.Inner();
        Outer2.Inner.display();
    }
}