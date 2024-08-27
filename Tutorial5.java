import java.util.*;
class Person
{
    String name, sex;
    int age;
    Scanner s=new Scanner(System.in);
    public void getPerson()
    {
        System.out.println("Enter name:");
        name=s.nextLine();
        System.out.println("Enter age:");
        age=s.nextInt();
        System.out.println("Enter sex:");
        s.nextLine();
        sex=s.nextLine();
    }
}
class Employee extends Person
{
    int empid, year, month;
    String department;
    Scanner s=new Scanner(System.in);
    public void getEmployee()
    {
        System.out.println("Enter employee id:");
        empid=s.nextInt();
        System.out.println("Enter department:");
        s.nextLine();
        department=s.nextLine();
        Calendar c= Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=(c.get(Calendar.MONTH))+1;
    }
}
class Fulltime extends Employee
{
    int salary, y_o_j, basic_pay=30000, m_o_j, totalyears, totalmonths;
    Scanner s=new Scanner(System.in);
    public void getFulltime()
    {
        System.out.println("Enter year of joining:");
        y_o_j=s.nextInt();
        System.out.println("Enter month of joining (in numbers):");
        m_o_j=s.nextInt();
    }
    public void calculateFt()
    {
        totalyears=(year-y_o_j);
        if(m_o_j>month){
            totalyears-=1;
            totalmonths=(totalyears*12)+(12-m_o_j+month);
        }
        else{
            totalmonths=(totalyears*12)+(month-m_o_j);
        }
        if(totalmonths<12){
            totalmonths=12;
        }
        salary=basic_pay*totalmonths/12;
        System.out.println("Salary is "+salary);
    }
    public void display()
    {
        System.out.println("**Employee Details**\nName:"+name+"\nAge:"+age+"\nSex:"+sex);
        System.out.println("ID:"+empid+"\nDepartment:"+department);
        System.out.println("Year of joining:"+y_o_j+"\nMonth of joining:"+m_o_j+"\nSalary:"+salary);
    }
}
class Parttime extends Employee
{
    int hour_rate=750,salary, y_o_j, hours, totalmonths, totalyears, m_o_j;
    Scanner s=new Scanner(System.in);
    public void getParttime()
    {
        System.out.println("Enter year of joining");
        y_o_j=s.nextInt();
        System.out.println("Enter month of joining (in numbers):");
        m_o_j=s.nextInt();
        System.out.println("Enter amount of hours worked last month:");
        hours=s.nextInt();
    }
    public void calculatePt()
    {
        totalyears=(year-y_o_j);
        if(m_o_j>month){
            totalyears-=1;
            totalmonths=(totalyears*12)+(12+month-m_o_j);
        }
        else{
            totalmonths=(totalyears*12)+(month-m_o_j);
        }
        if(totalmonths<12){
            totalmonths=12;
        }
        salary=hour_rate*totalmonths*hours/12;
        System.out.println("Salary is "+salary);
    }
    public void display()
    {
        System.out.println("\n**Employee Details**\nName:"+name+"\nAge:"+age+"\nSex:"+sex);
        System.out.println("ID:"+empid+"\nDepartment:"+department);
        System.out.println("Year of joining:"+y_o_j+"\nMonth of joining:"+m_o_j+"\nHours worked last month:"+hours+"\nSalary:"+salary);
    }
}
class Tutorial5
{
    public static void main(String[] args) {
        Fulltime f[] = new Fulltime[20];
        Parttime p[] = new Parttime[20];
        int ft=0, pt=0, ch, n;
        Scanner s=new Scanner(System.in);
        while(true)
        {
            System.out.println("**MENU**\n1. Add Full Time Employee\n2. Add Part Time Employee\n3. Display Full Time Employees\n4. Display Part Time Employees\n5. Exit\nSelect your choice:");
            ch=s.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter number of employees to enter:");
                    n=s.nextInt();
                    for(int i=0; i<n; i++)
                    {
                        f[ft]=new Fulltime();
                        f[ft].getPerson();
                        f[ft].getEmployee();
                        f[ft].getFulltime();
                        f[ft].calculateFt();
                        ft++;
                    }
                    System.out.println("Data entered");
                    break;
                case 2:
                    System.out.println("Enter number of employees to enter:");
                    n=s.nextInt();
                    for(int i=0; i<n; i++)
                    {
                        p[pt]=new Parttime();
                        p[pt].getPerson();
                        p[pt].getEmployee();
                        p[pt].getParttime();
                        p[pt].calculatePt();
                        pt++;
                    }
                    System.out.println("Data entered");
                    break;
                case 3:
                    for(int i=0; i<ft; i++)
                    {
                        f[i].display();
                    }
                    break;
                case 4:
                    for(int i=0; i<pt; i++)
                    {
                        p[i].display();
                    }
                    break; 
                case 5:
                    System.out.println("Exited");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}