import java.util.Scanner;
class Person
{
    String name,sex;
    int age;
    Scanner in=new Scanner(System.in);

    Person()
    {
        System.out.println("Enter the employee's name:");
        name=in.next();
        System.out.println("Enter the employee's age:");
        age=in.nextInt();
        System.out.println("Enter the employee's sex:");
        sex=in.next();
    }
}
class Employee extends Person
{
    String emp_id,dep;
    int y_o_j,m_o_j;
    float salary;

    void get()
    {
        System.out.println("Enter the employee id:");
        emp_id=in.next();
        System.out.println("Enter the employee department:");
        dep=in.next();
        System.out.println("Enter the employees year of joining");
        y_o_j=in.nextInt();
        System.out.println("Enter the employees month of joining");
        m_o_j=in.nextInt();
    }
    void show()
    {
        System.out.println("EMPLOYEE DETAILS\n__\nEmployee ID :"+emp_id+"\nEmployee name:"+name+"\nAge :"+age+"\nSex :"+sex+"\nDepartment :"+dep);
        System.out.println("Time of joining(MM/YY) :"+m_o_j+"/"+y_o_j);
        System.out.println("Salary :"+salary+"\n__");
    }
}
class Full_time extends Employee
{
    int basic_pay;
    Full_time()
    {
        get();
        System.out.println("Enter the employees basic pay");
        basic_pay=in.nextInt();
    }
    void calPay()
    {
        int curr_year=2024,curr_month=3;
        float total_m=(curr_year-y_o_j)*12+(curr_month-m_o_j);
        salary=(total_m/12)*basic_pay;
        show();
    }
   
}
class Part_time extends Employee
{
    int hourly_pay,hours;
    Part_time()
    {
        get();
        System.out.println("Enter the employees hourly pay");
        hourly_pay=in.nextInt();
        System.out.println("Enter number of hours worked ");
        hours=in.nextInt();

    }
    void calPay()
    {
        int curr_year=2024,curr_month=3;
        float total_m=(curr_year-y_o_j)*12+(curr_month-m_o_j);
        salary=((total_m/12)*10+hourly_pay)*hours;
        show();
    }   
}


public class Tutorial5Binsa
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int i=1;
        while(i==1)

        {
            System.out.println("Enter \n1 Fulltime Employee\n2 Partime Employee \n3 Exit");
            int x=in.nextInt();
            switch(x)
            {
                case 1:
                System.out.println("\nEnter the fulltime employee's details");
                Full_time f=new Full_time();
                f.calPay();
                break;

                case 2:
                System.out.println("\nEnter the partime employee's details");
                Part_time p=new Part_time();
                p.calPay();
                break;

                case 3:
                System.out.println("Program has been exited");
                i=0;

            }
        }
    }
}