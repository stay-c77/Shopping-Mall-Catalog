import java.util.Scanner;

class Person
{
    int age;
    String name, sex;
}

class Employee extends Person
{
    String empid;
    String dept;
    int y_join, m_join;
    int hours;
    Scanner s = new Scanner(System.in);

    public void getInfoFt()
    {
        System.out.println("Name of the Employee: ");
        name = s.next();
        System.out.println("Age of the Employee: ");
        age = s.nextInt();
        System.out.println("Sex: ");
        sex = s.next();
        System.out.println("Employee ID of the Employee: ");
        empid = s.next();
        System.out.println("Department of the employee: ");
        dept = s.next();
        System.out.println("Enter Year of Joining: ");
        y_join = s.nextInt();
        System.out.println("Enter Month of joining: ");
        m_join = s.nextInt();
    }

    public void getInfoPt()
    {
        System.out.println("Name of the Employee: ");
        name = s.next();
        System.out.println("Age of the Employee: ");
        age = s.nextInt();
        System.out.println("Sex: ");
        sex = s.next();
        System.out.println("Employee ID of the Employee: ");
        empid = s.next();
        System.out.println("Department of the employee: ");
        dept = s.next();
        System.out.println("Enter Year of Joining: ");
        y_join = s.nextInt();
        System.out.println("Enter Month of joining: ");
        m_join = s.nextInt();
        System.out.println("Enter the amount of hours worked: ");
        hours = s.nextInt();
    }
}

class FullTime extends Employee
{
    double salary;
    double basic_pay = 22500;
    double sal_ft;
    
    public void calcSalFulltime()
    {
        double TotalMonths = ((2024 - y_join) * 12) + m_join;
        sal_ft = (basic_pay * TotalMonths) / 12;
        System.out.println("Salary of this Employee is: "+sal_ft);
    }

    public void displayFt()
    {
        System.out.println("|| EMPLOYEE DETAILS ||");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Sex: "+sex);
        System.out.println("Employee ID: "+empid);
        System.out.println("Department: "+dept);
        System.out.println("Salary: "+sal_ft+"\n");
    }
}

class PartTime extends Employee
{
    double hour_rate = 1500;
    double sal_pt;

    public void calcSalParttime()
    {
        double TotalMonths = ((2024 - y_join) * 12) + m_join;
        sal_pt = (TotalMonths / 12) * hour_rate * hours;
        System.out.println("Salary of this Employee is: "+sal_pt);
    }

    public void displayPt()
    {
        System.out.println("|| EMPLOYEE DETAILS ||");
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Sex: "+sex);
        System.out.println("Employee ID: "+empid);
        System.out.println("Department: "+dept);
        System.out.println("Salary: "+sal_pt+"\n");
    }
}

class hank
{
    public static void main(String args[])
    {
        FullTime ft[] = new FullTime[30];
        PartTime pt[] = new PartTime[30];
        int ft_count = 0;
        int pt_count = 0;
        Scanner scan = new Scanner(System.in);
        while (true)
        {
            System.out.println("|| MENU ||");
            System.out.println("1. Add Fulltime-Employee");
            System.out.println("2. Add Parttime-Employee");
            System.out.println("3. Display all Fulltime-Employees");
            System.out.println("4. Display all Parttime-Employees");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice = scan.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("Enter the number of employees that need to be entered: ");
                    ft_count = scan.nextInt();
                    for(int i=0;i<ft_count;i++)
                    {
                        ft[i] = new FullTime();
                    }
                    for(int i=0;i<ft_count;i++)
                    {
                        ft[i].getInfoFt();
                        ft[i].calcSalFulltime();
                    }
                    System.out.println("Data Added Successfully!");
                    break;
                case 2:
                    System.out.println("Enter the number of employees that need to be entered: ");
                    pt_count = scan.nextInt();
                    for(int i=0;i<pt_count;i++)
                    {
                        pt[i] = new PartTime();
                    }
                    for(int i=0;i<pt_count;i++)
                    {
                        pt[i].getInfoPt();
                        pt[i].calcSalParttime();
                    }
                    System.out.println("Data Added Successfully!");
                    break;
                case 3:
                    System.out.println("|| FULL TIME EMPLOYEES LISTED ||\n");
                    for(int i=0;i<ft_count;i++)
                    {
                        if (ft[i] != null)
                        {
                            ft[i].displayFt();
                        }
                    }
                    break;
                case 4:
                    System.out.println("|| PART TIME EMPLOYEES LISTED ||\n");
                    for(int i=0;i<pt_count;i++)
                    {
                        if (pt[i] != null)
                        {
                            pt[i].displayPt();
                        }
                        
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program... ");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, Please enter a valid number between 1-5!");
            }
        }
    }
}