class SleepExp1 extends Thread{
    public void run(){
        for(int i=1; i<15; i++){
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
            System.out.println(i);
            System.out.println("Current thread name: "+Thread.currentThread().getName());
            System.out.println("Current thread ID: "+Thread.currentThread().threadId());  //getID?
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        SleepExp1 thread1=new SleepExp1();
        SleepExp1 thread2=new SleepExp1();
        thread1.start();
        thread2.start();
    }
}
