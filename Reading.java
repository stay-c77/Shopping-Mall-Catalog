interface Book{
    String name="Sherlock Holmes";
    String genre="mystery";
    public void read();
}
class Reading implements Book{
    public void read(){
        System.out.println("I am reading "+name+". It is a "+genre+" book");
    }
    public static void main(String[] args) {
        Reading r=new Reading();
        r.read();
    }
}
