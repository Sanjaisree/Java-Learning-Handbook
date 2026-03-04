package threads.basics;

class Demo5 extends Thread{
    public void run(){
        System.out.println("user thread starts");
        for(int i=0;i<6;i++){
            System.out.println("user thread running:"+i);
            try{
                Thread.sleep(2500);
            }catch(InterruptedException e){
                throw  new RuntimeException(e);
            }
        }
        System.out.println("user thread ends");
    }
}
class Demo6 extends Thread{
    public void run(){
        System.out.println("Daemond thread starts");
        for(; ;){
            System.out.println("Demond thread running.......");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                throw  new RuntimeException(e);
            }
        }
        //System.out.println("Daemond thread ends");
    }
}
public class DaemonThreadDemo {
    public static void main(String[] args){
        System.out.println("Main thread starts");
        Demo5 dem5=new Demo5();
        dem5.start();

        Demo6 dem6=new Demo6();
        dem6.setDaemon(true);
        dem6.start();

        System.out.println("Main thread ends");
    }
}
