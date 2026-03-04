package threads.basics;

class Demo1 extends Thread
{
    public void run()
    {
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

class Demo2 extends Thread
{
    public void run()
    {
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

public class ExtentsThreadDemo {
    public static void main(String[] args){
        Demo1 dm1 = new Demo1();
        Demo2 dm2 = new Demo2();

        dm1.start();
        dm2.start();
    }
}
