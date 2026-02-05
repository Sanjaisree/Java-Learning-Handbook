package interfacedefault.abstractclass;

interface Camera{
    void initial();
    void photo();
}
interface MusicPlayer{
    void initial();
    void play();
}
interface Phone{
    void initial();
    void call();
}
class SmartPhone implements Camera,MusicPlayer,Phone{
    @Override
    public void initial() {
        System.out.println("This runs despite all interface has initialise because =interface doesnot provide implementation unless default ");
    }
    @Override
    public void photo() {
        System.out.println("photo");
    }
    @Override
    public void play() {
        System.out.println("music  works due to overriding");
    }
    @Override
    public void call() {
        System.out.println("Calling is done ");
    }

}
public class MultipleInterfaces {
    public static void main(String[] args) {
        SmartPhone phone =new SmartPhone();
        phone.initial();
        phone.play();
        phone.call();
        phone.photo();

    }
}
