package threads.basics;

class Demo3 implements Runnable{
    public void run(){
        System.out.println("Demo 1 start");
        for(int i=0;i<=6;i++){
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Demo 1 end");
    }
}
class Demo4 implements Runnable{
    public void run(){
        System.out.println("Demo 2 character printing ");
        for(int i=65;i<=70;i++){
            System.out.println((char)i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Demo 2 character printing ended");
    }
}

public class ImplementsThreadDemo {
    public static void main(String[] args) {
        Demo3 dem3 = new Demo3();
        Demo4 dem4 = new Demo4();

        Thread demo3 = new Thread(dem3);
        Thread demo4 = new Thread(dem4);

        demo3.start();
        demo4.start();
    }
}
