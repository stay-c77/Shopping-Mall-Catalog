import java.util.Scanner;
class Person{
    String category;
}
class Student extends Person{
    int regno, yearOfJoining;
    String name, address;
    void getStudentDetails(){
        category="Student";
        Scanner s=new Scanner(System.in);
        System.out.println("Enter name:");
        name=s.nextLine();
        System.out.println("Enter address:");
        address=s.nextLine();
        System.out.println("Enter registration number:");
        regno=s.nextInt();
        System.out.println("Enter year of joining:");
        yearOfJoining=s.nextInt();
    }
    void display(){
        System.out.println("Name:"+name+"\nAddress:"+address+"\nRegistration number:"+regno+"\nYear of joining:"+yearOfJoining);
    }
}
class Marks extends Student{
    int m1,m2,m3;
    void getMarkDetails(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter mark 1:");
        m1=s.nextInt();
        System.out.println("Enter mark 2:");
        m2=s.nextInt();
        System.out.println("Enter mark 3:");
        m3=s.nextInt();
    }
}
class Result extends Marks{
    int tot;
    String grade;
    void computeGrade(){
        tot=m1+m2+m3;
        int avg=tot/3;
        if(avg>=50){
            grade="Pass";
        }
        else{
            grade="Fail";
        }
        System.out.println("Grade:" +grade);
    }
}
class Staff extends Person{
    int id, dateOfJoining;
    String name;
    void getData(){
        category="Staff";
        Scanner s=new Scanner(System.in);
        System.out.println("Enter name:");
        name=s.nextLine();
        System.out.println("Enter id:");
        id=s.nextInt();
        System.out.println("Enter date of joining:");
        dateOfJoining=s.nextInt();
    }
}
class Teaching extends Staff{
    String qualification, skills, areaofinterest;
    void getPersonalDetails(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter qualification:");
        qualification=s.nextLine();
        System.out.println("Enter skills:");
        skills=s.nextLine();
        System.out.println("Enter area of interest:");
        areaofinterest=s.nextLine();
    }
    void display(){
        System.out.println("**Staff Details**\nName:"+name+"\nID:"+id+"\nDate of joining:"+dateOfJoining);
        System.out.println("Qualification:"+qualification+"\nSkills:"+skills+"\nArea Of Interest:"+areaofinterest);
    }
}
class NonTeaching extends Staff{
    int yearsOfExperience;
    String certification, expertise;
    void inputdata(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter certification:");
        certification=s.nextLine();
        System.out.println("Enter expertise:");
        expertise=s.nextLine();
        System.out.println("Enter years of experience:");
        yearsOfExperience=s.nextInt();
    }
    void showdata(){
        System.out.println("**Staff Details**\nName:"+name+"\nID:"+id+"\nDate of joining:"+dateOfJoining);
        System.out.println("Certification:"+certification+"\nExpertise:"+expertise+"\nYears of experience:"+yearsOfExperience);
    }
}
class Tutorial7{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int ch, t=1;
        while(t==1){
            System.out.println("**MENU**\n1. Student\n2. Teaching staff\n3. Non Teaching Staff\n4. Exit\nSelect your choice");
            ch=s.nextInt();
            switch (ch) {
                case 1:
                    Result r=new Result();
                    r.getStudentDetails();
                    r.getMarkDetails();
                    r.computeGrade();
                    break;
                case 2:
                    Teaching t1=new Teaching();
                    t1.getData();
                    t1.getPersonalDetails();
                    t1.display();
                    break;
                case 3:
                    NonTeaching t2=new NonTeaching();
                    t2.getData();
                    t2.inputdata();
                    t2.showdata();
                    break;
                case 4:
                    System.out.println("Exited");
                    t=0;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}