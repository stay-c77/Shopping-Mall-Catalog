public class Employee 
{
    final static double salary;
    static{
        salary=9999.99;
    }    
    /*void change()
    {
        salary+=1000;
    } */
    public static void main(String[] args) {
        //Employee e=new Employee();
        //System.out.println(e.salary);
        System.out.println(Employee.salary);
    }
}
