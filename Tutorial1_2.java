class Student
{
    String name, city;
    int age;
    Student()
    {
        name="Stan";
        city="Bangalore";
        age=21;
    }
    public void printData()
    {
        System.out.println("Name is "+name+"\nCity is "+city+"\nAge is "+age+"\n");
    }
}
class Tutorial1_2
{
    public static void main(String[] args)
    {
        Student s1=new Student();
        s1.printData();
        Student s2=new Student();
        s2.printData();
    }
}