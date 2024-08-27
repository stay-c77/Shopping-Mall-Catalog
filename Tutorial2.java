import java.util.Scanner;

class BankAccount
{
    String name, actype;
    int acno;
    double balance, maxam;
    BankAccount(String name, int acno)
    {
        this.name=name;
        this.acno=acno;
        this.actype="L";
        this.balance=0.0;
        this.maxam=-10000.0;
    }
    BankAccount(int acno)
    {
        this.name="Stephen";
        this.acno=acno;
        this.actype="S";
        this.balance=900.0;
        this.maxam=-10000.0;
    }
    BankAccount(String name, int acno, String actype, double balance)
    {
        this.name=name;
        this.acno=acno;
        this.actype=actype;
        this.balance=balance;
        this.maxam=-10000.0;
    }
    public void deposit(double am) 
    {
        if (am > 0) 
        {
            balance += am;
            if (actype.equals("L") && balance >= 0) 
            {
                actype="S";
                System.out.println("Account converted to savings account.");
            }
            System.out.println("Deposit successfully. New balance is " + balance);
        } 
        else 
        {
            System.out.println("Invalid amount.");
        }
    }
    public void withdraw(double am) 
    {
        if (am > 0) 
        {
            if (actype.equals("S"))
            {
                balance -= am;
                if(balance<0) 
                {
                    System.out.println("The account has been converted to loan account.");
                    actype = "L";
                    System.out.println("Withdrawal successful. New balance is " + balance);
                }
                else
                {
                    System.out.println("Withdrawal successful. New balance is " + balance);
                }
                
            } 
            else
            {
                if (balance > maxam) 
                {
                    balance -= am;
                    System.out.println("Withdrawal successful. New balance is " + balance);
                } 
                else 
                {
                    System.out.println("Warning: Amount is more than maximum withdrawal limit");
                }
            }
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public double checkBalance() 
    {
        return balance;
    }

    public void display() 
    {
        System.out.println("Account Information:");
        System.out.println("Account Number: " + acno);
        System.out.println("Depositor Name: " + name);
        System.out.println("Account Type: " + actype);
        System.out.println("Balance: " + balance);
    }
}

public class Tutorial2 
{
    public static void main(String[] args) 
    {
        BankAccount b1=new BankAccount(12345); 
        BankAccount b2=new BankAccount("Simone", 9876);
        BankAccount acc=null;
        int acno, ch, choice, op;
        Boolean flag;
        String name, actype;
        Double balance;
        Scanner s=new Scanner(System.in);
        System.out.println("**Welcome**\n Press 1 to create a new account or 0 to refer an existing account?");
        op=s.nextInt();
        s.nextLine();
        flag=true;
        if (op==1)
        {
            System.out.println("Enter account details\nEnter name: ");
            name=s.nextLine();
            System.out.println("Enter account number: ");
            acno=s.nextInt();
            s.nextLine();
            System.out.println("Enter type of account- S for savings account and L for loan account: ");
            actype=s.nextLine();
            if (actype.equals("S"))
            {
                System.out.println("Enter balance: ");
                balance=s.nextDouble();
                BankAccount b3=new BankAccount(name, acno, actype, balance);
                acc=b3;
            }
            else if (actype.equals("L"))
            {
                balance=0.0;
                BankAccount b3=new BankAccount(name, acno, actype, balance);
                acc=b3;
            }
            else
            {
                System.out.println("Invalid input");
            }     
        }
        else if(op==0)
        {
           while(flag)
           {
                System.out.println("Enter account number:");
                ch=s.nextInt();
                if(b1.acno==ch)
                {
                    acc=b1;
                    flag=false;
                }
                else if(b2.acno==ch)
                {
                    acc=b2;
                    flag=false;
                }
                else
                {
                    System.out.println("Invalid account number");
                }
            }
        }
        else
        {
            System.out.println("Invalid input");
        }
        do 
        {
            System.out.println("\n--Menu--\n1.Deposit\n2.Withdraw\n3.Check Balance\n4.Display Information\n5.Exit\nEnter your choice: ");
            choice = s.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = s.nextDouble();
                    acc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double w = s.nextDouble();
                    acc.withdraw(w);
                    break;
                case 3:
                    System.out.println("Current balance is " + acc.checkBalance());
                    break;
                case 4:
                    acc.display();
                    break;
                case 5:
                    System.out.println("Exited bank. Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 5);
    }
}
