package Exception.Handling;

class Resource implements AutoCloseable {

    public Resource() {
        System.out.println("Resource opened");
    }

    public void doWork() {
        System.out.println("Resource is working");
    }

    @Override
    public void close() {
        System.out.println("Resource closed");
    }
}

public class AutoCloseDemo {

    public static void main(String[] args) {

        try (Resource r = new Resource()) {

            r.doWork();

            // Force an exception
            int x = 10 / 0;

        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }

        System.out.println("Program continues...");
    }
}

