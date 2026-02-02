package classes.statics.patterns;

public class ObjectCounter {
 static int counter = 0;

 public ObjectCounter() {
     counter++;
 }

    public static void main(String[] args) {
        new ObjectCounter();
        new ObjectCounter();
        new ObjectCounter();
        new ObjectCounter();

        System.out.println("number of instance created : "+ObjectCounter.counter);//bcz what if the count is from different class
    }
}
