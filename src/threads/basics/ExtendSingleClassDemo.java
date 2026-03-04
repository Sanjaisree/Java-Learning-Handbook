package threads.basics;

class Demo extends Thread{
    public void run(){
        Thread a = Thread.currentThread();
        String name = a.getName();

        if(name.equals("Number")){
            numbers();
        }
        else{
            abcd();
        }
    }
    public void numbers(){
        System.out.println("numbers started printing");
        for(int i=0;i<=6;i++){
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("numbers end");
    }
    public void abcd(){
        System.out.println("character printing ");
        for(int i=65;i<=70;i++){
            System.out.println((char)i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("character printing ended");
    }

}
public class ExtendSingleClassDemo {
    public static void main(String[] args) {
        Demo dem1 = new Demo();
        Demo dem2 = new Demo();

        dem1.setName("Number");
        dem2.setName("Abcd");
        dem1.start();
        dem2.start();

    }
}
