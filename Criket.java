class Game{
    public void type(){
        System.out.println("Indoor and outdoor");
    }
}
public class Criket extends Game{
    public void type(){
        System.out.println("Outdoor game");
    }
    public static void main(String[] args) {
        Game gm=new Game();
        Criket ck=new Criket();
        gm.type();
        ck.type();
        gm=ck;    //upcasting refers to criket object
        gm.type();
    }
}
