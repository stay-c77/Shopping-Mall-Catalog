interface Motorbike{
    int speed=50;
    public void totalDistance();
}
interface Cycle{
    int distance=150;
    public void speed();
}
public class TwoWheeler implements Motorbike, Cycle{
    int totalDistance, avgSpeed;
    public void totalDistance(){
        totalDistance=speed*distance;
        System.out.println("Total Distance Travelled:"+totalDistance);
    }
    public void speed(){
        avgSpeed=totalDistance/speed;
        System.out.println("Average Speed Maintained:"+avgSpeed);
    }
    public static void main(String[] args){
        TwoWheeler t1=new TwoWheeler();
        t1.totalDistance();
        t1.speed();
    }
}