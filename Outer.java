class Outer{
    static int id=11;
    static String name="Adil";
    static class Inner{
        void display(){
            System.out.println("ID is: "+id);
            System.out.println("Name is: "+name);
        }
    }
    public static void main(String args[]){
        Outer.Inner obj=new Outer.Inner();
        obj.display();
    }
}