class Student
{
    int sum;
    void sumMarks(int m1, int m2, int m3)
    {
        sum=m1+m2+m3;
        System.out.println("Sum is "+sum);
    }
    void sumMarks(int m1, int m2)
    {
        sum=90+m1+m2;
        System.out.println("Sum is "+sum);
    }
}
class MethodOverload
{
    public static void main(String[] args)
    {
        Student s1=new Student();
        s1.sumMarks(100,80,40);
        Student s2=new Student();
        s2.sumMarks(100,99);
    }
}