package interfacedefault.abstractclass;

interface Plugin{
    void execute();
}

class CoreSystem {
    private Plugin[] array;  //instance

    CoreSystem(Plugin[] plugins) {   //constructorr

        this.array = plugins;
    }

    void run() {
        for(Plugin plugin : this.array) {
            plugin.execute();
        }
    }
}

public class InterfacePlugin {
    public static void main(String[] args) {
        Plugin[] plugins = new Plugin[]{

                new Plugin() {
                    @Override
                    public void execute() {
                        System.out.println("executed 1");
                    }
                },
                new Plugin() {
                    @Override
                    public void execute() {
                        System.out.println("executed 2");
                    }
                },
                new Plugin() {
                    @Override
                    public void execute() {
                        System.out.println("executed 3");
                    }
                }
        };
        CoreSystem out = new CoreSystem(plugins);
        out.run();
    }

}
