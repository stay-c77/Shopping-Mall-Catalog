//default constructor 2 type: by java and by user
class Student
{
    String name;    //String is initialized as null
    int roll;       //Integer is initialized as 0
    // Student()
    // {
    //     name="Stacey";
    //     roll=67;
    // }                //Second type of default constructor
    public void showData()
    {
        System.out.println(name); 
        System.out.println(roll);    
    }
}
class StudentDetails
{
    public static void main(String[] args)
    {
        Student s=new Student();
        s.showData();
    }
}