import java.util.Scanner;
class Train
{
static int train_no=11650;
static String place="KOTTAYAM";
String name;
int ava_seat;
int no_seat;
int total;
void assignData()
{
Scanner s=new Scanner(System.in);
System.out.println("ENTER NAME:");
name=s.next();
System.out.println("NO OF AVAILABLE SEATS:");
ava_seat=s.nextInt();
System.out.println("NO OF SEAT NEEDED:");
no_seat=s.nextInt();
}
static void change()
{
train_no=train_no+1;
place="ERNAKULAM";
}
void cal()
{
total=ava_seat-no_seat;
}
void Display()
{
System.out.println("TRAIN_NO"+train_no);
System.out.println("NAME:"+name);
System.out.println("REMAINING SEATS:"+total);
System.out.println("BOOKED SEAT:"+no_seat);
System.out.println("PLACE:"+place);
}
class Date
{
int dd;
int mm;
int yy;
void data()
{
Scanner d=new Scanner(System.in);
System.out.println("ENTER DAY:");
dd=d.nextInt();
System.out.println("ENTER MONTH:");
mm=d.nextInt();
System.out.println("ENTER YEAR:");
yy=d.nextInt();
}
void Displayd()
{
System.out.println(dd+"/"+mm+"/"+yy);
}
}
}
class Tutorial6
{
public static void main(String[] args)
{
Train k=new Train();
Train.Date l=k.new Date();
System.out.println("ENTER DATE DEPARTURE:");
System.out.println("_______________________");
l.data();
l.Displayd();
System.out.println("_______________________");
k.assignData();
k.cal();
k.Display();
System.out.println("_______________________");
System.out.println("ENTER DATE ARRIVAL:");
l.data();
l.Displayd();
System.out.println("_______________________");
Train.change();
k.assignData();
k.cal();
k.Display();
System.out.println("_______________________");
}
}

