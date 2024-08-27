public class MyException2 extends Exception{
    int acc_bal=0;
    public String toString(){
        return "Cannot debit. Low Account Balance.";
    }
    public static void main(String[] args) {
        MyException2 ob=new MyException2();
        try{
            ob.withdraw(100);
        }
        catch(MyException2 e){
            System.out.println("Exception handles-" +e);
        }
    }
    public void withdraw(int debitMoney) throws MyException2{
        if(acc_bal>1000){
            acc_bal=acc_bal-debitMoney;
        }
        else{
            throw new MyException2();
        }
    }
}
