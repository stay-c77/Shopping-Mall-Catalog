/*Create a Time object with Hour, Minute and second instance variable. Perform addition of two time objects with following requirements 
1) object passed as arguments(t3.addTime(t1,t2) 
2) return object from a function t3=t2.addTime(t1) 
3)explain about method overloading and understand how it is used in this program 
4) Explain call by reference  concepts related to this program */

class Time
{
    int hour, minute,second;
    Time(int hour, int minute, int second) 
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    static Time addTime(Time obj1,Time obj2)
    {
        int h=obj1.hour+obj2.hour;
        int m=obj1.minute+obj2.minute;
        int s=obj1.second+obj2.second;
        if (s>=60)
        {
            m+=(s/60);
            s=s%60;
        }
        if (m>=60)
        {
            h+=(m/60);
            m=m%60;
        }
        return new Time(h, m, s);
    }
    public Time addTime(Time obj)
    {
        int h=this.hour+obj.hour;
        int m=this.minute+obj.minute;
        int s=this.second+obj.second;
        if (s>=60)
        {
            m+=(s/60);
            s=s%60;
        }
        if (m>=60)
        {
            h+=(m/60);
            m=m%60;
        }
        return new Time(h, m, s);
    }
    public void display()
    {
        System.out.println(hour+":"+minute+":"+second);
    }
}
class Tutorial4
{
    public static void main(String[] args)
    {
        Time t1=new Time(12, 7, 45);
        Time t2=new Time(6, 6, 30);
        System.out.println("Object passed as argument");
        Time t3= Time.addTime(t1, t2);
        t3.display();
        System.out.println("Return object from a function");
        Time t4=t2.addTime(t1);
        t4.display();
    }
}